package mod.maxbogomol.purrfect.common.gui.tooltip;

import mod.maxbogomol.purrfect.common.recipe.HandcraftingIngredient;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

import java.util.List;

public class HandcraftingRecipeTooltipComponent implements TooltipComponent {
    public List<HandcraftingIngredient> inputs;

    public HandcraftingRecipeTooltipComponent(List<HandcraftingIngredient> inputs) {
        this.inputs = inputs;
    }

    public List<HandcraftingIngredient> getInputs() {
        return inputs;
    }
}
