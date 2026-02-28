package mod.maxbogomol.purrfect.client.gui.tooltip;

import mod.maxbogomol.fluffy_fur.client.event.ClientTickHandler;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingIngredient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class HandcraftingRecipeClientTooltipComponent implements ClientTooltipComponent {
    public List<HandcraftingIngredient> inputs;

    public HandcraftingRecipeClientTooltipComponent(HandcraftingRecipeTooltipComponent component) {
        this.inputs = component.getInputs();
    }

    @Override
    public int getHeight() {
        return (int) Math.ceil(inputs.size() / 6f) * 18 + 2;
    }

    @Override
    public int getWidth(Font font) {
        return inputs.size() > 6 ? 108 : inputs.size() * 18;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        int i = 0;
        int j = 0;
        for (HandcraftingIngredient input : inputs) {
            ItemStack[] itemStacks = input.getIngredient().getItems();
            int item = ((int) ClientTickHandler.getTotal() % (20 * itemStacks.length)) / 20;
            ItemStack itemStack = itemStacks[item];
            guiGraphics.renderItem(itemStack, x + i * 18 + 2, y + j * 18 + 1);
            guiGraphics.renderItemDecorations(Minecraft.getInstance().font, itemStack, x + i * 18 + 2, y + j * 18 + 1, String.valueOf(input.getCount()));
            i++;
            if (i >= 6) {
                j++;
                i = 0;
            }
        }
    }
}
