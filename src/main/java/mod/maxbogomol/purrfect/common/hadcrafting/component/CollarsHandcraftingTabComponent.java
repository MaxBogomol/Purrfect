package mod.maxbogomol.purrfect.common.hadcrafting.component;

import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTabComponent;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingCollarsRecipe;
import net.minecraft.world.Container;

public class CollarsHandcraftingTabComponent extends HandcraftingTabComponent {
    public Container inputSlots;
    public Container resultSlot;
    public HandcraftingCollarsRecipe recipe;
}
