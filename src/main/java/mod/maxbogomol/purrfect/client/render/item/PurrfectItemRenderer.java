package mod.maxbogomol.purrfect.client.render.item;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mod.maxbogomol.fluffy_fur.client.render.RenderBuilder;
import mod.maxbogomol.fluffy_fur.util.RenderUtil;
import mod.maxbogomol.purrfect.common.block.flag.FlagBlock;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class PurrfectItemRenderer extends BlockEntityWithoutLevelRenderer {

    public static ItemStack flagpole;

    public PurrfectItemRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {
        super(blockEntityRenderDispatcher, entityModelSet);
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        renderFlag(stack, displayContext, poseStack, buffer, packedLight, packedOverlay);
    }

    public static void renderFlag(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        Minecraft minecraft = Minecraft.getInstance();
        if (flagpole == null) flagpole = new ItemStack(PurrfectItems.FLAGPOLE.get());

        poseStack.pushPose();
        if (displayContext == ItemDisplayContext.GUI) {
            poseStack.translate(0.75f, 0.4f, 0.75f);
        } else if (displayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
            poseStack.translate(0.25f, 0.75f, 0.75f);
            poseStack.scale(1.5f, 1.5f, 1.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(45f));
            poseStack.mulPose(Axis.ZP.rotationDegrees(-45f));
            poseStack.translate(0, 0.25f, 0);
        } else if (displayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND) {
            poseStack.translate(0.75f, 0.75f, 0.75f);
            poseStack.scale(1.5f, 1.5f, 1.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(135f));
            poseStack.mulPose(Axis.ZP.rotationDegrees(-45f));
            poseStack.translate(0, 0.25f, 0);
        } else if (displayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND) {
            poseStack.translate(0.5f, 0.75f, 0.75f);
        } else if (displayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND) {
            poseStack.translate(0.5f, 0.75f, 0.25f);
        } else {
            poseStack.translate(0.5f, 0.5f, 0.5f);
        }
        poseStack.pushPose();
        poseStack.scale(2, 2, 2);
        minecraft.getItemRenderer().renderStatic(flagpole, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, buffer, minecraft.level, 0);
        poseStack.popPose();
        if (stack.getItem() instanceof BlockItem blockItem) {
            if (blockItem.getBlock() instanceof FlagBlock flagBlock) {
                poseStack.pushPose();
                poseStack.mulPose(Axis.XP.rotationDegrees(180f));
                if (displayContext == ItemDisplayContext.GUI) {
                    poseStack.mulPose(Axis.YP.rotationDegrees(180f));
                }
                if (displayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND) {
                    poseStack.mulPose(Axis.YP.rotationDegrees(-90f));
                } else if (displayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND) {
                    poseStack.mulPose(Axis.YP.rotationDegrees(90f));
                }
                poseStack.translate(-0.03125f, -0.4375f, 0);
                RenderBuilder builder = RenderBuilder.create().replaceBufferSource(buffer)
                        .setRenderType(RenderType.cutout())
                        .setFormat(DefaultVertexFormat.BLOCK)
                        .setLight(packedLight)
                        .enableSided();
                TextureAtlasSprite sprite  = RenderUtil.getSprite(flagBlock.getFlagTexture());
                float u0 = sprite.getU0();
                float u1 = sprite.getU1();
                float v0 = sprite.getV0();
                float v1 = sprite.getV0() + ((sprite.getV1() - sprite.getV0()) * 0.75f);
                builder.setUV(u0, v0, u1, v1).renderQuad(poseStack, 1f, 0.75f);
                poseStack.popPose();

                poseStack.pushPose();
                poseStack.translate(0f, -0.3125f, 0);
                u1 = sprite.getU0() + ((sprite.getU1() - sprite.getU0()) * 0.0625f);
                builder.disableSecondSide().setUV(u0, v0, u1, v1).renderBeam(poseStack, 0.0325f, 0.75f);
                poseStack.popPose();
            }
        }
        poseStack.popPose();
    }
}
