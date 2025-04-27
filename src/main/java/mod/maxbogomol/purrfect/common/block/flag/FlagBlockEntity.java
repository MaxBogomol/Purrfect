package mod.maxbogomol.purrfect.common.block.flag;

import mod.maxbogomol.fluffy_fur.client.event.ClientTickHandler;
import mod.maxbogomol.fluffy_fur.common.block.entity.BlockEntityBase;
import mod.maxbogomol.fluffy_fur.common.block.entity.TickableBlockEntity;
import mod.maxbogomol.fluffy_fur.common.easing.Easing;
import mod.maxbogomol.purrfect.registry.common.block.PurrfectBlockEntities;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlagBlockEntity extends BlockEntityBase implements TickableBlockEntity {

    public List<List<Vec3>> pointsStandard = createPoints();
    public List<List<Vec3>> points = createPoints();
    public List<List<Vec3>> pointsOld = createPoints();

    public boolean isGlow = false;

    public FlagBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public FlagBlockEntity(BlockPos pos, BlockState state) {
        this(PurrfectBlockEntities.FLAG.get(), pos, state);
    }

    @Override
    public void tick() {
        if (level.isClientSide()) {
            Minecraft minecraft = Minecraft.getInstance();
            Camera camera = minecraft.getBlockEntityRenderDispatcher().camera;
            boolean physics = Vec3.atCenterOf(getBlockPos()).closerThan(camera.getPosition(), 64f);

            if (physics) {
                Random randomOffset = new Random();
                randomOffset.setSeed(getBlockPos().asLong());
                float ticks = ClientTickHandler.ticksInGame * 0.1f;
                float offset = (float) Math.sin(Math.toRadians((randomOffset.nextFloat() * randomOffset.nextFloat() * 360) + ticks));
                for (int j = 0; j <= 3; j++) {
                    for (int i = 0; i <= 4; i++) {
                        pointsOld.get(j).set(i, points.get(j).get(i));
                        if (i > 0) {
                            Vec3 vec = points.get(j).get(i);
                            Vec3 vecOld = pointsStandard.get(j).get(i);
                            Vec3 vecNew = vecStep(vecOld, vec, 1.3f * (1f - (i / 5f)));
                            float ease = Easing.SINE_IN.ease(i / 5f, 0, 1, 1);
                            points.get(j).set(i, new Vec3(vecNew.x() + ((0.1f + (random.nextFloat() * 0.01f)) * ease), vecNew.y() + ((0.1f + (random.nextFloat() * 0.01f)) * ease), vecNew.z() + ((0.25f + (random.nextFloat() * 0.1f)) * ease * offset)));
                        }
                    }
                }
            }
        }
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("isGlow", isGlow);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        isGlow = tag.getBoolean("isGlow");
    }

    @Override
    public AABB getRenderBoundingBox() {
        BlockPos pos = getBlockPos();
        return new AABB(pos.getX() - 0.5f, pos.getY() - 0.5f, pos.getZ() - 0.5f, pos.getX() + 1.5f, pos.getY() + 1.5f, pos.getZ() + 1.5f);
    }

    public List<List<Vec3>> createPoints() {
        List<List<Vec3>> points = new ArrayList<>();
        for (int j = 0; j <= 3; j++) {
            List<Vec3> row = new ArrayList<>();
            points.add(row);
            for (int i = 0; i <= 4; i++) {
                row.add(new Vec3(i / 4f, (j / 3f) * 0.75f, 0));
            }
        }
        return points;
    }

    public static Vec3 vecStep(Vec3 old, Vec3 now, float step) {
        double dX = now.x() - old.x();
        double dY = now.y() - old.y();
        double dZ = now.z() - old.z();

        double yaw = Math.atan2(dZ, dX);
        double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + Math.PI;

        float distance = (float) Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2) + Math.pow(dZ, 2));
        float speed = Math.min(distance, step);
        double x = Math.sin(pitch) * Math.cos(yaw) * speed;
        double y = Math.cos(pitch) * speed;
        double z = Math.sin(pitch) * Math.sin(yaw) * speed;
        if (distance <= step) return old;
        return new Vec3(now.x() + x, now.y() + y, now.z() + z);
    }
}
