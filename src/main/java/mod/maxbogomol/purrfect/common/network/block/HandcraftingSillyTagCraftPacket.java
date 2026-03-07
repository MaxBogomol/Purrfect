package mod.maxbogomol.purrfect.common.network.block;

import mod.maxbogomol.fluffy_fur.common.network.ServerPacket;
import mod.maxbogomol.purrfect.common.hadcrafting.SillyTagsHandcraftingTab;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.Supplier;

public class HandcraftingSillyTagCraftPacket extends ServerPacket {
    protected final String id;

    public HandcraftingSillyTagCraftPacket(String id) {
        this.id = id;
    }

    @Override
    public void execute(Supplier<NetworkEvent.Context> context) {
        ServerPlayer player = context.get().getSender();
        ServerLevel level = player.serverLevel();

        if (SillyTagsHandcraftingTab.canCraftRecipe(player)) {
            SillyTagsHandcraftingTab.craftRecipe(player, level, id);
        }
    }

    public static void register(SimpleChannel instance, int index) {
        instance.registerMessage(index, HandcraftingSillyTagCraftPacket.class, HandcraftingSillyTagCraftPacket::encode, HandcraftingSillyTagCraftPacket::decode, HandcraftingSillyTagCraftPacket::handle);
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeUtf(id);
    }

    public static HandcraftingSillyTagCraftPacket decode(FriendlyByteBuf buf) {
        return new HandcraftingSillyTagCraftPacket(buf.readUtf());
    }
}
