package mod.maxbogomol.purrfect.common.network.block;

import mod.maxbogomol.fluffy_fur.common.network.ServerPacket;
import mod.maxbogomol.purrfect.common.hadcrafting.ShipkeysHandcraftingTab;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.Supplier;

public class HandcraftingShipkeysCopyPacket extends ServerPacket {

    @Override
    public void execute(Supplier<NetworkEvent.Context> context) {
        ServerPlayer player = context.get().getSender();
        ServerLevel level = player.serverLevel();

        if (ShipkeysHandcraftingTab.canCraftRecipe(player)) {
            ShipkeysHandcraftingTab.craftRecipe(player, level);
        }
    }

    public static void register(SimpleChannel instance, int index) {
        instance.registerMessage(index, HandcraftingShipkeysCopyPacket.class, HandcraftingShipkeysCopyPacket::encode, HandcraftingShipkeysCopyPacket::decode, HandcraftingShipkeysCopyPacket::handle);
    }

    public static HandcraftingShipkeysCopyPacket decode(FriendlyByteBuf buf) {
        return new HandcraftingShipkeysCopyPacket();
    }
}
