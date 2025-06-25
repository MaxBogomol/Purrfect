package mod.maxbogomol.purrfect.common.block.plush;

import mod.maxbogomol.fluffy_fur.common.block.plush.PlushBlock;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.common.network.block.BlahajHeartsPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class FishBlock extends PlushBlock {

    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 4, 12);

    public FishBlock(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            level.playSound(null, pos, SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.BLOCKS, 1.0f, 1.0f);
            PurrfectPacketHandler.sendToTracking(level, pos, new BlahajHeartsPacket(pos));
        }

        return InteractionResult.SUCCESS;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(BlockStateProperties.WATERLOGGED)) {
            if (random.nextFloat() < 0.25f) {
                int rotate = 0;
                Optional<Integer> rotation = state.getOptionalValue(PlushBlock.ROTATION);
                if (rotation.isPresent()) rotate = rotation.get();
                float x = (float) Math.cos(Math.toRadians(rotate * 22.5f + 90f)) * 0.35f;
                float z = (float) Math.sin(Math.toRadians(rotate * 22.5f + 90f)) * 0.35f;
                level.addParticle(ParticleTypes.BUBBLE, pos.getX() + 0.5f + x, pos.getY() + 0.2f, pos.getZ() + 0.5f + z, (random.nextFloat() - 0.5f) / 3f, 0.2f + (random.nextFloat() / 6f), (random.nextFloat() - 0.5f) / 3f);
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PurrfectPlushBlockEntity(pos, state);
    }
}
