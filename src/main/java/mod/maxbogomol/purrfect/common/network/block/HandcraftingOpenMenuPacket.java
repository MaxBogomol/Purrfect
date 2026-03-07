package mod.maxbogomol.purrfect.common.network.block;

import mod.maxbogomol.fluffy_fur.common.network.ServerPacket;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingHandler;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTab;
import mod.maxbogomol.purrfect.registry.common.PurrfectHandcraftingTabs;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.Supplier;

public class HandcraftingOpenMenuPacket extends ServerPacket {
    protected final BlockPos blockPos;
    protected final String id;

    public HandcraftingOpenMenuPacket(BlockPos blockPos, String id) {
        this.blockPos = blockPos;
        this.id = id;
    }

    public HandcraftingOpenMenuPacket(BlockPos blockPos, HandcraftingTab tab) {
        this.blockPos = blockPos;
        this.id = tab.getId();
    }

    @Override
    public void execute(Supplier<NetworkEvent.Context> context) {
        ServerPlayer player = context.get().getSender();
        ServerLevel level = player.serverLevel();

        HandcraftingTab tab = HandcraftingHandler.getTab(id);
        if (tab == null) tab = PurrfectHandcraftingTabs.HANDCRAFTING;

        BlockState blockState = level.getBlockState(blockPos);
        NetworkHooks.openScreen(player, HandcraftingHandler.getMenuProvider(blockState, level, blockPos, tab), b -> {b.writeBlockPos(blockPos); b.writeUtf(id);});
    }

    public static void register(SimpleChannel instance, int index) {
        instance.registerMessage(index, HandcraftingOpenMenuPacket.class, HandcraftingOpenMenuPacket::encode, HandcraftingOpenMenuPacket::decode, HandcraftingOpenMenuPacket::handle);
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(blockPos);
        buf.writeUtf(id);
    }

    public static HandcraftingOpenMenuPacket decode(FriendlyByteBuf buf) {
        return new HandcraftingOpenMenuPacket(buf.readBlockPos(), buf.readUtf());
    }
}
