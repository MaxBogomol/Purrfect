package mod.maxbogomol.purrfect.common.hadcrafting;

import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class MainHandcraftingTab extends HandcraftingTab {

    public MainHandcraftingTab(String id, Supplier<ItemStack> iconItemStack) {
        super(id, iconItemStack);
    }
}
