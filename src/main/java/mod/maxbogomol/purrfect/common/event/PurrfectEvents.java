package mod.maxbogomol.purrfect.common.event;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.capability.FurryPlayerProvider;
import mod.maxbogomol.purrfect.common.capability.IFurryPlayer;
import mod.maxbogomol.purrfect.common.furry.FurryPlayerHandler;
import mod.maxbogomol.purrfect.common.item.equipment.ShipkeyItem;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import mod.maxbogomol.purrfect.common.item.equipment.curio.FlowerWreathItem;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.common.network.furry.FurryPlayerUpdatePacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.ItemStackedOnOtherEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PurrfectEvents {

    @SubscribeEvent
    public void attachEntityCaps(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) event.addCapability(new ResourceLocation(Purrfect.MOD_ID, "furry"), new FurryPlayerProvider());
    }

    @SubscribeEvent
    public void onClone(PlayerEvent.Clone event) {
        Capability<IFurryPlayer> FURRY = IFurryPlayer.INSTANCE;
        event.getOriginal().reviveCaps();
        event.getEntity().getCapability(FURRY).ifPresent((k) -> event.getOriginal().getCapability(FURRY).ifPresent((o) ->
                ((INBTSerializable<CompoundTag>) k).deserializeNBT(((INBTSerializable<CompoundTag>) o).serializeNBT())));
        if (!event.getEntity().level().isClientSide) {
            PurrfectPacketHandler.sendTo((ServerPlayer) event.getEntity(), new FurryPlayerUpdatePacket(event.getEntity()));
        }
    }

    @SubscribeEvent
    public void onJoin(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Player player && !event.getLevel().isClientSide()) {
            PurrfectPacketHandler.sendTo((ServerPlayer) event.getEntity(), new FurryPlayerUpdatePacket(player));
        }
    }

    @SubscribeEvent
    public void onPlayerStartTracking(PlayerEvent.StartTracking event) {
        Player player = event.getEntity();
        if (event.getTarget() instanceof Player target) {
            PurrfectPacketHandler.sendTo(player, new FurryPlayerUpdatePacket(target));
            PurrfectPacketHandler.sendTo(target, new FurryPlayerUpdatePacket(player));
        }
    }

    @SubscribeEvent
    public void onEntityLeave(EntityLeaveLevelEvent event) {
        if (event.getEntity() instanceof Player player && !event.getLevel().isClientSide()) {
            FurryPlayerHandler.clearLeashedPlayersLeave(player);
            FurryPlayerHandler.clearLeashes(player);
        }
    }

    @SubscribeEvent
    public void onEntityJump(LivingEvent.LivingJumpEvent event) {
        CollarItem.onEntityJump(event);
    }

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent event) {
        CollarItem.onLivingDamage(event);
        FlowerWreathItem.onLivingDamage(event);
    }

    @SubscribeEvent
    public void levelTick(TickEvent.LevelTickEvent event) {
        FurryPlayerHandler.leashedTick(event);
    }

    @SubscribeEvent
    public void onItemStackedOnOther(ItemStackedOnOtherEvent event) {
        ItemStack carried = event.getStackedOnItem();
        ItemStack stacked = event .getCarriedItem();
        Slot slot = event.getSlot();
        ClickAction action = event.getClickAction();
        Player player = event.getPlayer();

        if (stacked.getItem() instanceof CollarItem && carried.getItem() instanceof ShipkeyItem) {
            event.setCanceled(ShipkeyItem.inventoryInteraction(carried, stacked, slot, action, player));
        }
    }
}
