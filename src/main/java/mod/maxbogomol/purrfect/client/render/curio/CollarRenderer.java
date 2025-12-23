package mod.maxbogomol.purrfect.client.render.curio;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.furry.CollarPart;
import mod.maxbogomol.purrfect.client.model.curio.CollarModel;
import mod.maxbogomol.purrfect.common.collar.AccessoryCollarPart;
import mod.maxbogomol.purrfect.common.collar.ColorCollarPart;
import mod.maxbogomol.purrfect.common.collar.DecorationCollarPart;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import mod.maxbogomol.purrfect.registry.client.PurrfectModels;
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

public class CollarRenderer implements ICurioRenderer {
    public static ResourceLocation BASE_TEXTURE = new ResourceLocation(Purrfect.MOD_ID, "textures/entity/curio/collar/collar.png");

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource bufferSource, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        CollarModel model = PurrfectModels.COLLAR;
        CollarModel accessoryModel = PurrfectModels.COLLAR;
        CollarModel decorationModel = PurrfectModels.COLLAR;

        ResourceLocation baseTexture = BASE_TEXTURE;
        ResourceLocation accessoryTexture = null;
        ResourceLocation decorationTexture = null;
        LivingEntity entity = slotContext.entity();

        CollarPart colorPart = CollarItem.getColor(stack);
        CollarPart accessoryPart = CollarItem.getAccessory(stack);
        CollarPart decorationPart = CollarItem.getDecoration(stack);

        if (colorPart instanceof ColorCollarPart colorCollarPart) {
            baseTexture = colorCollarPart.getTexture();
        }
        if (accessoryPart instanceof AccessoryCollarPart accessoryCollarPart) {
            accessoryTexture = accessoryCollarPart.getTexture();
            accessoryModel = accessoryCollarPart.getCollarModel();
        }
        if (decorationPart instanceof DecorationCollarPart decorationCollarPart) {
            decorationTexture = decorationCollarPart.getTexture();
            decorationModel = decorationCollarPart.getCollarModel();
        }

        ICurioRenderer.followBodyRotations(entity, model);

        model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        model.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityCutoutNoCull(baseTexture)), light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        if (decorationTexture != null) {
            decorationModel.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityCutoutNoCull(decorationTexture)), light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        }
        if (accessoryTexture != null) {
            accessoryModel.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityCutoutNoCull(accessoryTexture)), light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        }
    }
}
