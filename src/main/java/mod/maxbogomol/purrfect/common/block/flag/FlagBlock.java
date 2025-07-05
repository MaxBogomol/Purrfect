package mod.maxbogomol.purrfect.common.block.flag;

import mod.maxbogomol.fluffy_fur.common.block.entity.TickableBlockEntity;
import mod.maxbogomol.fluffy_fur.common.network.BlockEntityUpdate;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.registry.common.block.PurrfectBlockTags;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItemTags;
import mod.maxbogomol.wizards_reborn.WizardsReborn;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FlagBlock extends Block implements EntityBlock, SimpleWaterloggedBlock {

    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    public static final BooleanProperty BOTTOM = BooleanProperty.create("bottom");

    private static final VoxelShape SHAPE = Block.box(6.5, 0, 6.5, 9.5, 16, 9.5);

    public static FlagColor WHITE = FlagColor.create(Purrfect.MOD_ID, "white");
    public static FlagColor LIGHT_GRAY = FlagColor.create(Purrfect.MOD_ID, "light_gray");
    public static FlagColor GRAY = FlagColor.create(Purrfect.MOD_ID, "gray");
    public static FlagColor BLACK = FlagColor.create(Purrfect.MOD_ID, "black");
    public static FlagColor BROWN = FlagColor.create(Purrfect.MOD_ID, "brown");
    public static FlagColor RED = FlagColor.create(Purrfect.MOD_ID, "red");
    public static FlagColor ORANGE = FlagColor.create(Purrfect.MOD_ID, "orange");
    public static FlagColor YELLOW = FlagColor.create(Purrfect.MOD_ID, "yellow");
    public static FlagColor LIME = FlagColor.create(Purrfect.MOD_ID, "lime");
    public static FlagColor GREEN = FlagColor.create(Purrfect.MOD_ID, "green");
    public static FlagColor CYAN = FlagColor.create(Purrfect.MOD_ID, "cyan");
    public static FlagColor LIGHT_BLUE = FlagColor.create(Purrfect.MOD_ID, "light_blue");
    public static FlagColor BLUE = FlagColor.create(Purrfect.MOD_ID, "blue");
    public static FlagColor PURPLE = FlagColor.create(Purrfect.MOD_ID, "purple");
    public static FlagColor MAGENTA = FlagColor.create(Purrfect.MOD_ID, "magenta");
    public static FlagColor PINK = FlagColor.create(Purrfect.MOD_ID, "pink");
    public static FlagColor RAINBOW = FlagColor.create(Purrfect.MOD_ID, "rainbow");
    public static FlagColor HETEROSEXUAL = FlagColor.create(Purrfect.MOD_ID, "heterosexual");
    public static FlagColor PRIDE = FlagColor.create(Purrfect.MOD_ID, "pride");
    public static FlagColor LESBIAN = FlagColor.create(Purrfect.MOD_ID, "lesbian");
    public static FlagColor GAY = FlagColor.create(Purrfect.MOD_ID, "gay");
    public static FlagColor BI = FlagColor.create(Purrfect.MOD_ID, "bi");
    public static FlagColor TRANS = FlagColor.create(Purrfect.MOD_ID, "trans");
    public static FlagColor ENBY = FlagColor.create(Purrfect.MOD_ID, "enby");
    public static FlagColor GENDERFLUID = FlagColor.create(Purrfect.MOD_ID, "genderfluid");
    public static FlagColor DEMIBOY = FlagColor.create(Purrfect.MOD_ID, "demiboy");
    public static FlagColor DEMIGIRL = FlagColor.create(Purrfect.MOD_ID, "demigirl");
    public static FlagColor DEMIGENDER = FlagColor.create(Purrfect.MOD_ID, "demigender");
    public static FlagColor AGENDER = FlagColor.create(Purrfect.MOD_ID, "agender");
    public static FlagColor PAN = FlagColor.create(Purrfect.MOD_ID, "pan");
    public static FlagColor OMNI = FlagColor.create(Purrfect.MOD_ID, "omni");
    public static FlagColor POLY = FlagColor.create(Purrfect.MOD_ID, "poly");
    public static FlagColor DEMISEXUAL = FlagColor.create(Purrfect.MOD_ID, "demisexual");
    public static FlagColor ACE = FlagColor.create(Purrfect.MOD_ID, "ace");
    public static FlagColor ARO = FlagColor.create(Purrfect.MOD_ID, "aro");
    public static FlagColor AROACE = FlagColor.create(Purrfect.MOD_ID, "aroace");
    public static FlagColor KVASSSEXUAL = FlagColor.create(Purrfect.MOD_ID, "kvasssexual");
    public static FlagColor BEERSEXUAL = FlagColor.create(Purrfect.MOD_ID, "beersexual");
    public static FlagColor WIZARDS_REBORN = FlagColor.create(Purrfect.MOD_ID, "wizards_reborn");
    public static FlagColor FLUFFY_FUR = FlagColor.create(Purrfect.MOD_ID, "fluffy_fur");
    public static FlagColor SILLY_ODDITIES = FlagColor.create(Purrfect.MOD_ID, "silly_oddities");

    public FlagColor color;

    public FlagBlock(FlagColor color, Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, false).setValue(ROTATION, Integer.valueOf(0)).setValue(TOP, false).setValue(BOTTOM, false));
        this.color = color;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.WATERLOGGED).add(ROTATION).add(TOP).add(BOTTOM);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, fluidState.getType() == Fluids.WATER).setValue(ROTATION, Integer.valueOf(RotationSegment.convertToSegment(context.getRotation() + 180.0F)));
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

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        FlagBlockEntity blockEntity = (FlagBlockEntity) level.getBlockEntity(pos);
        ItemStack stack = player.getItemInHand(hand).copy();

        if (!stack.isEmpty() && !blockEntity.isGlow) {
            if (stack.is(PurrfectItemTags.GLOW_FLAG_INGREDIENT)) {
                if (!player.getAbilities().instabuild) {
                    player.getItemInHand(hand).shrink(1);
                }
                blockEntity.isGlow = true;
                BlockEntityUpdate.packet(blockEntity);
                level.playSound(WizardsReborn.proxy.getPlayer(), player.getOnPos(), SoundEvents.GLOW_INK_SAC_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FlagBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return TickableBlockEntity.getTickerHelper();
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getFlagTexture() {
        return color.getTexture();
    }

    public static class FlagColor {
        public ResourceLocation texture;

        public FlagColor(ResourceLocation texture) {
            this.texture = texture;
        }

        @OnlyIn(Dist.CLIENT)
        public ResourceLocation getTexture() {
            return texture;
        }

        public static FlagColor create(String modId, String flag) {
            return new FlagColor(new ResourceLocation(modId, "flag/" + flag));
        }
    }
}
