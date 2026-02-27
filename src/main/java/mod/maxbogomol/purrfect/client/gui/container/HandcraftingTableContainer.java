package mod.maxbogomol.purrfect.client.gui.container;

import mod.maxbogomol.fluffy_fur.client.gui.screen.ContainerMenuBase;
import mod.maxbogomol.purrfect.registry.common.PurrfectMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.wrapper.InvWrapper;

public class HandcraftingTableContainer extends ContainerMenuBase {
    public final Level level;
    public final BlockPos blockPos;
    public final BlockState blockState;

    public HandcraftingTableContainer(int containerId, Level level, BlockPos pos, Inventory playerInventory, Player player) {
        super(PurrfectMenuTypes.HANDCRAFTING_TABLE_CONTAINER.get(), containerId);
        this.level = level;
        this.blockPos = pos;
        this.blockState = level.getBlockState(pos);
        playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);
        this.layoutPlayerInventorySlots(8, 166);
    }

    @Override
    public boolean stillValid(Player player) {
        return level != null && stillValid(ContainerLevelAccess.create(level, blockPos), player, blockState.getBlock());
    }

    @Override
    public int getInventorySize() {
        return 0;
    }
}