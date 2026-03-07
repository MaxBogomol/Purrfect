package mod.maxbogomol.purrfect.common.network.block;

import mod.maxbogomol.fluffy_fur.common.network.ServerPacket;
import mod.maxbogomol.purrfect.common.hadcrafting.CollarsHandcraftingTab;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.Supplier;

public class HandcraftingCollarTagPacket extends ServerPacket {

    @Override
    public void execute(Supplier<NetworkEvent.Context> context) {
        ServerPlayer player = context.get().getSender();
        ServerLevel level = player.serverLevel();

        if (CollarsHandcraftingTab.canCraftRecipe(player)) {
            CollarsHandcraftingTab.setTag(player, level);
        }
    }

    public static void register(SimpleChannel instance, int index) {
        instance.registerMessage(index, HandcraftingCollarTagPacket.class, HandcraftingCollarTagPacket::encode, HandcraftingCollarTagPacket::decode, HandcraftingCollarTagPacket::handle);
    }

    public static HandcraftingCollarTagPacket decode(FriendlyByteBuf buf) {
        return new HandcraftingCollarTagPacket();
    }
}
