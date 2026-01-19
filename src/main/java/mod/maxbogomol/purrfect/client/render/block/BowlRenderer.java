package mod.maxbogomol.purrfect.client.render.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mod.maxbogomol.purrfect.common.block.bowl.BowlBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.item.ItemDisplayContext;

import java.util.Random;

public class BowlRenderer implements BlockEntityRenderer<BowlBlockEntity> {
    @Override
    public void render(BowlBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) {
        Random random = new Random();
        random.setSeed(blockEntity.getBlockPos().asLong());

        Minecraft minecraft = Minecraft.getInstance();

        poseStack.pushPose();
        poseStack.translate(0.5F, 0.140625f, 0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(blockEntity.getBlockRotate()));
        poseStack.mulPose(Axis.YP.rotationDegrees(((random.nextFloat() - 0.5f) * 2f) * 360));
        poseStack.mulPose(Axis.XP.rotationDegrees(90F));
        poseStack.scale(0.5F,0.5F,0.5F);
        minecraft.getItemRenderer().renderStatic(blockEntity.getItemHandler().getItem(0), ItemDisplayContext.FIXED, light, overlay, poseStack, bufferSource, blockEntity.getLevel(), 0);
        poseStack.popPose();
    }
}
