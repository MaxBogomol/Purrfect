package mod.maxbogomol.purrfect.common.item.equipment;

import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.List;
import java.util.UUID;

public class ShipkeyItem extends Item {

    public ShipkeyItem(Properties properties) {
        super(properties);
    }

    public static void generateUUID(ItemStack lock, ItemStack key) {
        CompoundTag nbtLock = lock.getOrCreateTag();
        CompoundTag nbtKey = key.getOrCreateTag();
        UUID uuid = UUID.randomUUID();
        nbtLock.putUUID("lockUUID", uuid);
        nbtKey.putUUID("lockUUID", uuid);
    }

    public static UUID getUUID(ItemStack item) {
        CompoundTag nbt = item.getOrCreateTag();
        if (nbt.contains("lockUUID")) {
            return nbt.getUUID("lockUUID");
        }
        return null;
    }

    public static boolean hasUUID(ItemStack item) {
        CompoundTag nbt = item.getOrCreateTag();
        return nbt.contains("lockUUID");
    }

    public static boolean hasKey(Player player, UUID uuid) {
        List<ItemStack> items = player.inventoryMenu.getItems();
        for (ItemStack stack : items) {
            if (ShipkeyItem.hasUUID(stack)) {
                UUID keyUUID = ShipkeyItem.getUUID(stack);
                if (keyUUID != null) return keyUUID.equals(uuid);
            }
        }
        return false;
    }

    public static boolean inventoryInteraction(ItemStack carried, ItemStack stacked, Slot slot, ClickAction action, Player player) {
        if (slot.allowModification(player)) {
            if (!ShipkeyItem.hasUUID(stacked) && !ShipkeyItem.hasUUID(carried)) {
                ShipkeyItem.generateUUID(stacked, carried);
                player.level().playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.CHEST_LOCKED, SoundSource.PLAYERS, 0.75f, 1.5f);
                return true;
            }
        }
        return false;
    }

    public static boolean playerInteraction(Player player, Player target, ItemStack key, InteractionHand hand) {
        LazyOptional<ICuriosItemHandler> curiosItemHandler = CuriosApi.getCuriosInventory(target);
        if (curiosItemHandler.isPresent() && curiosItemHandler.resolve().isPresent()) {
            List<SlotResult> curioSlots = curiosItemHandler.resolve().get().findCurios((i) -> true);
            for (SlotResult slot : curioSlots) {
                if (slot.stack().getItem() instanceof CollarItem) {
                    if (ShipkeyItem.hasUUID(slot.stack()) && ShipkeyItem.hasUUID(key)) {
                        UUID uuid = ShipkeyItem.getUUID(slot.stack());
                        UUID keyUUID = ShipkeyItem.getUUID(key);
                        if (uuid != null && keyUUID != null) {
                            if (keyUUID.equals(uuid)) {
                                CollarItem.dropItem(target, slot.stack());
                                target.level().playSound(null, target.getX(), target.getY() + (target.getBbHeight() / 2f), target.getZ(), SoundEvents.ARMOR_EQUIP_LEATHER, SoundSource.PLAYERS, 1.0f, 1.5f);
                                return true;
                            }
                        }
                    }
                    if (!ShipkeyItem.hasUUID(slot.stack()) && !ShipkeyItem.hasUUID(key)) {
                        ShipkeyItem.generateUUID(slot.stack(), key);
                        player.level().playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.CHEST_LOCKED, SoundSource.PLAYERS, 0.75f, 1.5f);
                        player.setItemInHand(hand, key);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (target instanceof Player targetPlayer && stack.getItem() instanceof ShipkeyItem) {
            if (ShipkeyItem.playerInteraction(player, targetPlayer, stack, hand)) {
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Level level, List<Component> list, TooltipFlag flags) {
        if (ShipkeyItem.hasUUID(stack)) {
            list.add(Component.translatable("lore.purrfect.collar.locked").withStyle(ChatFormatting.GOLD));
            if (flags.isAdvanced()) {
                UUID uuid = ShipkeyItem.getUUID(stack);
                if (uuid != null) {
                    list.add(Component.literal("UUID").withStyle(ChatFormatting.GOLD).append(CommonComponents.SPACE).append(Component.literal(uuid.toString()).withStyle(ChatFormatting.YELLOW)));
                }
            }
        }
    }
}
