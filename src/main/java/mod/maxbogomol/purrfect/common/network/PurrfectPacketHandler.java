package mod.maxbogomol.purrfect.common.network;

import mod.maxbogomol.fluffy_fur.common.network.PacketHandler;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.network.block.BlahajHeartsPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PurrfectPacketHandler extends PacketHandler {
    public static final String PROTOCOL = "10";
    public static final SimpleChannel HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(Purrfect.MOD_ID,"network"), () -> PROTOCOL, PROTOCOL::equals, PROTOCOL::equals);

    public static void init() {
        int id = 0;
        BlahajHeartsPacket.register(HANDLER, id++);
    }

    public static SimpleChannel getHandler() {
        return HANDLER;
    }

    public static void sendTo(ServerPlayer playerMP, Object toSend) {
        sendTo(getHandler(), playerMP, toSend);
    }

    public static void sendNonLocal(ServerPlayer playerMP, Object toSend) {
        sendNonLocal(getHandler(), playerMP, toSend);
    }

    public static void sendToTracking(Level level, BlockPos pos, Object msg) {
        sendToTracking(getHandler(), level, pos, msg);
    }

    public static void sendTo(Player entity, Object msg) {
        sendTo(getHandler(), entity, msg);
    }

    public static void sendToServer(Object msg) {
        sendToServer(getHandler(), msg);
    }
}