package mod.maxbogomol.purrfect.client.render.curio;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.client.model.curio.FlowerWreathModel;
import mod.maxbogomol.purrfect.common.item.equipment.curio.FlowerWreathItem;
import mod.maxbogomol.purrfect.registry.client.PurrfectModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class FlowerWreathRenderer implements ICurioRenderer {
    public static ResourceLocation BASE_TEXTURE = new ResourceLocation(Purrfect.MOD_ID, "textures/entity/curio/flower_wreath/dandelion.png");

    FlowerWreathModel model = null;

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource bufferSource, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (model == null) model = new FlowerWreathModel(Minecraft.getInstance().getEntityModels().bakeLayer(PurrfectModels.FLOWER_WREATH_LAYER));

        ResourceLocation baseTexture = BASE_TEXTURE;
        LivingEntity entity = slotContext.entity();

        if (stack.getItem() instanceof FlowerWreathItem flowerWreathItem) {
            ResourceLocation texture = flowerWreathItem.getTexture(stack, entity);
            if (texture != null) baseTexture = texture;
        }

        ICurioRenderer.followBodyRotations(entity, model);
        ICurioRenderer.followHeadRotations(entity, model.getHead());

        model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityCutoutNoCull(baseTexture)), light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
    }
}
