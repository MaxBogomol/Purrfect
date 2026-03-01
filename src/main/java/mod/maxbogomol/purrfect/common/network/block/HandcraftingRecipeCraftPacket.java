package mod.maxbogomol.purrfect.common.network.block;

import mod.maxbogomol.fluffy_fur.common.network.ServerPacket;
import mod.maxbogomol.purrfect.common.hadcrafting.MainHandcraftingTab;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;
import java.util.function.Supplier;

public class HandcraftingRecipeCraftPacket extends ServerPacket {
    protected final String id;
    protected final int multiplier;

    public HandcraftingRecipeCraftPacket(String id, int multiplier) {
        this.id = id;
        this.multiplier = multiplier;
    }

    public HandcraftingRecipeCraftPacket(String id) {
        this.id = id;
        this.multiplier = 1;
    }

    public HandcraftingRecipeCraftPacket(HandcraftingRecipe recipe, int multiplier) {
        this.id = recipe.getId().toString();
        this.multiplier = multiplier;
    }

    public HandcraftingRecipeCraftPacket(HandcraftingRecipe recipe) {
        this.id = recipe.getId().toString();
        this.multiplier = 1;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void execute(Supplier<NetworkEvent.Context> context) {
        ServerPlayer player = context.get().getSender();
        ServerLevel level = player.serverLevel();

        Optional<? extends Recipe<?>> recipe = level.getRecipeManager().byKey(new ResourceLocation(id));
        if (recipe.isPresent() && recipe.get() instanceof HandcraftingRecipe handcraftingRecipe) {
            if (MainHandcraftingTab.canCraftRecipe(player)) {
                MainHandcraftingTab.craftRecipe(player, level, handcraftingRecipe, multiplier);
            }
        }
    }

    public static void register(SimpleChannel instance, int index) {
        instance.registerMessage(index, HandcraftingRecipeCraftPacket.class, HandcraftingRecipeCraftPacket::encode, HandcraftingRecipeCraftPacket::decode, HandcraftingRecipeCraftPacket::handle);
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeUtf(id);
        buf.writeInt(multiplier);
    }

    public static HandcraftingRecipeCraftPacket decode(FriendlyByteBuf buf) {
        return new HandcraftingRecipeCraftPacket(buf.readUtf(), buf.readInt());
    }
}
