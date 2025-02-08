package mod.maxbogomol.purrfect.registry.common.entity;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.client.render.entity.YarnRenderer;
import mod.maxbogomol.purrfect.common.capability.IFurryPlayer;
import mod.maxbogomol.purrfect.common.entity.YarnEntity;
import mod.maxbogomol.wizards_reborn.WizardsReborn;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PurrfectEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Purrfect.MOD_ID);

    public static final RegistryObject<EntityType<YarnEntity>> YARN = ENTITIES.register("yarn", () -> EntityType.Builder.<YarnEntity>of(YarnEntity::new, MobCategory.MISC).sized(0.375f, 0.375f).build(new ResourceLocation(WizardsReborn.MOD_ID, "yarn").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    @Mod.EventBusSubscriber(modid = Purrfect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientRegistryEvents {
        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            EntityRenderers.register(YARN.get(), YarnRenderer::new);
        }

        @SubscribeEvent
        public static void registerCaps(RegisterCapabilitiesEvent event) {
            event.register(IFurryPlayer.class);
        }
    }
}
