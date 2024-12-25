package mod.maxbogomol.purrfect.common.block.flag;

import mod.maxbogomol.purrfect.registry.common.block.PurrfectBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FlagpoleBlock extends Block implements SimpleWaterloggedBlock {

    public static final BooleanProperty TOP = BooleanProperty.create("top");
    public static final BooleanProperty BOTTOM = BooleanProperty.create("bottom");

    private static final VoxelShape SHAPE = Block.box(6.5, 0, 6.5, 9.5, 16, 9.5);

    public FlagpoleBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, false).setValue(TOP, false).setValue(BOTTOM, false));
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.WATERLOGGED).add(TOP).add(BOTTOM);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, fluidState.getType() == Fluids.WATER);
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
        boolean top = false;
        boolean bottom = false;
        if (level.getBlockState(currentPos.above()).is(PurrfectBlockTags.FLAGPOLE_CONNECTION)) {
            top = true;
        }
        if (level.getBlockState(currentPos.below()).is(PurrfectBlockTags.FLAGPOLE_CONNECTION)) {
            bottom = true;
        }

        return state.setValue(TOP, top).setValue(BOTTOM, bottom);
    }
}
