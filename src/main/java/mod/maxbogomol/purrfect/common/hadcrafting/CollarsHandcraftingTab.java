package mod.maxbogomol.purrfect.common.hadcrafting;

import com.mojang.blaze3d.systems.RenderSystem;
import mod.maxbogomol.fluffy_fur.common.block.entity.BlockSimpleInventory;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTab;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTabComponent;
import mod.maxbogomol.purrfect.client.gui.screen.HandcraftingTableScreen;
import mod.maxbogomol.purrfect.common.gui.menu.HandcraftingTableMenu;
import mod.maxbogomol.purrfect.common.gui.tooltip.HandcraftingRecipeTooltipComponent;
import mod.maxbogomol.purrfect.common.hadcrafting.component.CollarsHandcraftingTabComponent;
import mod.maxbogomol.purrfect.common.item.equipment.SillyTagItem;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.common.network.block.HandcraftingCollarCraftPacket;
import mod.maxbogomol.purrfect.common.network.block.HandcraftingCollarTagPacket;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingCollarsRecipe;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingIngredient;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingSortingRecipe;
import mod.maxbogomol.purrfect.registry.common.PurrfectCollarParts;
import mod.maxbogomol.purrfect.registry.common.PurrfectRecipes;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class CollarsHandcraftingTab extends HandcraftingTab {
    public final ResourceLocation COLLAR_SLOT_TEXTURE = new ResourceLocation(Purrfect.MOD_ID, "textures/gui/collar_handcrafting_slot.png");
    public final ResourceLocation TAG_SLOT_TEXTURE = new ResourceLocation(Purrfect.MOD_ID, "textures/gui/silly_tag_handcrafting_slot.png");
    public static Supplier<ItemStack> ICON = () -> {
        ItemStack collar = new ItemStack(PurrfectItems.COLLAR.get());
        CollarItem.setAccessory(collar, PurrfectCollarParts.GOLDEN_BELL);
        return collar;
    };

    public static List<HandcraftingCollarsRecipe> allRecipes = new ArrayList<>();
    public static List<HandcraftingCollarsRecipe> sortedRecipes = new ArrayList<>();
    public List<HandcraftingCollarsRecipe> matchedRecipes = new ArrayList<>();
    public HandcraftingCollarsRecipe selectedRecipe = null;
    public HandcraftingCollarsRecipe hoveredRecipe = null;
    public List<Integer> selectedRecipeMatchedSlots = new ArrayList<>();
    public int scroll = 0;
    public boolean isMatched = false;

    public CollarsHandcraftingTab(String id, Supplier<ItemStack> iconItemStack) {
        super(id, iconItemStack);
    }

    @Override
    public HandcraftingTabComponent getComponent() {
        return new CollarsHandcraftingTabComponent();
    }

    public CollarsHandcraftingTabComponent getComponent(HandcraftingTableMenu menu) {
        if (menu.tabComponent instanceof CollarsHandcraftingTabComponent collarsHandcraftingTabComponent) {
            return collarsHandcraftingTabComponent;
        }
        return new CollarsHandcraftingTabComponent();
    }

    @Override
    public void createMenu(HandcraftingTableMenu menu) {
        getComponent(menu).inputSlots = new SimpleContainer(2) {
            public void setChanged() {
                super.setChanged();
                menu.slotsChanged(this);
            }
        };
        getComponent(menu).resultSlot = new ResultContainer();

        menu.addSlot(new Slot(getComponent(menu).inputSlots, 0, 8, 126) {
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem().equals(PurrfectItems.COLLAR.get());
            }

            public void onTake(Player player, ItemStack stack) {
                getComponent(menu).resultSlot.clearContent();
                getComponent(menu).recipe = null;
                selectedRecipe = null;
            }
        });
        menu.addSlot(new Slot(getComponent(menu).inputSlots, 1, 8, 108) {
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem().equals(PurrfectItems.SILLY_TAG.get());
            }
        });
        menu.addSlot(new Slot(getComponent(menu).resultSlot, 2, 62, 126) {
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            public boolean mayPickup(Player player) {
                return canCraftRecipe(player, player.level(), getComponent(menu).recipe);
            }

            public void onTake(Player player, ItemStack stack) {
                craftRecipe(player, player.level(), getComponent(menu).recipe);
                getComponent(menu).inputSlots.setItem(0, ItemStack.EMPTY);
                getComponent(menu).recipe = null;
                selectedRecipe = null;
            }
        });
    }

    @Override
    public void removedMenu(HandcraftingTableMenu menu, Player player) {
        menu.clearContainer(player, getComponent(menu).inputSlots);
        selectedRecipe = null;
    }

    @Override
    public int getInventorySize(HandcraftingTableMenu menu) {
        return 3;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void init(HandcraftingTableScreen screen) {
        matchedRecipesUpdate();
        selectedRecipe = null;
        scroll = 0;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void tick(HandcraftingTableScreen screen) {
        matchedRecipesUpdate();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderBackground(HandcraftingTableScreen screen, GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        List<HandcraftingCollarsRecipe> recipes = sortedRecipes;
        if (isMatched) recipes = matchedRecipes;

        RenderSystem.enableBlend();

        int ii = scroll * 8;
        for (int si = 0; si < 5; si++) {
            for (int sj = 0; sj < 8; sj++) {
                gui.blit(GUI, i + 7 + (sj * 18), j + 17 + (si * 18), 176, 60, 18, 18, 256, 256);
                if (recipes.size() > ii) {
                    if (!getComponent(screen.getMenu()).inputSlots.getItem(0).isEmpty()) {
                        HandcraftingCollarsRecipe recipe = recipes.get(ii);
                        if (!matchedRecipes.contains(recipe)) {
                            RenderSystem.setShaderColor(1f, 1f, 1f, 0.5f);
                            gui.blit(GUI, i + 7 + (sj * 18), j + 17 + (si * 18), 176, 78, 18, 18, 256, 256);
                            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
                        }
                    }
                }
                ii++;
            }
        }

        gui.blit(GUI, i + 7, j + 107, 176, 60, 18, 18, 256, 256);
        if (getComponent(screen.getMenu()).inputSlots.getItem(1).isEmpty()) gui.blit(TAG_SLOT_TEXTURE, i + 8, j + 107, 0, 0, 16, 16, 16, 16);

        boolean hovered = (mouseX >= i + 25 + 1 && mouseY >= j + 107 + 1 && mouseX < i + 25 + 18 && mouseY < j + 107 + 17);
        gui.blit(GUI, i + 25, j + 107, hovered ?212 : 194, 60, 18, 18, 256, 256);

        gui.blit(GUI, i + 7, j + 125, 176, 60, 18, 18, 256, 256);
        if (getComponent(screen.getMenu()).inputSlots.getItem(0).isEmpty()) gui.blit(COLLAR_SLOT_TEXTURE, i + 8, j + 126, 0, 0, 16, 16, 16, 16);

        gui.blit(GUI, i + 32, j + 125, 230, 60, 22  , 18, 256, 256);

        gui.blit(GUI, i + 61, j + 125, 176, 60, 18, 18, 256, 256);
        if (getComponent(screen.getMenu()).resultSlot.isEmpty()) {
            gui.blit(COLLAR_SLOT_TEXTURE, i + 62, j + 126, 0, 0, 16, 16, 16, 16);
        } else {
            if (!matchedRecipes.contains(selectedRecipe)) {
                RenderSystem.setShaderColor(1f, 1f, 1f, 0.5f);
                gui.blit(GUI, i + 61, j + 125, 176, 78, 18, 18, 256, 256);
                RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
            }
        }

        hovered = (mouseX >= i + 119 + 1 && mouseY >= j + 125 + 1 && mouseX < i + 119 + 27 && mouseY < j + 125 + 27);
        gui.blit(GUI, i + 119, j + 125, hovered ? 222 : 194, isMatched ? 96 : 78, 28, 18, 256, 256);

        gui.blit(GUI, i + 152, j + 17, 216, 0, 16, 18, 256, 256);
        gui.blit(GUI, i + 152, j + 35, 16, 90, 216, 18, 16, 18, 256, 256);
        gui.blit(GUI, i + 152, j + 125, 216, 36, 16, 18, 256, 256);

        double size = (Math.ceil(recipes.size() / 8f) - 6);
        int offset = size > 0 ? (int) ((scroll / size) * 107) : 0;
        gui.blit(GUI, i + 154, j + 19 + offset, 232, 0, 12, 15, 256, 256);

        RenderSystem.enableBlend();

        if (!getComponent(screen.getMenu()).resultSlot.isEmpty() && selectedRecipe != null && matchedRecipes.contains(selectedRecipe)) {
            ii = scroll * 8;
            for (int si = 0; si < 4; si++) {
                for (int sj = 0; sj < 9; sj++) {
                    if (si == 0 ) {
                        offset = 58;
                    } else {
                        offset = -18;
                    }
                    if (selectedRecipeMatchedSlots.contains(ii)) {
                        RenderSystem.setShaderColor(1f, 1f, 1f, 0.5f);
                        gui.blit(GUI, i + 7 + (sj * 18), j + 165 + (si * 18) + offset, 176, 78, 18, 18, 256, 256);
                        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
                    }
                    ii++;
                }
            }
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void render(HandcraftingTableScreen screen, GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        Minecraft minecraft = Minecraft.getInstance();
        List<HandcraftingCollarsRecipe> recipes = sortedRecipes;
        if (isMatched) recipes = matchedRecipes;
        hoveredRecipe = null;

        if (!getComponent(screen.getMenu()).inputSlots.getItem(0).isEmpty()) {
            int ii = scroll * 8;
            for (int si = 0; si < 5; si++) {
                for (int sj = 0; sj < 8; sj++) {
                    if (recipes.size() <= ii) break;
                    HandcraftingCollarsRecipe recipe = recipes.get(ii);
                    ItemStack itemStack = new ItemStack(PurrfectItems.COLLAR.get());
                    if (recipe.hasCollarPartColor()) CollarItem.setColor(itemStack, recipe.getCollarPartColor());
                    if (recipe.hasCollarPartAccessory()) CollarItem.setAccessory(itemStack, recipe.getCollarPartAccessory());
                    if (recipe.hasCollarPartDecoration()) CollarItem.setDecoration(itemStack, recipe.getCollarPartDecoration());
                    gui.renderItem(itemStack, i + 7 + (sj * 18) + 1, j + 17 + (si * 18) + 1);
                    gui.renderItemDecorations(minecraft.font, itemStack, i + 7 + (sj * 18) + 1, j + 17 + (si * 18) + 1);
                    boolean hovered = (mouseX >= i + 7 + (sj * 18) + 1 && mouseY >= j + 17 + (si * 18) + 1 && mouseX < i + 7 + (sj * 18) + 17 && mouseY < j + 17 + (si * 18) + 17);
                    if (hovered) hoveredRecipe = recipe;
                    ii++;
                    if (ii >= recipes.size()) break;
                }
                if (ii >= recipes.size()) break;
            }
        }

        if (hoveredRecipe != null) {
            List<HandcraftingIngredient> ingredients = new ArrayList<>();
            for (HandcraftingIngredient ingredient : hoveredRecipe.getHandcraftingIngredients()) {
                ingredients.add(new HandcraftingIngredient(ingredient.getIngredient(), ingredient.getCount()));
            }
            HandcraftingRecipeTooltipComponent tooltipComponent = new HandcraftingRecipeTooltipComponent(ingredients);
            ItemStack itemStack = new ItemStack(PurrfectItems.COLLAR.get());
            if (hoveredRecipe.hasCollarPartColor()) CollarItem.setColor(itemStack, hoveredRecipe.getCollarPartColor());
            if (hoveredRecipe.hasCollarPartAccessory()) CollarItem.setAccessory(itemStack, hoveredRecipe.getCollarPartAccessory());
            if (hoveredRecipe.hasCollarPartDecoration()) CollarItem.setDecoration(itemStack, hoveredRecipe.getCollarPartDecoration());
            gui.renderTooltip(minecraft.font, Screen.getTooltipFromItem(minecraft, itemStack), Optional.of(tooltipComponent), mouseX, mouseY);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean mouseClicked(HandcraftingTableScreen screen, double mouseX, double mouseY, int button) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        List<HandcraftingCollarsRecipe> recipes = sortedRecipes;
        if (isMatched) recipes = matchedRecipes;

        if (!getComponent(screen.getMenu()).inputSlots.getItem(0).isEmpty()) {
            int ii = scroll * 8;
            for (int si = 0; si < 5; si++) {
                for (int sj = 0; sj < 8; sj++) {
                    if (recipes.size() <= ii) break;
                    HandcraftingCollarsRecipe recipe = recipes.get(ii);
                    boolean hovered = (mouseX >= i + 7 + (sj * 18) + 1 && mouseY >= j + 17 + (si * 18) + 1 && mouseX < i + 7 + (sj * 18) + 17 && mouseY < j + 17 + (si * 18) + 17);
                    if (hovered) {
                        selectedRecipe = recipe;
                        if (!getComponent(screen.getMenu()).inputSlots.getItem(0).isEmpty()) PurrfectPacketHandler.sendToServer(new HandcraftingCollarCraftPacket(selectedRecipe));
                        Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                        return true;
                    }
                    ii++;
                    if (ii >= recipes.size()) break;
                }
                if (ii >= recipes.size()) break;
            }
        }

        if (!getComponent(screen.getMenu()).inputSlots.getItem(0).isEmpty()) {
            if (mouseX >= i + 25 && mouseY >= j + 107 && mouseX < i + 25 + 18 && mouseY < j + 107 + 18) {
                PurrfectPacketHandler.sendToServer(new HandcraftingCollarTagPacket());
                if (selectedRecipe != null) {
                    if (!getComponent(screen.getMenu()).inputSlots.getItem(0).isEmpty()) PurrfectPacketHandler.sendToServer(new HandcraftingCollarCraftPacket(selectedRecipe));
                }
                Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                return true;
            }
        }

        if (mouseX >= i + 119 && mouseY >= j + 125 && mouseX < i + 119 + 28 && mouseY < j + 125 + 18) {
            isMatched = !isMatched;
            scroll = 0;
            Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
            return true;
        }

        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean mouseScrolled(HandcraftingTableScreen screen, double mouseX, double mouseY, double delta) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        List<HandcraftingCollarsRecipe> recipes = sortedRecipes;
        if (isMatched) recipes = matchedRecipes;

        if (recipes.size() > 40) {
            if (mouseX >= i + 7 && mouseY >= j + 17 && mouseX < i + 169 && mouseY < j + 143) {
                int add = (int) -delta;
                scroll = scroll + add;
                if (scroll < 0) {
                    scroll = 0;
                } else if (scroll > (int) (Math.ceil(recipes.size() / 8f)) - 6) {
                    scroll = (int) (Math.ceil(recipes.size() / 8f)) - 6;
                } else {
                    Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.1f, 2.0f);
                }
            }
        }

        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public static void recipesUpdate() {
        Minecraft minecraft = Minecraft.getInstance();
        Level level = minecraft.level;
        Player player = minecraft.player;

        if (level != null && player != null) {
            sortedRecipes.clear();
            allRecipes = level.getRecipeManager().getAllRecipesFor(PurrfectRecipes.HANDCRAFTING_COLLARS.get());
            List<HandcraftingCollarsRecipe> remainingRecipes = new ArrayList<>(allRecipes);

            List<HandcraftingSortingRecipe> recipesSorting = new ArrayList<>(level.getRecipeManager().getAllRecipesFor(PurrfectRecipes.HANDCRAFTING_SORTING.get()));
            recipesSorting.sort((i1, i2) -> Integer.compare(i2.getWeight(), i1.getWeight()));

            for (HandcraftingSortingRecipe recipeSorting : recipesSorting) {
                for (String recipeId : recipeSorting.getRecipes()) {
                    Optional<? extends Recipe<?>> recipe = level.getRecipeManager().byKey(new ResourceLocation(recipeId));
                    if (recipe.isPresent() && recipe.get() instanceof HandcraftingCollarsRecipe handcraftingCollarsRecipe) {
                        if (!sortedRecipes.contains(handcraftingCollarsRecipe)) {
                            sortedRecipes.add(handcraftingCollarsRecipe);
                            remainingRecipes.remove(handcraftingCollarsRecipe);
                        }
                    }
                }
            }

            sortedRecipes.addAll(remainingRecipes);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void matchedRecipesUpdate() {
        Minecraft minecraft = Minecraft.getInstance();
        Level level = minecraft.level;
        Player player = minecraft.player;

        if (level != null && player != null) {
            matchedRecipes.clear();
            selectedRecipeMatchedSlots.clear();
            Container container = minecraft.player.getInventory();

            for (HandcraftingCollarsRecipe recipe : sortedRecipes) {
                if (recipe.matches(container, level)) {
                    matchedRecipes.add(recipe);
                }
            }

            if (selectedRecipe != null && matchedRecipes.contains(selectedRecipe)) {
                List<HandcraftingIngredient> ingredientsMissing = new ArrayList<>();
                for (HandcraftingIngredient ingredient : selectedRecipe.getHandcraftingIngredients()) {
                    ingredientsMissing.add(new HandcraftingIngredient(ingredient.getIngredient(), ingredient.getCount()));
                }

                for (HandcraftingIngredient ingredient : ingredientsMissing) {
                    for (int i = 0; i < container.getContainerSize(); i++) {
                        ItemStack stack = container.getItem(i);
                        if (ingredient.getIngredient().test(stack)) {
                            selectedRecipeMatchedSlots.add(i);
                            ingredient.remove(stack.getCount());
                            if (ingredient.isEmpty()) break;
                        }
                    }
                }
            }
        }
    }

    public static boolean canCraftRecipe(Player player) {
        if (player != null) {
            AbstractContainerMenu containerMenu = player.containerMenu;
            if (containerMenu instanceof HandcraftingTableMenu handcraftingTableMenu) {
                return handcraftingTableMenu.stillValid(player);
            }
        }
        return false;
    }

    public static void setRecipe(Player player, Level level, HandcraftingCollarsRecipe recipe) {
        if (level != null && player != null) {
            AbstractContainerMenu containerMenu = player.containerMenu;
            if (containerMenu instanceof HandcraftingTableMenu handcraftingTableMenu) {
                if (handcraftingTableMenu.tabComponent instanceof CollarsHandcraftingTabComponent tabComponent) {
                    if (!tabComponent.inputSlots.getItem(0).isEmpty()) {
                        ItemStack itemStack = tabComponent.inputSlots.getItem(0).copy();
                        if (recipe.hasCollarPartColor()) CollarItem.setColor(itemStack, recipe.getCollarPartColor());
                        if (recipe.hasCollarPartAccessory()) CollarItem.setAccessory(itemStack, recipe.getCollarPartAccessory());
                        if (recipe.hasCollarPartDecoration()) CollarItem.setDecoration(itemStack, recipe.getCollarPartDecoration());
                        tabComponent.resultSlot.setItem(0, itemStack);
                        handcraftingTableMenu.broadcastChanges();
                        tabComponent.recipe = recipe;
                    }
                }
            }
        }
    }

    public static boolean canCraftRecipe(Player player, Level level, HandcraftingCollarsRecipe recipe) {
        if (level != null && player != null && recipe != null) {
            Container container = player.getInventory();
            return recipe.matches(container, level);
        }
        return false;
    }

    public static void craftRecipe(Player player, Level level, HandcraftingCollarsRecipe recipe) {
        if (level != null && player != null && recipe != null) {
            Container container = player.getInventory();
            if (recipe.matches(container, level)) {
                List<HandcraftingIngredient> ingredientsMissing = new ArrayList<>();
                for (HandcraftingIngredient ingredient : recipe.getHandcraftingIngredients()) {
                    ingredientsMissing.add(new HandcraftingIngredient(ingredient.getIngredient(), ingredient.getCount()));
                }

                for (HandcraftingIngredient ingredient : ingredientsMissing) {
                    for (int i = 0; i < container.getContainerSize(); i++) {
                        ItemStack stack = container.getItem(i);
                        if (ingredient.getIngredient().test(stack)) {
                            int count = ingredient.getCount();
                            if (count > stack.getCount()) count = stack.getCount();
                            ingredient.remove(count);
                            stack.shrink(count);
                            if (ingredient.isEmpty()) break;
                        }
                    }
                }

                BlockSimpleInventory.addPlayerItem(level, player, recipe.getResultItem(RegistryAccess.EMPTY).copy());
            }
        }
    }

    public static void setTag(Player player, Level level) {
        if (level != null && player != null) {
            AbstractContainerMenu containerMenu = player.containerMenu;
            if (containerMenu instanceof HandcraftingTableMenu handcraftingTableMenu) {
                if (handcraftingTableMenu.tabComponent instanceof CollarsHandcraftingTabComponent tabComponent) {
                    if (!tabComponent.inputSlots.getItem(0).isEmpty()) {
                        ItemStack collarItem = tabComponent.inputSlots.getItem(0);
                        ItemStack tagItem = tabComponent.inputSlots.getItem(1);
                        if (tagItem.isEmpty()) {
                            if (!CollarItem.getTag(collarItem).isEmpty()) {
                                ItemStack tag = new ItemStack(PurrfectItems.SILLY_TAG.get());
                                SillyTagItem.setTag(tag, CollarItem.getTag(collarItem));
                                tabComponent.inputSlots.setItem(1, tag);
                            } else if (!CollarItem.getCustomTag(collarItem).isEmpty()) {
                                ItemStack tag = new ItemStack(PurrfectItems.SILLY_TAG.get());
                                tag.setHoverName(Component.literal(CollarItem.getCustomTag(collarItem)));
                                tabComponent.inputSlots.setItem(1, tag);
                            }
                            CollarItem.setTag(collarItem, "");
                            CollarItem.setCustomTag(collarItem, "");
                        } else {
                            if (CollarItem.getTag(collarItem).isEmpty() && CollarItem.getCustomTag(collarItem).isEmpty()) {
                                if (!SillyTagItem.hasTag(tagItem)) {
                                    SillyTagItem.setTag(tagItem, Purrfect.MOD_ID + ":nameless");
                                }
                                if (SillyTagItem.getTag(tagItem).isEmpty()) {
                                    if (tagItem.hasCustomHoverName()) {
                                        CollarItem.setCustomTag(collarItem, tagItem.getHoverName().getString());
                                        tabComponent.inputSlots.setItem(1, ItemStack.EMPTY);
                                    }
                                } else {
                                    CollarItem.setTag(collarItem, SillyTagItem.getTag(tagItem));
                                    tabComponent.inputSlots.setItem(1, ItemStack.EMPTY);
                                }
                            }
                        }
                        handcraftingTableMenu.broadcastChanges();
                    }
                }
            }
        }
    }
}
