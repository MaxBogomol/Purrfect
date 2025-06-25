package mod.maxbogomol.purrfect.common.block.plush;

import mod.maxbogomol.fluffy_fur.common.block.plush.PlushBlockEntity;
import mod.maxbogomol.purrfect.registry.common.block.PurrfectBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PurrfectPlushBlockEntity extends PlushBlockEntity {

    public PurrfectPlushBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public PurrfectPlushBlockEntity(BlockPos pos, BlockState state) {
        this(PurrfectBlockEntities.PLUSH.get(), pos, state);
    }
}
