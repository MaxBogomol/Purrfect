package mod.maxbogomol.purrfect.client.event;

import mod.maxbogomol.purrfect.common.hadcrafting.CollarsHandcraftingTab;
import mod.maxbogomol.purrfect.common.hadcrafting.MainHandcraftingTab;
import net.minecraftforge.client.event.RecipesUpdatedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PurrfectClientEvents {

    @SubscribeEvent
    public void onRecipesUpdated(RecipesUpdatedEvent event) {
        MainHandcraftingTab.recipesUpdate();
        CollarsHandcraftingTab.recipesUpdate();
    }
}
