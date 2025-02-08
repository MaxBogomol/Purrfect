package mod.maxbogomol.purrfect.common.entity;

import mod.maxbogomol.fluffy_fur.client.render.trail.TrailPoint;
import mod.maxbogomol.fluffy_fur.client.render.trail.TrailPointBuilder;
import mod.maxbogomol.purrfect.registry.common.entity.PurrfectEntities;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class YarnEntity extends ThrowableItemProjectile {
    public static double MAXIMUM_COLLISION_VELOCITY_SQUARED = Mth.square(100.0D);

    public TrailPointBuilder trailPointBuilder = TrailPointBuilder.create(25);
    public TrailPointBuilder oldTrailPointBuilder = TrailPointBuilder.create(25);
    public double trailLength = 0;
    public double roll = 0;
    public double oldRoll = 0;
    public boolean isMoved = false;

    public YarnEntity(EntityType<?> type, Level level) {
        super(PurrfectEntities.YARN.get(), level);
        blocksBuilding = true;
    }

    public YarnEntity(Level level, LivingEntity shooter) {
        super(PurrfectEntities.YARN.get(), shooter, level);
        this.blocksBuilding = true;
    }

    @Override
    protected Item getDefaultItem() {
        return PurrfectItems.WHITE_YARN.get();
    }

    @Override
    public void tick() {
        float f = 0.99F;
        float g = getGravity();
        if (isInWater()) {
            f = 0.95F;
            g = g * 0.25f;
        }
        if (onGround()) {
            f = f * 0.75f;
        }
        isMoved = false;

        Vec3 motion = getDeltaMovement();
        setDeltaMovement(motion.x * f, (motion.y > 0 ? motion.y * f : motion.y) - g, motion.z * f);
        motion = getDeltaMovement();

        Vec3 pos = position();
        xo = pos.x;
        yo = pos.y;
        zo = pos.z;

        double x = motion.x();
        double y = motion.y();
        double z = motion.z();

        double Y = motion.y();

        if (!noPhysics && (x != 0.0D || y != 0.0D || z != 0.0D) && x * x + y * y + z * z < MAXIMUM_COLLISION_VELOCITY_SQUARED) {
            Vec3 vec3 = Entity.collideBoundingBox(this, new Vec3(x, y, z), this.getBoundingBox(), level(), List.of());
            x = vec3.x;
            y = vec3.y;
            z = vec3.z;
            setDeltaMovement(x, y, z);
            motion = getDeltaMovement();
        }
        setOnGround(Y != y && Y < 0.0D);

        setPos(pos.x + motion.x, pos.y + motion.y, pos.z + motion.z);
        trailLength = trailLength + motion.distanceToSqr(Vec3.ZERO);
        oldRoll = roll;
        roll = roll + motion.distanceToSqr(Vec3.ZERO);

        if (trailLength > 0) {
            Vec3 vec3 = getDeltaMovement();
            double d0 = vec3.horizontalDistance();
            setYRot((float) (Mth.atan2(vec3.x, vec3.z) * (double) (180F / (float) Math.PI)));
            setXRot((float) (Mth.atan2(vec3.y, d0) * (double) (180F / (float) Math.PI)));
            yRotO = getYRot();
            xRotO = getXRot();
        }

        checkInsideBlocks();
        updateInWaterStateAndDoFluidPushing();

        if (level().isClientSide()) {
            if (trailLength > 0.1f) {
                addTrail(new Vec3(position().toVector3f()));
                trailPointBuilder.tickTrailPoints();
                addOldTrail(new Vec3(position().toVector3f()));
                oldTrailPointBuilder.tickTrailPoints();
                trailLength = 0;
                isMoved = true;
            }
            oldTrailPointBuilder.trailPoints.clear();
            for (TrailPoint trailPoint : trailPointBuilder.trailPoints) {
                addOldTrail(new Vec3(trailPoint.getPosition().toVector3f()));
            }
            for (TrailPoint trailPoint : trailPointBuilder.trailPoints) {
                x = 0;
                y = -0.1f;
                z = 0;
                AABB boundingBox = new AABB(trailPoint.getPosition(), trailPoint.getPosition());
                if (x * x + y * y + z * z < MAXIMUM_COLLISION_VELOCITY_SQUARED) {
                    Vec3 vec3 = Entity.collideBoundingBox(null, new Vec3(x, y, z), boundingBox, level(), List.of());
                    x = vec3.x;
                    y = vec3.y;
                    z = vec3.z;
                }
                trailPoint.setPosition(trailPoint.getPosition().add(x, y, z));
            }
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() != null) {
            Vec3 vec = source.getEntity().getLookAngle().scale(0.25f);
            push(vec.x(), 0.3f, vec.z());
            hurtMarked = true;
            sound();
            return true;
        }
        return false;
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (tickCount > 20) {
            player.addItem(getItem());
            discard();
            sound();
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public void push(double x, double y, double z) {
        super.push(x, y, z);
    }

    public void addTrail(Vec3 pos) {
        trailPointBuilder.addTrailPoint(pos);
    }

    public void addOldTrail(Vec3 pos) {
        oldTrailPointBuilder.addTrailPoint(pos);
    }

    public void sound(float volume, float pitch) {
        level().playSound(null, position().x(), position().y(), position().z(), SoundEvents.SNOW_BREAK, SoundSource.PLAYERS, volume, pitch);
    }

    public void sound() {
        sound(1f, 1f);
    }
}
