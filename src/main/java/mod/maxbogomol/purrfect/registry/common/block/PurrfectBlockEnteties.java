package mod.maxbogomol.purrfect.registry.common.block;

import mod.maxbogomol.fluffy_fur.client.render.block.PlushRenderer;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.client.render.block.FlagRenderer;
import mod.maxbogomol.purrfect.common.block.blahaj.BlahajBlockEntity;
import mod.maxbogomol.purrfect.common.block.flag.FlagBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PurrfectBlockEnteties {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Purrfect.MOD_ID);

    public static final RegistryObject<BlockEntityType<FlagBlockEntity>> FLAG = BLOCK_ENTITIES.register("flag", () -> BlockEntityType.Builder.of(FlagBlockEntity::new,
                    PurrfectBlocks.WHITE_FLAG.get(), PurrfectBlocks.LIGHT_GRAY_FLAG.get(), PurrfectBlocks.GRAY_FLAG.get(), PurrfectBlocks.BLACK_FLAG.get(), PurrfectBlocks.BROWN_FLAG.get(), PurrfectBlocks.RED_FLAG.get(), PurrfectBlocks.ORANGE_FLAG.get(), PurrfectBlocks.YELLOW_FLAG.get(), PurrfectBlocks.LIME_FLAG.get(), PurrfectBlocks.GREEN_FLAG.get(), PurrfectBlocks.CYAN_FLAG.get(), PurrfectBlocks.LIGHT_BLUE_FLAG.get(), PurrfectBlocks.BLUE_FLAG.get(), PurrfectBlocks.PURPLE_FLAG.get(), PurrfectBlocks.MAGENTA_FLAG.get(), PurrfectBlocks.PINK_FLAG.get(), PurrfectBlocks.RAINBOW_FLAG.get(),
                    PurrfectBlocks.HETEROSEXUAL_FLAG.get(), PurrfectBlocks.PRIDE_FLAG.get(), PurrfectBlocks.LESBIAN_FLAG.get(), PurrfectBlocks.GAY_FLAG.get(), PurrfectBlocks.BI_FLAG.get(),
                    PurrfectBlocks.TRANS_FLAG.get(), PurrfectBlocks.ENBY_FLAG.get(), PurrfectBlocks.GENDERFLUID_FLAG.get(), PurrfectBlocks.DEMIBOY_FLAG.get(), PurrfectBlocks.DEMIGIRL_FLAG.get(), PurrfectBlocks.DEMIGENDER_FLAG.get(), PurrfectBlocks.AGENDER_FLAG.get(),
                    PurrfectBlocks.PAN_FLAG.get(), PurrfectBlocks.OMNI_FLAG.get(), PurrfectBlocks.POLY_FLAG.get(), PurrfectBlocks.DEMISEXUAL_FLAG.get(),
                    PurrfectBlocks.ACE_FLAG.get(), PurrfectBlocks.ARO_FLAG.get(), PurrfectBlocks.AROACE_FLAG.get(),
                    PurrfectBlocks.KVASSSEXUAL_FLAG.get(), PurrfectBlocks.BEERSEXUAL_FLAG.get(),
                    PurrfectBlocks.WIZARDS_REBORN_FLAG.get(), PurrfectBlocks.FLUFFY_FUR_FLAG.get(),
                    PurrfectBlocks.WHITE_WALL_FLAG.get(), PurrfectBlocks.LIGHT_GRAY_WALL_FLAG.get(), PurrfectBlocks.GRAY_WALL_FLAG.get(), PurrfectBlocks.BLACK_WALL_FLAG.get(), PurrfectBlocks.BROWN_WALL_FLAG.get(), PurrfectBlocks.RED_WALL_FLAG.get(), PurrfectBlocks.ORANGE_WALL_FLAG.get(), PurrfectBlocks.YELLOW_WALL_FLAG.get(), PurrfectBlocks.LIME_WALL_FLAG.get(), PurrfectBlocks.GREEN_WALL_FLAG.get(), PurrfectBlocks.CYAN_WALL_FLAG.get(), PurrfectBlocks.LIGHT_BLUE_WALL_FLAG.get(), PurrfectBlocks.BLUE_WALL_FLAG.get(), PurrfectBlocks.PURPLE_WALL_FLAG.get(), PurrfectBlocks.MAGENTA_WALL_FLAG.get(), PurrfectBlocks.PINK_WALL_FLAG.get(), PurrfectBlocks.RAINBOW_WALL_FLAG.get(),
                    PurrfectBlocks.HETEROSEXUAL_WALL_FLAG.get(), PurrfectBlocks.PRIDE_WALL_FLAG.get(), PurrfectBlocks.LESBIAN_WALL_FLAG.get(), PurrfectBlocks.GAY_WALL_FLAG.get(), PurrfectBlocks.BI_WALL_FLAG.get(),
                    PurrfectBlocks.TRANS_WALL_FLAG.get(), PurrfectBlocks.ENBY_WALL_FLAG.get(), PurrfectBlocks.GENDERFLUID_WALL_FLAG.get(), PurrfectBlocks.DEMIBOY_WALL_FLAG.get(), PurrfectBlocks.DEMIGIRL_WALL_FLAG.get(), PurrfectBlocks.DEMIGENDER_WALL_FLAG.get(), PurrfectBlocks.AGENDER_WALL_FLAG.get(),
                    PurrfectBlocks.PAN_WALL_FLAG.get(), PurrfectBlocks.OMNI_WALL_FLAG.get(), PurrfectBlocks.POLY_WALL_FLAG.get(), PurrfectBlocks.DEMISEXUAL_WALL_FLAG.get(),
                    PurrfectBlocks.ACE_WALL_FLAG.get(), PurrfectBlocks.ARO_WALL_FLAG.get(), PurrfectBlocks.AROACE_WALL_FLAG.get(),
                    PurrfectBlocks.KVASSSEXUAL_WALL_FLAG.get(), PurrfectBlocks.BEERSEXUAL_WALL_FLAG.get(),
                    PurrfectBlocks.WIZARDS_REBORN_WALL_FLAG.get(), PurrfectBlocks.FLUFFY_FUR_WALL_FLAG.get())
            .build(null));

    public static final RegistryObject<BlockEntityType<BlahajBlockEntity>> BLAHAJ = BLOCK_ENTITIES.register("blahaj", () -> BlockEntityType.Builder.of(BlahajBlockEntity::new, PurrfectBlocks.BLAHAJ_PLUSH.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    @Mod.EventBusSubscriber(modid = Purrfect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientRegistryEvents {
        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            BlockEntityRenderers.register(FLAG.get(), (context) -> new FlagRenderer());
            BlockEntityRenderers.register(BLAHAJ.get(), (context) -> new PlushRenderer());
        }
    }
}
