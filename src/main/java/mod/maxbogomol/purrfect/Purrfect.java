package mod.maxbogomol.purrfect;

import mod.maxbogomol.fluffy_fur.FluffyFur;
import mod.maxbogomol.fluffy_fur.common.proxy.ClientProxy;
import mod.maxbogomol.fluffy_fur.common.proxy.ISidedProxy;
import mod.maxbogomol.fluffy_fur.common.proxy.ServerProxy;
import mod.maxbogomol.purrfect.common.event.PurrfectEvents;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.registry.common.block.PurrfectBlockEnteties;
import mod.maxbogomol.purrfect.registry.common.block.PurrfectBlocks;
import mod.maxbogomol.purrfect.registry.common.entity.PurrfectEntities;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectCreativeTabs;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("purrfect")
public class Purrfect {
    public static final String MOD_ID = "purrfect";
    public static final String NAME = "Purrfect";
    public static final String VERSION = "0.1";
    public static final int VERSION_NUMBER = 1;

    public static final ISidedProxy proxy = DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    public static final Logger LOGGER = LogManager.getLogger();

    public Purrfect() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        PurrfectItems.register(eventBus);
        PurrfectBlocks.register(eventBus);
        PurrfectBlockEnteties.register(eventBus);
        PurrfectEntities.register(eventBus);

        DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> {
            PurrfectClient.ClientOnly.clientInit();
            return new Object();
        });

        eventBus.addListener(this::setup);
        eventBus.addListener(PurrfectClient::clientSetup);

        PurrfectCreativeTabs.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new PurrfectEvents());
    }

    private void setup(final FMLCommonSetupEvent event) {
        hi();
        PurrfectPacketHandler.init();
    }

    public static void hi() {
        FluffyFur.LOGGER.info("Hi Purrfect! You are very cute :3");
        LOGGER.info("OMG! Fluffy Fur! Haiii I love you very much :3");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerCaps(RegisterCapabilitiesEvent event) {

        }
    }
}