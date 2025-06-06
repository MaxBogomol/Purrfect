package mod.maxbogomol.purrfect.registry.client;

import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurModels;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.client.model.block.YarnModel;
import mod.maxbogomol.purrfect.client.model.curio.CollarModel;
import mod.maxbogomol.purrfect.client.model.curio.FlowerWreathModel;
import mod.maxbogomol.purrfect.client.render.item.PurrfectItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class PurrfectModels {
    public static ModelLayerLocation FLOWER_WREATH_LAYER = addLayer("flower_wreath");
    public static ModelLayerLocation COLLAR_LAYER = addLayer("collar");

    public static final ModelLayerLocation YARN_LAYER = addLayer("yarn");

    public static YarnModel YARN = null;

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
            event.registerLayerDefinition(FLOWER_WREATH_LAYER, FlowerWreathModel::createBodyLayer);
            event.registerLayerDefinition(COLLAR_LAYER, CollarModel::createBodyLayer);

            event.registerLayerDefinition(YARN_LAYER, YarnModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void addLayers(EntityRenderersEvent.AddLayers event) {
            YARN = new YarnModel(event.getEntityModels().bakeLayer(YARN_LAYER));
        }
    }

    public static ModelLayerLocation addLayer(String layer) {
        return FluffyFurModels.addLayer(Purrfect.MOD_ID, layer);
    }
}
