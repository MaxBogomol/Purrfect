package mod.maxbogomol.purrfect.common.capability;

import mod.maxbogomol.purrfect.Purrfect;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FurryPlayerImpl implements IFurryPlayer, INBTSerializable<CompoundTag> {
    public Map<Integer, Player> leashedPlayers = new HashMap<>();
    public Map<Integer, ItemStack> leashes = new HashMap<>();

    @Override
    public void setLeashedPlayer(int i, Player player) {
        leashedPlayers.put(i, player);
    }

    @Override
    public Player getLeashedPlayer(int i) {
        return leashedPlayers.get(i);
    }

    @Override
    public void clearLeashedPlayers() {
        leashedPlayers.clear();
    }

    @Override
    public Map<Integer, Player> getLeashedPlayers() {
        return leashedPlayers;
    }

    @Override
    public void setLeash(int i, ItemStack itemStack) {
        leashes.put(i, itemStack);
    }

    @Override
    public ItemStack getLeash(int i) {
        return leashes.get(i);
    }

    @Override
    public void clearLeashes() {
        leashes.clear();
    }

    @Override
    public Map<Integer, ItemStack> getLeashes() {
        return leashes;
    }

    @Override
    public CompoundTag serializeNBT() {

        CompoundTag players = new CompoundTag();
        CompoundTag items = new CompoundTag();
        ListTag playersList = new ListTag();
        for (int i : leashedPlayers.keySet()) {
            Player player = leashedPlayers.get(i);
            ItemStack itemStack = leashes.get(i);
            if (player != null) {
                players.putUUID(String.valueOf(i), player.getUUID());
                playersList.add(StringTag.valueOf(String.valueOf(i)));
            }
            if (itemStack != null) {
                CompoundTag item = new CompoundTag();
                itemStack.save(item);
                items.put(String.valueOf(i), item);
            }
        }

        CompoundTag wrapper = new CompoundTag();
        wrapper.put("leashedPlayers", players);
        wrapper.put("leashedPlayersList", playersList);
        wrapper.put("leashes", items);

        return wrapper;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        clearLeashedPlayers();
        clearLeashes();

        if (nbt.contains("leashedPlayers") && nbt.contains("leashedPlayersList") && nbt.contains("leashes")) {
            CompoundTag players = nbt.getCompound("leashedPlayers");
            CompoundTag items = nbt.getCompound("leashes");
            ListTag playersList = nbt.getList("leashedPlayersList", Tag.TAG_STRING);
            for (int i = 0; i < playersList.size(); i++) {
                int index = Integer.parseInt(playersList.getString(i));
                UUID uuid = players.getUUID(playersList.getString(i));
                Level level = Purrfect.proxy.getLevel();
                if (level != null) setLeashedPlayer(index, level.getPlayerByUUID(uuid));
                ItemStack item = ItemStack.of(items.getCompound(playersList.getString(i)));
                setLeash(index, item);
            }
        }
    }
}
