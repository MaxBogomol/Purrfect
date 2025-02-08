package mod.maxbogomol.purrfect.client.render;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import mod.maxbogomol.fluffy_fur.client.render.RenderBuilder;
import mod.maxbogomol.fluffy_fur.client.render.trail.TrailPoint;
import mod.maxbogomol.fluffy_fur.util.RenderUtil;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.furry.FurryPlayerHandler;
import mod.maxbogomol.purrfect.common.item.equipment.LeashItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLevelStageEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeashRenderHandler {
    public static List<TrailPoint> trailPoints = new ArrayList<>();
    public static final TextureAtlasSprite spriteStandard = RenderUtil.getSprite(new ResourceLocation(Purrfect.MOD_ID, "leash/leash"));

    @OnlyIn(Dist.CLIENT)
    public static void leashRender(RenderLevelStageEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        float partialTicks = event.getPartialTick();
        PoseStack poseStack = event.getPoseStack();

        Vec3 camera = minecraft.gameRenderer.getMainCamera().getPosition();
        Level level = Purrfect.proxy.getLevel();

        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_WEATHER) {
            for (Player player : level.players()) {
                Map<Integer, Player> leashedPlayers = FurryPlayerHandler.getLeashedPlayers(player);
                Map<Integer, ItemStack> leashes = FurryPlayerHandler.getLeashes(player);
                for (int index : leashedPlayers.keySet()) {
                    Player target = leashedPlayers.get(index);
                    if (target != null) {
                        Vec3 pos = target.getPosition(partialTicks);
                        ItemStack itemStack = leashes.get(index);

                        TextureAtlasSprite sprite = spriteStandard;
                        if (itemStack != null && itemStack.getItem() instanceof LeashItem leashItem) {
                            sprite = RenderUtil.getSprite(leashItem.getLeashTexture());
                        }

                        poseStack.pushPose();
                        poseStack.translate(-camera.x(), -camera.y(), -camera.z());
                        poseStack.translate(pos.x(), pos.y(), pos.z());
                        renderLeash(sprite, target, partialTicks, poseStack, Minecraft.getInstance().renderBuffers().bufferSource(), player);
                        poseStack.popPose();
                    }
                }
            }
        }
    }

    public static void renderLeash(TextureAtlasSprite sprite, LivingEntity entityLiving, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, Entity leashHolder) {
        float u0 = sprite.getU0();
        float u1 = sprite.getU0() + ((sprite.getU1() - sprite.getU0()) * 0.0625f);
        float v0 = sprite.getV0();
        float v1 = sprite.getV0() + ((sprite.getV1() - sprite.getV0()) * 0.75f);

        poseStack.pushPose();
        Vec3 vec3 = leashHolder.getRopeHoldPosition(partialTicks);
        double d0 = (double) (Mth.lerp(partialTicks, entityLiving.yBodyRotO, entityLiving.yBodyRot) * ((float)Math.PI / 180F)) + (Math.PI / 2D);
        Vec3 vec31 = new Vec3(0.0D, (double) entityLiving.getEyeHeight() - 0.3f, (entityLiving.getBbWidth() * 0.2F)); //entityLiving.getLeashOffset(partialTicks);
        double d1 = Math.cos(d0) * vec31.z + Math.sin(d0) * vec31.x;
        double d2 = Math.sin(d0) * vec31.z - Math.cos(d0) * vec31.x;
        double d3 = Mth.lerp(partialTicks, entityLiving.xo, entityLiving.getX()) + d1;
        double d4 = Mth.lerp(partialTicks, entityLiving.yo, entityLiving.getY()) + vec31.y;
        double d5 = Mth.lerp(partialTicks, entityLiving.zo, entityLiving.getZ()) + d2;

        poseStack.translate(d1, vec31.y, d2);

        float f = (float) (vec3.x - d3);
        float f1 = (float) (vec3.y - d4);
        float f2 = (float) (vec3.z - d5);
        BlockPos blockpos = BlockPos.containing(entityLiving.getEyePosition(partialTicks));
        BlockPos blockpos1 = BlockPos.containing(leashHolder.getEyePosition(partialTicks));
        int i = getBlockLightLevel(entityLiving, blockpos);
        int j = getBlockLightLevel(leashHolder, blockpos1);
        int k = entityLiving.level().getBrightness(LightLayer.SKY, blockpos);
        int l = entityLiving.level().getBrightness(LightLayer.SKY, blockpos1);

        for (int i1 = 0; i1 <= 24; ++i1) {
            addTrailPoint(f, f1, f2, i1);
        }

        RenderBuilder.create().replaceBufferSource(buffer)
                .setUV(u0, v0, u1, v1)
                .setRenderType(RenderType.cutout())
                .setFormat(DefaultVertexFormat.BLOCK)
                .setFirstLight(LightTexture.pack(i, k))
                .setSecondLight(LightTexture.pack(j, l))
                .renderTrail(poseStack, trailPoints, (f3) -> RenderUtil.FULL_WIDTH_FUNCTION.apply(f3) * 0.05f);
        trailPoints.clear();
        poseStack.popPose();
    }

    public static void addTrailPoint(float x, float y, float z, int i) {
        float f = (float) i / 24.0F;
        float f5 = x * f;
        float f6 = y > 0.0F ? y * f * f : y - y * (1.0F - f) * (1.0F - f);
        float f7 = z * f;
        trailPoints.add(new TrailPoint(new Vec3(f5, f6, f7)));
    }

    public static int getBlockLightLevel(Entity entity, BlockPos pos) {
        return entity.isOnFire() ? 15 : entity.level().getBrightness(LightLayer.BLOCK, pos);
    }
}
