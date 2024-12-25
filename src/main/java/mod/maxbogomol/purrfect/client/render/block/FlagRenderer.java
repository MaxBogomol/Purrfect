package mod.maxbogomol.purrfect.client.render.block;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mod.maxbogomol.fluffy_fur.client.render.RenderBuilder;
import mod.maxbogomol.fluffy_fur.util.RenderUtil;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.block.flag.FlagBlock;
import mod.maxbogomol.purrfect.common.block.flag.FlagBlockEntity;
import mod.maxbogomol.purrfect.common.block.flag.FlagWallBlock;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

import java.util.List;
import java.util.Optional;

public class FlagRenderer implements BlockEntityRenderer<FlagBlockEntity> {

    public static final TextureAtlasSprite spriteStandard = RenderUtil.getSprite(new ResourceLocation(Purrfect.MOD_ID, "flag/pride"));

    @Override
    public void render(FlagBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) {
        Minecraft minecraft = Minecraft.getInstance();
        Camera camera = minecraft.getBlockEntityRenderDispatcher().camera;
        boolean physics = Vec3.atCenterOf(blockEntity.getBlockPos()).closerThan(camera.getPosition(), 64f);

        int rotate = 0;
        float facing = 0;
        boolean isWall = false;
        Optional<Integer> rotation = blockEntity.getBlockState().getOptionalValue(FlagBlock.ROTATION);
        if (rotation.isPresent()) rotate = rotation.get();
        Optional<Direction> facingRotation = blockEntity.getBlockState().getOptionalValue(FlagWallBlock.FACING);
        if (facingRotation.isPresent()) {
            facing = facingRotation.get().toYRot();
            isWall = true;
        }

        poseStack.pushPose();
        poseStack.translate(0.5f, 0.5f, 0.5f);
        if (isWall) {
            poseStack.mulPose(Axis.YP.rotationDegrees(-facing - 90f));
            poseStack.mulPose(Axis.ZP.rotationDegrees(-22.5f));
            poseStack.translate(-0.42f, 0.125f, 0);
        }
        poseStack.pushPose();
        poseStack.mulPose(Axis.XP.rotationDegrees(180f));
        poseStack.mulPose(Axis.YP.rotationDegrees((float) rotate * 22.5f));
        poseStack.translate(-0.03125f, -0.4375f, 0);
        TextureAtlasSprite sprite = spriteStandard;
        if (blockEntity.getBlockState().getBlock() instanceof FlagBlock flagBlock) {
            sprite = RenderUtil.getSprite(flagBlock.getFlagTexture());
        }
        RenderBuilder builder = RenderBuilder.create().replaceBufferSource(bufferSource)
                .setRenderType(RenderType.cutout())
                .setFormat(DefaultVertexFormat.BLOCK)
                .setLight(blockEntity.isGlow ? RenderUtil.FULL_BRIGHT : light)
                .enableSided();
        if (physics) {
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 4; i++) {
                    List<Vec3> row1 = blockEntity.points.get(j);
                    List<Vec3> row2 = blockEntity.points.get(j + 1);
                    List<Vec3> rowOld1 = blockEntity.pointsOld.get(j);
                    List<Vec3> rowOld2 = blockEntity.pointsOld.get(j + 1);
                    Vector3f point1 = rowOld2.get(i).toVector3f().lerp(row2.get(i).toVector3f(), partialTicks);
                    Vector3f point2 = rowOld2.get(i + 1).toVector3f().lerp(row2.get(i + 1).toVector3f(), partialTicks);
                    Vector3f point3 = rowOld1.get(i + 1).toVector3f().lerp(row1.get(i + 1).toVector3f(), partialTicks);
                    Vector3f point4 = rowOld1.get(i).toVector3f().lerp(row1.get(i).toVector3f(), partialTicks);
                    Vector3f[] positions = new Vector3f[]{point1, point2, point3, point4};
                    float u0 = sprite.getU0() + ((sprite.getU1() - sprite.getU0()) * (i / 4f));
                    float u1 = sprite.getU0() + ((sprite.getU1() - sprite.getU0()) * ((i + 1) / 4f));
                    float v0 = sprite.getV0() + ((sprite.getV1() - sprite.getV0()) * (j / 3f) * 0.75f);
                    float v1 = sprite.getV0() + ((sprite.getV1() - sprite.getV0()) * ((j + 1) / 3f) * 0.75f);
                    builder.setUV(u0, v0, u1, v1).renderQuad(poseStack.last().pose(), positions);
                }
            }
        } else {
            float u0 = sprite.getU0();
            float u1 = sprite.getU1();
            float v0 = sprite.getV0();
            float v1 = sprite.getV0() + ((sprite.getV1() - sprite.getV0()) * 0.75f);
            builder.setUV(u0, v0, u1, v1).renderQuad(poseStack, 1f, 0.75f);
        }
        poseStack.popPose();
        poseStack.translate(0f, -0.3125f, 0);
        float u0 = sprite.getU0();
        float u1 = sprite.getU0() + ((sprite.getU1() - sprite.getU0()) * 0.0625f);
        float v0 = sprite.getV0();
        float v1 = sprite.getV0() + ((sprite.getV1() - sprite.getV0()) * 0.75f);
        builder.disableSecondSide().setUV(u0, v0, u1, v1).renderBeam(poseStack, 0.0325f, 0.75f);
        poseStack.popPose();
    }

    @Override
    public boolean shouldRender(FlagBlockEntity blockEntity, Vec3 cameraPos) {
        return true;
    }
}
