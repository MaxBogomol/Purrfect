package mod.maxbogomol.purrfect.integration.client.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingCollarsRecipe;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingIngredient;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class HandcraftingCollarsRecipeCategory implements IRecipeCategory<HandcraftingCollarsRecipe> {
    public static final RecipeType<HandcraftingCollarsRecipe> TYPE = RecipeType.create(Purrfect.MOD_ID, "handcrafting_collars", HandcraftingCollarsRecipe.class);
    public final static ResourceLocation TEXTURE = new ResourceLocation(Purrfect.MOD_ID, "textures/gui/jei/handcrafting_collars.png");

    private final IDrawable background;
    private final IDrawable icon;

    public HandcraftingCollarsRecipeCategory(IGuiHelper helper) {
        background = helper.createDrawable(TEXTURE, 0, 0, 138, 78);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(PurrfectItems.HANDCRAFTING_TABLE.get()));
    }

    @NotNull
    @Override
    public RecipeType<HandcraftingCollarsRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("handcrafting_tab.purrfect.handcrafting").append(": ").append(Component.translatable("handcrafting_tab.purrfect.collars"));
    }

    @Override
    @SuppressWarnings("removal")
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull HandcraftingCollarsRecipe recipe, @NotNull IFocusGroup focusGroup) {
        int i = 0;
        int j = 0;
        for (HandcraftingIngredient input : recipe.getHandcraftingIngredients()) {
            builder.addSlot(RecipeIngredientRole.INPUT, 3 + (i * 18) + 1, 3 + (j * 18) + 1).addIngredients(input.getIngredient());
            i++;
            if (i >= 6) {
                j++;
                i = 0;
            }
        }

        builder.addSlot(RecipeIngredientRole.INPUT, 118, 4).addItemStack(new ItemStack(PurrfectItems.COLLAR.get()));

        ItemStack collar = new ItemStack(PurrfectItems.COLLAR.get());
        if (recipe.hasCollarPartColor()) CollarItem.setColor(collar, recipe.getCollarPartColor());
        if (recipe.hasCollarPartAccessory()) CollarItem.setAccessory(collar, recipe.getCollarPartAccessory());
        if (recipe.hasCollarPartDecoration()) CollarItem.setDecoration(collar, recipe.getCollarPartDecoration());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 118, 58).addItemStack(collar);
    }

    @Override
    public void draw(@NotNull HandcraftingCollarsRecipe recipe, @NotNull IRecipeSlotsView view, @NotNull GuiGraphics gui, double mouseX, double mouseY) {
        Font font = Minecraft.getInstance().font;
        int i = 0;
        int j = 0;
        for (HandcraftingIngredient input : recipe.getHandcraftingIngredients()) {
            String s = null;
            if (input.getCount() > 1) s = String.valueOf(input.getCount());
            gui.renderItemDecorations(font, input.getIngredient().getItems()[0], 3 + (i * 18) + 1, 3 + (j * 18) + 1, s);
            i++;
            if (i >= 6) {
                j++;
                i = 0;
            }
        }
    }
}
