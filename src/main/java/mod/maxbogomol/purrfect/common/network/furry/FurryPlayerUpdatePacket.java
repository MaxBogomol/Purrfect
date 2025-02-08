package mod.maxbogomol.purrfect.common.network.furry;

import mod.maxbogomol.fluffy_fur.common.network.ClientPacket;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.capability.IFurryPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.UUID;
import java.util.function.Supplier;

public class FurryPlayerUpdatePacket extends ClientPacket {
    private final UUID uuid;
    private CompoundTag tag;

    public FurryPlayerUpdatePacket(UUID uuid, CompoundTag tag) {
        this.uuid = uuid;
        this.tag = tag;
    }

    public FurryPlayerUpdatePacket(Player entity) {
        this.uuid = entity.getUUID();
        entity.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((k) -> {
            this.tag = ((INBTSerializable<CompoundTag>)k).serializeNBT();
        });
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void execute(Supplier<NetworkEvent.Context> context) {
        Level level = Purrfect.proxy.getLevel();
        Player player = level.getPlayerByUUID(uuid);
        if (player != null) {
            player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((k) -> {
                ((INBTSerializable<CompoundTag>)k).deserializeNBT(tag);
            });
        }
    }

    public static void register(SimpleChannel instance, int index) {
        instance.registerMessage(index, FurryPlayerUpdatePacket.class, FurryPlayerUpdatePacket::encode, FurryPlayerUpdatePacket::decode, FurryPlayerUpdatePacket::handle);
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(uuid);
        buf.writeNbt(tag);
    }

    public static FurryPlayerUpdatePacket decode(FriendlyByteBuf buf) {
        return new FurryPlayerUpdatePacket(buf.readUUID(), buf.readNbt());
    }
}
