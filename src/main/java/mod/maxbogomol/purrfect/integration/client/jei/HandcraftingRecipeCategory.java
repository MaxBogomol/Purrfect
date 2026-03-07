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
import mod.maxbogomol.purrfect.common.recipe.HandcraftingIngredient;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingRecipe;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class HandcraftingRecipeCategory implements IRecipeCategory<HandcraftingRecipe> {
    public static final RecipeType<HandcraftingRecipe> TYPE = RecipeType.create(Purrfect.MOD_ID, "handcrafting", HandcraftingRecipe.class);
    public final static ResourceLocation TEXTURE = new ResourceLocation(Purrfect.MOD_ID, "textures/gui/jei/handcrafting.png");

    private final IDrawable background;
    private final IDrawable icon;

    public HandcraftingRecipeCategory(IGuiHelper helper) {
        background = helper.createDrawable(TEXTURE, 0, 0, 138, 78);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(PurrfectItems.HANDCRAFTING_TABLE.get()));
    }

    @NotNull
    @Override
    public RecipeType<HandcraftingRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("handcrafting_tab.purrfect.handcrafting");
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
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull HandcraftingRecipe recipe, @NotNull IFocusGroup focusGroup) {
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

        builder.addSlot(RecipeIngredientRole.OUTPUT, 118, 31).addItemStack(recipe.getResultItem(RegistryAccess.EMPTY));
    }

    @Override
    public void draw(@NotNull HandcraftingRecipe recipe, @NotNull IRecipeSlotsView view, @NotNull GuiGraphics gui, double mouseX, double mouseY) {
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
