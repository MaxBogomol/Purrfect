package mod.maxbogomol.purrfect.registry.common.block;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.block.pharmacist_table.PharmacistTableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PurrfectBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Purrfect.MOD_ID);

    public static final RegistryObject<Block> PHARMACIST_TABLE = BLOCKS.register("pharmacist_table", () -> new PharmacistTableBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
