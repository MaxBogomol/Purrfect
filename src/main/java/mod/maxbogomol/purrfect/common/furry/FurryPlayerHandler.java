package mod.maxbogomol.purrfect.common.furry;

import mod.maxbogomol.purrfect.common.capability.IFurryPlayer;
import mod.maxbogomol.purrfect.common.item.equipment.LeashItem;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.common.network.furry.FurryPlayerUpdatePacket;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class FurryPlayerHandler {

    public static void leashedTick(TickEvent.LevelTickEvent event) {
        Level level = event.level;
        if (!level.isClientSide()) {
            for (Player player : level.players()) {
                Map<Integer, Player> leashedPlayers = FurryPlayerHandler.getLeashedPlayers(player);
                Map<Integer, ItemStack> leashes = FurryPlayerHandler.getLeashes(player);
                for (int index : leashedPlayers.keySet()) {
                    boolean breakLeash = false;
                    Player target = leashedPlayers.get(index);
                    ItemStack itemStack = leashes.get(index);
                    if (target != null) {
                        if (!(itemStack != null && itemStack.getItem() instanceof LeashItem leashItem && leashItem.equals(player.getInventory().getItem(index).getItem()))) {
                            breakLeash = true;
                        }
                        if (!level.players().contains(target)) breakLeash = true;
                        if (!hasCollar(target)) breakLeash = true;
                    } else {
                        breakLeash = true;
                    }
                    if (breakLeash) {
                        FurryPlayerHandler.setLeashedPlayer(player, index, null);
                        FurryPlayerHandler.setLeash(player, index, null);
                        if (target != null) level.playSound(null, target.position().x(), target.position().y(), target.position().z(), SoundEvents.LEASH_KNOT_BREAK, SoundSource.PLAYERS, 1f, 1f);
                    } else {
                        if (Math.sqrt(target.distanceToSqr(player)) > 10) {
                            double dX = target.getX() - player.getX();
                            double dY = target.getY() - player.getY();
                            double dZ = target.getZ() - player.getZ();

                            double yaw = Math.atan2(dZ, dX);
                            double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + Math.PI;

                            float speed = 0.1f;
                            double x = Math.sin(pitch) * Math.cos(yaw) * speed;
                            double y = Math.cos(pitch) * speed;
                            double z = Math.sin(pitch) * Math.sin(yaw) * speed;
                            target.push(x, y, z);
                            target.hurtMarked = true;
                            target.resetFallDistance();
                        }
                    }
                }
            }
        }
    }

    public static boolean hasCollar(Player player) {
        List<ItemStack> items = new ArrayList<>();
        LazyOptional<ICuriosItemHandler> curiosItemHandler = CuriosApi.getCuriosInventory(player);
        if (curiosItemHandler.isPresent() && curiosItemHandler.resolve().isPresent()) {
            List<SlotResult> curioSlots = curiosItemHandler.resolve().get().findCurios((i) -> true);
            for (SlotResult slot : curioSlots) {
                if (slot.stack().is(PurrfectItemTags.LEASH_COLLARS)) {
                    items.add(slot.stack());
                }
            }
        }

        return !items.isEmpty();
    }

    public static void setLeashedPlayer(Player player, int i, Player leashedPlayer) {
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((s) -> {
            s.setLeashedPlayer(i, leashedPlayer);

            PurrfectPacketHandler.sendTo(player, new FurryPlayerUpdatePacket(player));
            for (ServerPlayer serverPlayer : player.getServer().getPlayerList().getPlayers()) {
                PurrfectPacketHandler.sendTo(serverPlayer, new FurryPlayerUpdatePacket(player));
            }
        });
    }

    public static Player getLeashedPlayer(Player player, int i) {
        AtomicReference<Player> set = new AtomicReference<>();
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((s) -> {
            set.set(s.getLeashedPlayer(i));
        });
        return set.get();
    }

    public static void clearLeashedPlayers(Player player) {
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((s) -> {
            s.clearLeashedPlayers();

            PurrfectPacketHandler.sendTo(player, new FurryPlayerUpdatePacket(player));
            for (ServerPlayer serverPlayer : player.getServer().getPlayerList().getPlayers()) {
                PurrfectPacketHandler.sendTo(serverPlayer, new FurryPlayerUpdatePacket(player));
            }
        });
    }

    public static void clearLeashedPlayersLeave(Player player) {
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((s) -> {
            s.clearLeashedPlayers();

            for (ServerPlayer serverPlayer : player.getServer().getPlayerList().getPlayers()) {
                PurrfectPacketHandler.sendTo(serverPlayer, new FurryPlayerUpdatePacket(player));
            }
        });
    }

    public static Map<Integer, Player> getLeashedPlayers(Player player) {
        AtomicReference<Map<Integer, Player>> set = new AtomicReference<>();
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((s) -> {
            set.set(s.getLeashedPlayers());
        });
        return set.get();
    }

    public static void setLeash(Player player, int i, ItemStack itemStack) {
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((s) -> {
            s.setLeash(i, itemStack);

            PurrfectPacketHandler.sendTo(player, new FurryPlayerUpdatePacket(player));
            for (ServerPlayer serverPlayer : player.getServer().getPlayerList().getPlayers()) {
                PurrfectPacketHandler.sendTo(serverPlayer, new FurryPlayerUpdatePacket(player));
            }
        });
    }

    public static ItemStack getLeash(Player player, int i) {
        AtomicReference<ItemStack> set = new AtomicReference<>();
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((s) -> {
            set.set(s.getLeash(i));
        });
        return set.get();
    }

    public static void clearLeashes(Player player) {
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent(IFurryPlayer::clearLeashes);
    }

    public static void clearLeashesLeave(Player player) {
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent(IFurryPlayer::clearLeashes);
    }

    public static Map<Integer, ItemStack> getLeashes(Player player) {
        AtomicReference<Map<Integer, ItemStack>> set = new AtomicReference<>();
        player.getCapability(IFurryPlayer.INSTANCE, null).ifPresent((s) -> {
            set.set(s.getLeashes());
        });
        return set.get();
    }
}
