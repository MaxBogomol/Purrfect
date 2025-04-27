package mod.maxbogomol.purrfect.common.block.blahaj;

import mod.maxbogomol.fluffy_fur.common.block.plush.PlushBlockEntity;
import mod.maxbogomol.purrfect.registry.common.block.PurrfectBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlahajBlockEntity extends PlushBlockEntity {

    public BlahajBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public BlahajBlockEntity(BlockPos pos, BlockState state) {
        this(PurrfectBlockEntities.BLAHAJ.get(), pos, state);
    }
}
