package mod.maxbogomol.purrfect;

import mod.maxbogomol.fluffy_fur.FluffyFurClient;
import mod.maxbogomol.fluffy_fur.client.gui.screen.FluffyFurMod;
import mod.maxbogomol.fluffy_fur.client.splash.SplashHandler;
import mod.maxbogomol.purrfect.client.event.PurrfectClientEvents;
import mod.maxbogomol.purrfect.client.render.LeashRenderHandler;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectCreativeTabs;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.awt.*;
import java.util.Random;

public class PurrfectClient {
    public static Random random = new Random();

    public static class ClientOnly {
        public static void clientInit() {
            IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
            IEventBus forgeBus = MinecraftForge.EVENT_BUS;
            forgeBus.register(new PurrfectClientEvents());

            forgeBus.addListener(LeashRenderHandler::leashRender);

            eventBus.addListener(PurrfectCreativeTabs::addCreativeTabContent);
        }
    }

    public static void clientSetup(final FMLClientSetupEvent event) {
        setupMenu();
        setupSplashes();
    }

    public static FluffyFurMod MOD_INSTANCE;

    public static void setupMenu() {
        MOD_INSTANCE = new FluffyFurMod(Purrfect.MOD_ID, Purrfect.NAME, Purrfect.VERSION).setDev("MaxBogomol").setItem(new ItemStack(PurrfectItems.GOLDEN_BELL_COLLAR.get()))
                .setEdition(Purrfect.VERSION_NUMBER).setNameColor(new Color(205, 237, 254)).setVersionColor(new Color(255, 243, 177))
                .setDescription(Component.translatable("mod_description.purrfect"))
                .addGithubLink("https://github.com/MaxBogomol/Purrfect")
                .addCurseForgeLink("https://www.curseforge.com/minecraft/mc-mods/purrfect")
                .addModrinthLink("https://modrinth.com/mod/purrfect")
                .addDiscordLink("https://discord.gg/cKf55qNugw");

        FluffyFurClient.registerMod(MOD_INSTANCE);
    }

    public static void setupSplashes() {
        SplashHandler.addSplash("Meow Meow Meow :3");
        SplashHandler.addSplash("Mrow");
        SplashHandler.addSplash("Mew");
        SplashHandler.addSplash("Mow");
        SplashHandler.addSplash("Prrrr");
        SplashHandler.addSplash("Furry");
        SplashHandler.addSplash("UwU");
        SplashHandler.addSplash(":3");
        SplashHandler.addSplash("U CUTIE");
    }
}
