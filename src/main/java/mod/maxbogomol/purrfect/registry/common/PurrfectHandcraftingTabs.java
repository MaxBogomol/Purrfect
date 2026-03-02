package mod.maxbogomol.purrfect.registry.common;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingHandler;
import mod.maxbogomol.purrfect.common.hadcrafting.MainHandcraftingTab;
import mod.maxbogomol.purrfect.common.hadcrafting.SillyTagsHandcraftingTab;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.world.item.ItemStack;

public class PurrfectHandcraftingTabs {
    public static MainHandcraftingTab HANDCRAFTING = new MainHandcraftingTab(Purrfect.MOD_ID+":handcrafting", () -> new ItemStack(PurrfectItems.HANDCRAFTING_TABLE.get()));
    public static SillyTagsHandcraftingTab SILLY_TAGS = new SillyTagsHandcraftingTab(Purrfect.MOD_ID+":silly_tags", () -> new ItemStack(PurrfectItems.SILLY_TAG.get()));

    public static void register() {
        HandcraftingHandler.register(HANDCRAFTING);
        HandcraftingHandler.register(SILLY_TAGS);
    }
}
