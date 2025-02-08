package mod.maxbogomol.purrfect.common.capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

import java.util.Map;

public interface IFurryPlayer {
    Capability<IFurryPlayer> INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});

    void setLeashedPlayer(int i, Player player);
    Player getLeashedPlayer(int i);

    void clearLeashedPlayers();
    Map<Integer, Player> getLeashedPlayers();

    void setLeash(int i, ItemStack itemStack);
    ItemStack getLeash(int i);

    void clearLeashes();
    Map<Integer, ItemStack> getLeashes();
}
