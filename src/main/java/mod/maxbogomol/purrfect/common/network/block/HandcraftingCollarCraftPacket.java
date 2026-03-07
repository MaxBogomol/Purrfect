package mod.maxbogomol.purrfect.common.network.block;

import mod.maxbogomol.fluffy_fur.common.network.ServerPacket;
import mod.maxbogomol.purrfect.common.hadcrafting.CollarsHandcraftingTab;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingCollarsRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;
import java.util.function.Supplier;

public class HandcraftingCollarCraftPacket extends ServerPacket {
    protected final String id;

    public HandcraftingCollarCraftPacket(String id) {
        this.id = id;
    }

    public HandcraftingCollarCraftPacket(HandcraftingCollarsRecipe recipe) {
        this.id = recipe.getId().toString();
    }

    @Override
    public void execute(Supplier<NetworkEvent.Context> context) {
        ServerPlayer player = context.get().getSender();
        ServerLevel level = player.serverLevel();

        Optional<? extends Recipe<?>> recipe = level.getRecipeManager().byKey(new ResourceLocation(id));
        if (recipe.isPresent() && recipe.get() instanceof HandcraftingCollarsRecipe handcraftingCollarsRecipe) {
            if (CollarsHandcraftingTab.canCraftRecipe(player)) {
                CollarsHandcraftingTab.setRecipe(player, level, handcraftingCollarsRecipe);
            }
        }
    }

    public static void register(SimpleChannel instance, int index) {
        instance.registerMessage(index, HandcraftingCollarCraftPacket.class, HandcraftingCollarCraftPacket::encode, HandcraftingCollarCraftPacket::decode, HandcraftingCollarCraftPacket::handle);
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeUtf(id);
    }

    public static HandcraftingCollarCraftPacket decode(FriendlyByteBuf buf) {
        return new HandcraftingCollarCraftPacket(buf.readUtf());
    }
}
