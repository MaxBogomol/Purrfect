package mod.maxbogomol.purrfect.client.render.entity;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mod.maxbogomol.fluffy_fur.client.render.RenderBuilder;
import mod.maxbogomol.fluffy_fur.client.render.trail.TrailPoint;
import mod.maxbogomol.fluffy_fur.util.RenderUtil;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.entity.YarnEntity;
import mod.maxbogomol.purrfect.common.item.YarnItem;
import mod.maxbogomol.purrfect.registry.client.PurrfectModels;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class YarnRenderer<T extends YarnEntity> extends EntityRenderer<T> {

    public static final ResourceLocation spriteStandard = new ResourceLocation(Purrfect.MOD_ID, "textures/yarn/white.png");
    public static final TextureAtlasSprite trailSpriteStandard = RenderUtil.getSprite(new ResourceLocation(Purrfect.MOD_ID, "yarn/white_trail"));

    public YarnRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(YarnEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        ResourceLocation sprite = spriteStandard;
        TextureAtlasSprite trailSprite = trailSpriteStandard;
        if (entity.getItem().getItem() instanceof YarnItem yarnItem) {
            sprite = yarnItem.getYarnTexture();
            trailSprite = RenderUtil.getSprite(yarnItem.getYarnTrailTexture());
        }
        float u0 = trailSprite.getU0();
        float u1 = trailSprite.getU0() + ((trailSprite.getU1() - trailSprite.getU0()) * 0.1875f);
        float v0 = trailSprite.getV0();
        float v1 = trailSprite.getV0() + ((trailSprite.getV1() - trailSprite.getV0()) * 0.75f);

        poseStack.pushPose();
        poseStack.translate(0, 0.15625f, 0);
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(180f));
        poseStack.mulPose(Axis.XP.rotationDegrees((float) Mth.lerp(partialTicks, entity.oldRoll, entity.roll) * 100f));
        PurrfectModels.YARN.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityCutoutNoCull(sprite)), light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        poseStack.popPose();

        List<TrailPoint> trail = new ArrayList<>(entity.trailPointBuilder.getTrailPoints());
        List<TrailPoint> oldTrail = new ArrayList<>(entity.oldTrailPointBuilder.getTrailPoints());
        for (int i = 0; i < trail.size(); i++) {
            TrailPoint position = trail.get(i);
            TrailPoint oldPosition= oldTrail.get(i);
            float x = (float) Mth.lerp(partialTicks, oldPosition.getPosition().x, position.getPosition().x);
            float y = (float) Mth.lerp(partialTicks, oldPosition.getPosition().y, position.getPosition().y);
            float z = (float) Mth.lerp(partialTicks, oldPosition.getPosition().z, position.getPosition().z);
            trail.set(i, new TrailPoint(new Vec3(x, y, z)));
        }

        if (trail.size() > 1 && entity.tickCount >= entity.trailPointBuilder.trailLength.get() && entity.isMoved) {
            TrailPoint position = trail.get(0);
            TrailPoint nextPosition = trail.get(1);
            float x = (float) Mth.lerp(partialTicks, position.getPosition().x, nextPosition.getPosition().x);
            float y = (float) Mth.lerp(partialTicks, position.getPosition().y, nextPosition.getPosition().y);
            float z = (float) Mth.lerp(partialTicks, position.getPosition().z, nextPosition.getPosition().z);
            trail.set(0, new TrailPoint(new Vec3(x, y, z)));
        }

        float x = (float) Mth.lerp(partialTicks, entity.xOld, entity.getX());
        float y = (float) Mth.lerp(partialTicks, entity.yOld, entity.getY());
        float z = (float) Mth.lerp(partialTicks, entity.zOld, entity.getZ());

        if (trail.size() > 0) {
            trail.set(trail.size() - 1, new TrailPoint(new Vec3(x, y, z)));
        }

        poseStack.pushPose();
        poseStack.translate(-x, -y, -z);
        poseStack.translate(0, 0.15625f, 0);
        RenderBuilder.create().replaceBufferSource(bufferSource)
                .setUV(u0, v0, u1, v1)
                .setRenderType(RenderType.cutout())
                .setFormat(DefaultVertexFormat.BLOCK)
                .setLight(light)
                .renderTrail(poseStack, trail, (f) -> RenderUtil.FULL_WIDTH_FUNCTION.apply(f) * 0.125f);
        poseStack.popPose();
    }

    @Override
    public boolean shouldRender(T livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return null;
    }
}