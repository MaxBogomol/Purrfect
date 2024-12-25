package mod.maxbogomol.purrfect.registry.client;

import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurModels;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.client.model.curio.CollarModel;
import mod.maxbogomol.purrfect.client.render.item.PurrfectItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class PurrfectModels {
    public static ModelLayerLocation COLLAR_LAYER = addLayer("collar");

    public static PurrfectItemRenderer itemRenderer;

    @Mod.EventBusSubscriber(modid = Purrfect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientRegistryEvents {
        @SubscribeEvent
        public static void registerModels(FMLClientSetupEvent event) {
            Minecraft minecraft = Minecraft.getInstance();
            itemRenderer = new PurrfectItemRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels());
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(COLLAR_LAYER, CollarModel::createBodyLayer);
        }
    }

    public static ModelLayerLocation addLayer(String layer) {
        return FluffyFurModels.addLayer(Purrfect.MOD_ID, layer);
    }
}
