package mod.maxbogomol.purrfect.common.hadcrafting;

import com.mojang.blaze3d.systems.RenderSystem;
import mod.maxbogomol.fluffy_fur.common.block.entity.BlockSimpleInventory;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTab;
import mod.maxbogomol.purrfect.client.gui.screen.HandcraftingTableScreen;
import mod.maxbogomol.purrfect.common.gui.menu.HandcraftingTableMenu;
import mod.maxbogomol.purrfect.common.gui.tooltip.HandcraftingRecipeTooltipComponent;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.common.network.block.HandcraftingRecipeCraftPacket;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingIngredient;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingRecipe;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingSortingRecipe;
import mod.maxbogomol.purrfect.registry.common.PurrfectRecipes;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public class MainHandcraftingTab extends HandcraftingTab {
    public static Supplier<ItemStack> ICON = () -> new ItemStack(PurrfectItems.HANDCRAFTING_TABLE.get());

    public static UUID FOX = UUID.fromString("a3b9ab92-41ea-4ec1-87f8-db64036c105f"); //MaxBogomol
    public static UUID VOICES = UUID.fromString("2472235e-b8f9-47c7-aa8f-ca9fcc48d92e"); //FurryFoxes
    public static UUID CUTIE = UUID.fromString("49746d0a-8da8-4c8c-9f57-1cdbfd62e682"); //OnixTheCat

    public static List<HandcraftingRecipe> allRecipes = new ArrayList<>();
    public static List<HandcraftingRecipe> sortedRecipes = new ArrayList<>();
    public List<HandcraftingRecipe> matchedRecipes = new ArrayList<>();
    public HandcraftingRecipe selectedRecipe = null;
    public HandcraftingRecipe hoveredRecipe = null;
    public List<Integer> selectedRecipeMatchedSlots = new ArrayList<>();
    public int scroll = 0;
    public boolean isMatched = false;
    public int multiplier = 1;

    public MainHandcraftingTab(String id, Supplier<ItemStack> iconItemStack) {
        super(id, iconItemStack);
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

        Minecraft minecraft = Minecraft.getInstance();
        List<HandcraftingRecipe> recipes = sortedRecipes;
        if (isMatched) recipes = matchedRecipes;

        RenderSystem.enableBlend();

        int ii = scroll * 8;
        for (int si = 0; si < 6; si++) {
            for (int sj = 0; sj < 8; sj++) {
                gui.blit(GUI, i + 7 + (sj * 18), j + 17 + (si * 18), 176, 60, 18, 18, 256, 256);
                if (recipes.size() > ii) {
                    HandcraftingRecipe recipe = recipes.get(ii);
                    if (!matchedRecipes.contains(recipe)) {
                        RenderSystem.setShaderColor(1f, 1f, 1f, 0.5f);
                        gui.blit(GUI, i + 7 + (sj * 18), j + 17 + (si * 18), 176, 78, 18, 18, 256, 256);
                        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
                    }
                }
                ii++;
            }
        }

        gui.blit(GUI, i + 7, j + 125, 176, 60, 18, 18, 256, 256);
        if (selectedRecipe != null) {
            if (!matchedRecipes.contains(selectedRecipe)) {
                RenderSystem.setShaderColor(1f, 1f, 1f, 0.5f);
                gui.blit(GUI, i + 7, j + 125, 176, 78, 18, 18, 256, 256);
                RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
            }
        }

        boolean hovered = (mouseX >= i + 25 + 1 && mouseY >= j + 125 + 1 && mouseX < i + 25 + 17 && mouseY < j + 125 + 17);
        gui.blit(GUI, i + 25, j + 125, hovered ? 212 : 194, 60, 18, 18, 256, 256);

        gui.blit(GUI, i + 48, j + 130, 176, 96, 18, 18, 256, 256);
        gui.drawString(minecraft.font, String.valueOf(multiplier), i + 58, j + 130, TITLE_COLOR, false);

        hovered = (mouseX >= i + 79 + 1 && mouseY >= j + 125 + 1 && mouseX < i + 79 + 18 && mouseY < j + 125 + 17);
        gui.blit(GUI, i + 79, j + 125, hovered ? 212 : 194, 114, 18, 18, 256, 256);

        hovered = (mouseX >= i + 97 + 1 && mouseY >= j + 125 + 1 && mouseX < i + 97 + 18 && mouseY < j + 125 + 17);
        gui.blit(GUI, i + 97, j + 125, hovered ? 212 : 194, 132, 18, 18, 256, 256);

        hovered = (mouseX >= i + 119 + 1 && mouseY >= j + 125 + 1 && mouseX < i + 119 + 27 && mouseY < j + 125 + 27);
        gui.blit(GUI, i + 119, j + 125, hovered ? 222 : 194, isMatched ? 96 : 78, 28, 18, 256, 256);

        gui.blit(GUI, i + 152, j + 17, 216, 0, 16, 18, 256, 256);
        gui.blit(GUI, i + 152, j + 35, 16, 90, 216, 18, 16, 18, 256, 256);
        gui.blit(GUI, i + 152, j + 125, 216, 36, 16, 18, 256, 256);

        double size = (Math.ceil(recipes.size() / 8f) - 6);
        int offset = size > 0 ? (int) ((scroll / size) * 107) : 0;
        gui.blit(GUI, i + 154, j + 19 + offset, 232, 0, 12, 15, 256, 256);

        RenderSystem.enableBlend();

        if (selectedRecipe != null && matchedRecipes.contains(selectedRecipe)) {
            ii = 0;
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
        List<HandcraftingRecipe> recipes = sortedRecipes;
        if (isMatched) recipes = matchedRecipes;
        hoveredRecipe = null;

        int ii = scroll * 8;
        for (int si = 0; si < 6; si++) {
            for (int sj = 0; sj < 8; sj++) {
                if (recipes.size() <= ii) break;
                HandcraftingRecipe recipe = recipes.get(ii);
                gui.renderItem(recipe.getResultItem(RegistryAccess.EMPTY), i + 7 + (sj * 18) + 1, j + 17 + (si * 18) + 1);
                int itemCount = recipe.getResultItem(RegistryAccess.EMPTY).getCount() * multiplier;
                String s = null;
                if (itemCount > 1) s = String.valueOf(itemCount);
                gui.renderItemDecorations(minecraft.font, recipe.getResultItem(RegistryAccess.EMPTY), i + 7 + (sj * 18) + 1, j + 17 + (si * 18) + 1, s);
                boolean hovered = (mouseX >= i + 7 + (sj * 18) + 1 && mouseY >= j + 17 + (si * 18) + 1 && mouseX < i + 7 + (sj * 18) + 17 && mouseY < j + 17 + (si * 18) + 17);
                if (hovered) hoveredRecipe = recipe;
                ii++;
                if (ii >= recipes.size()) break;
            }
            if (ii >= recipes.size()) break;
        }

        boolean hovered = (mouseX >= i + 7 + 1 && mouseY >= j + 125 + 1&& mouseX < i + 7 + 17 && mouseY < j + 125 + 17);
        if (selectedRecipe != null) {
            gui.renderItem(selectedRecipe.getResultItem(RegistryAccess.EMPTY), i + 7 + 1, j + 125 + 1);
            int itemCount = selectedRecipe.getResultItem(RegistryAccess.EMPTY).getCount() * multiplier;
            String s = null;
            if (itemCount > 1) s = String.valueOf(itemCount);
            gui.renderItemDecorations(minecraft.font, selectedRecipe.getResultItem(RegistryAccess.EMPTY), i + 7 + 1, j + 125 + 1, s);
            if (hovered) hoveredRecipe = selectedRecipe;
        }

        if (hoveredRecipe != null) {
            List<HandcraftingIngredient> ingredients = new ArrayList<>();
            for (HandcraftingIngredient ingredient : hoveredRecipe.getHandcraftingIngredients()) {
                ingredients.add(new HandcraftingIngredient(ingredient.getIngredient(), ingredient.getCount() * multiplier));
            }
            HandcraftingRecipeTooltipComponent tooltipComponent = new HandcraftingRecipeTooltipComponent(ingredients);
            gui.renderTooltip(minecraft.font, Screen.getTooltipFromItem(minecraft, hoveredRecipe.getResultItem(RegistryAccess.EMPTY)), Optional.of(tooltipComponent), mouseX, mouseY);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean mouseClicked(HandcraftingTableScreen screen, double mouseX, double mouseY, int button) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        List<HandcraftingRecipe> recipes = sortedRecipes;
        if (isMatched) recipes = matchedRecipes;

        int ii = scroll * 8;
        for (int si = 0; si < 6; si++) {
            for (int sj = 0; sj < 8; sj++) {
                if (recipes.size() <= ii) break;
                HandcraftingRecipe recipe = recipes.get(ii);
                boolean hovered = (mouseX >= i + 7 + (sj * 18) + 1 && mouseY >= j + 17 + (si * 18) + 1 && mouseX < i + 7 + (sj * 18) + 17 && mouseY < j + 17 + (si * 18) + 17);
                if (hovered) {
                    selectedRecipe = recipe;
                    Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                    return true;
                }
                ii++;
                if (ii >= recipes.size()) break;
            }
            if (ii >= recipes.size()) break;
        }

        if (selectedRecipe != null) {
            if (mouseX >= i + 7 + 1 && mouseY >= j + 125 + 1 && mouseX < i + 7 + 17 && mouseY < j + 125 + 17) {
                selectedRecipe = null;
                Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                return true;
            }
        }

        if (selectedRecipe != null && matchedRecipes.contains(selectedRecipe)) {
            if (mouseX >= i + 25 && mouseY >= j + 125 && mouseX < i + 25 + 18 && mouseY < j + 125 + 18) {
                PurrfectPacketHandler.sendToServer(new HandcraftingRecipeCraftPacket(selectedRecipe, multiplier));
                Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                return true;
            }
        }

        if (mouseX >= i + 79 && mouseY >= j + 125 && mouseX < i + 79 + 18 && mouseY < j + 125 + 18) {
            if (multiplier - 1 >= 1) {
                multiplier--;
                Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                return true;
            }
        }

        if (mouseX >= i + 97 && mouseY >= j + 125 && mouseX < i + 97 + 18 && mouseY < j + 125 + 18) {
            if (multiplier + 1 <= 16) {
                multiplier++;
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

        List<HandcraftingRecipe> recipes = sortedRecipes;
        if (isMatched) recipes = matchedRecipes;

        if (recipes.size() > 48) {
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
            allRecipes = level.getRecipeManager().getAllRecipesFor(PurrfectRecipes.HANDCRAFTING.get());
            List<HandcraftingRecipe> remainingRecipes = new ArrayList<>(allRecipes);

            List<HandcraftingSortingRecipe> recipesSorting = new ArrayList<>(level.getRecipeManager().getAllRecipesFor(PurrfectRecipes.HANDCRAFTING_SORTING.get()));
            recipesSorting.sort((i1, i2) -> Integer.compare(i2.getWeight(), i1.getWeight()));

            for (HandcraftingSortingRecipe recipeSorting : recipesSorting) {
                for (String recipeId : recipeSorting.getRecipes()) {
                    Optional<? extends Recipe<?>> recipe = level.getRecipeManager().byKey(new ResourceLocation(recipeId));
                    if (recipe.isPresent() && recipe.get() instanceof HandcraftingRecipe handcraftingRecipe) {
                        boolean special = canCraftSpecial(player, level, handcraftingRecipe);
                        if (handcraftingRecipe.getSpecial().isEmpty() || special) {
                            if (!sortedRecipes.contains(handcraftingRecipe)) {
                                sortedRecipes.add(handcraftingRecipe);
                                remainingRecipes.remove(handcraftingRecipe);
                            }
                        } else {
                            remainingRecipes.remove(handcraftingRecipe);
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

            for (HandcraftingRecipe recipe : sortedRecipes) {
                if (recipe.matches(container, level, multiplier)) {
                    matchedRecipes.add(recipe);
                }
            }

            if (selectedRecipe != null && matchedRecipes.contains(selectedRecipe)) {
                List<HandcraftingIngredient> ingredientsMissing = new ArrayList<>();
                for (HandcraftingIngredient ingredient : selectedRecipe.getHandcraftingIngredients()) {
                    ingredientsMissing.add(new HandcraftingIngredient(ingredient.getIngredient(), ingredient.getCount() * multiplier));
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

    public static void craftRecipe(Player player, Level level, HandcraftingRecipe recipe, int multiplier) {
        if (level != null && player != null) {
            Container container = player.getInventory();
            boolean canCraft = canCraftSpecial(player, level, recipe);
            if (recipe.matches(container, level) && canCraft) {
                List<HandcraftingIngredient> ingredientsMissing = new ArrayList<>();
                for (HandcraftingIngredient ingredient : recipe.getHandcraftingIngredients()) {
                    ingredientsMissing.add(new HandcraftingIngredient(ingredient.getIngredient(), ingredient.getCount() * multiplier));
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

                for (int i = 0; i < multiplier; i++) {
                    BlockSimpleInventory.addPlayerItem(level, player, recipe.getResultItem(RegistryAccess.EMPTY).copy());
                }
            }
        }
    }

    public static boolean canCraftSpecial(Player player, Level level, HandcraftingRecipe recipe) {
        if (!recipe.getSpecial().isEmpty()) {
            if (level != null && player != null) {
                boolean canCraft = false;
                String special = recipe.getSpecial();
                UUID uuid = player.getGameProfile().getId();

                if (special.equals("cutie")) {
                    return uuid.equals(CUTIE) || uuid.equals(FOX) || uuid.equals(VOICES);
                }

                return canCraft;
            }
        }
        return true;
    }
}
