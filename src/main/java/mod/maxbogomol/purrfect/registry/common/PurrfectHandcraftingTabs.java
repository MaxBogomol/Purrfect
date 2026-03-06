package mod.maxbogomol.purrfect.registry.common;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingHandler;
import mod.maxbogomol.purrfect.common.hadcrafting.CollarsHandcraftingTab;
import mod.maxbogomol.purrfect.common.hadcrafting.MainHandcraftingTab;
import mod.maxbogomol.purrfect.common.hadcrafting.ShipkeysHandcraftingTab;
import mod.maxbogomol.purrfect.common.hadcrafting.SillyTagsHandcraftingTab;

public class PurrfectHandcraftingTabs {
    public static MainHandcraftingTab HANDCRAFTING = new MainHandcraftingTab(Purrfect.MOD_ID+":handcrafting", MainHandcraftingTab.ICON);
    public static CollarsHandcraftingTab COLLARS = new CollarsHandcraftingTab(Purrfect.MOD_ID+":collars", CollarsHandcraftingTab.ICON);
    public static SillyTagsHandcraftingTab SILLY_TAGS = new SillyTagsHandcraftingTab(Purrfect.MOD_ID+":silly_tags", SillyTagsHandcraftingTab.ICON);
    public static ShipkeysHandcraftingTab SHIPKEYS = new ShipkeysHandcraftingTab(Purrfect.MOD_ID+":shipkeys", ShipkeysHandcraftingTab.ICON);

    public static void register() {
        HandcraftingHandler.register(HANDCRAFTING);
        HandcraftingHandler.register(COLLARS);
        HandcraftingHandler.register(SILLY_TAGS);
        HandcraftingHandler.register(SHIPKEYS);
    }
}
