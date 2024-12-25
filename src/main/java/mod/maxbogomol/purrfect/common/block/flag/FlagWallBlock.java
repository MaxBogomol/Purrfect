package mod.maxbogomol.purrfect.common.block.flag;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public class FlagWallBlock extends FlagBlock implements EntityBlock, SimpleWaterloggedBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(6.5, 5, 13, 9.5, 16, 16), Direction.SOUTH, Block.box(6.5, 5, 0, 9.5, 16, 3), Direction.WEST, Block.box(13, 5, 6.5, 16, 16, 9.5), Direction.EAST, Block.box(0, 5, 6.5, 3, 16, 9.5)));

    public FlagWallBlock(FlagColor color, Properties properties) {
        super(color, properties);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, false).setValue(ROTATION, Integer.valueOf(0)).setValue(TOP, false).setValue(BOTTOM, false).setValue(FACING, Direction.NORTH));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return getShape(state);
    }

    public static VoxelShape getShape(BlockState state) {
        return SHAPES.get(state.getValue(FACING));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.WATERLOGGED).add(ROTATION).add(TOP).add(BOTTOM).add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = this.defaultBlockState();
        LevelReader levelreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Direction[] adirection = context.getNearestLookingDirections();
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());

        for(Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.setValue(FACING, direction1);
                if (blockstate.canSurvive(levelreader, blockpos)) {
                    return blockstate.setValue(BlockStateProperties.WATERLOGGED, fluidState.getType() == Fluids.WATER);
                }
            }
        }

        return null;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(BlockStateProperties.WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getOpposite() == state.getValue(FACING) && !state.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : state;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos blockpos = pos.relative(direction.getOpposite());
        BlockState blockstate = level.getBlockState(blockpos);
        return blockstate.isFaceSturdy(level, blockpos, direction);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation pRotation) {
        return state.setValue(FACING, pRotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror pMirror) {
        return state.rotate(pMirror.getRotation(state.getValue(FACING)));
    }
}
