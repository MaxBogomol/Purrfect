package mod.maxbogomol.purrfect.common.item.equipment.curio;

import mod.maxbogomol.fluffy_fur.integration.common.curios.BaseCurioItem;
import mod.maxbogomol.purrfect.api.furry.CollarPart;
import mod.maxbogomol.purrfect.api.furry.CollarPartHandler;
import mod.maxbogomol.purrfect.common.collar.AccessoryCollarPart;
import mod.maxbogomol.purrfect.common.collar.ColorCollarPart;
import mod.maxbogomol.purrfect.common.collar.DecorationCollarPart;
import mod.maxbogomol.purrfect.registry.common.PurrfectCollarParts;
import mod.maxbogomol.purrfect.registry.common.PurrfectSounds;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class CollarItem extends BaseCurioItem {

    public CollarItem(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo(SoundEvents.ARMOR_EQUIP_LEATHER, 1.0f, 1.0f);
    }

    public static void existTags(ItemStack stack) {
        CompoundTag nbt = stack.getOrCreateTag();
        if (!nbt.contains("parts")) {
            nbt.put("parts", new CompoundTag());
        }
    }

    public static void setColor(ItemStack stack, CollarPart part) {
        existTags(stack);
        CompoundTag nbt = stack.getOrCreateTag();
        CompoundTag parts = nbt.getCompound("parts");
        parts.putString("color", part.getId());
    }

    public static void setAccessory(ItemStack stack, CollarPart part) {
        existTags(stack);
        CompoundTag nbt = stack.getOrCreateTag();
        CompoundTag parts = nbt.getCompound("parts");
        parts.putString("accessory", part.getId());
    }

    public static void setDecoration(ItemStack stack, CollarPart part) {
        existTags(stack);
        CompoundTag nbt = stack.getOrCreateTag();
        CompoundTag parts = nbt.getCompound("parts");
        parts.putString("decoration", part.getId());
    }

    public static CollarPart getColor(ItemStack stack) {
        existTags(stack);
        CompoundTag nbt = stack.getOrCreateTag();
        CompoundTag parts = nbt.getCompound("parts");
        String id = parts.getString("color");
        CollarPart part = CollarPartHandler.COLOR.getCollarPart(id);
        if (part != null) return part;
        return PurrfectCollarParts.COLLAR;
    }

    public static CollarPart getAccessory(ItemStack stack) {
        existTags(stack);
        CompoundTag nbt = stack.getOrCreateTag();
        CompoundTag parts = nbt.getCompound("parts");
        String id = parts.getString("accessory");
        return CollarPartHandler.ACCESSORY.getCollarPart(id);
    }

    public static CollarPart getDecoration(ItemStack stack) {
        existTags(stack);
        CompoundTag nbt = stack.getOrCreateTag();
        CompoundTag parts = nbt.getCompound("parts");
        String id = parts.getString("decoration");
        return CollarPartHandler.DECORATION.getCollarPart(id);
    }

    public static boolean isBellSound(ItemStack stack) {
        CollarPart accessoryPart = CollarItem.getAccessory(stack);
        if (accessoryPart instanceof AccessoryCollarPart accessoryCollarPart) {
            return accessoryCollarPart.isBellSound();
        }
        return false;
    }

    public static List<ItemStack> getAllItems(Item item) {
        List<ItemStack> list = new ArrayList<>();

        for (CollarPart colorPart : CollarPartHandler.COLOR.getCollarParts()) {
            ItemStack stack = new ItemStack(item);
            setColor(stack, colorPart);
            list.add(stack);
            for (CollarPart accessoryPart : CollarPartHandler.ACCESSORY.getCollarParts()) {
                stack = new ItemStack(item);
                setColor(stack, colorPart);
                setAccessory(stack, accessoryPart);
                list.add(stack);
                for (CollarPart decorationPart : CollarPartHandler.DECORATION.getCollarParts()) {
                    stack = new ItemStack(item);
                    setColor(stack, colorPart);
                    setAccessory(stack, accessoryPart);
                    setDecoration(stack, decorationPart);
                    list.add(stack);
                }
            }
        }

        return list;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Level level, List<Component> list, TooltipFlag flags) {
        String color = "collar_part.purrfect.none";
        String accessory = "collar_part.purrfect.none";
        String decoration = "collar_part.purrfect.none";

        CollarPart colorPart = CollarItem.getColor(stack);
        CollarPart accessoryPart = CollarItem.getAccessory(stack);
        CollarPart decorationPart = CollarItem.getDecoration(stack);

        if (colorPart instanceof ColorCollarPart colorCollarPart) {
            color = colorCollarPart.getTranslatedName();
        }
        if (accessoryPart instanceof AccessoryCollarPart accessoryCollarPart) {
            accessory = accessoryCollarPart.getTranslatedName();
        }
        if (decorationPart instanceof DecorationCollarPart decorationCollarPart) {
            decoration = decorationCollarPart.getTranslatedName();
        }

        list.add(Component.translatable("collar_part.color.purrfect").withStyle(ChatFormatting.GOLD).append(CommonComponents.SPACE).append(Component.translatable(color).withStyle(ChatFormatting.YELLOW)));
        list.add(Component.translatable("collar_part.accessory.purrfect").withStyle(ChatFormatting.GOLD).append(CommonComponents.SPACE).append(Component.translatable(accessory).withStyle(ChatFormatting.YELLOW)));
        list.add(Component.translatable("collar_part.decoration.purrfect").withStyle(ChatFormatting.GOLD).append(CommonComponents.SPACE).append(Component.translatable(decoration).withStyle(ChatFormatting.YELLOW)));
    }

    public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
        bellSound(event.getEntity());
    }

    public static void onLivingDamage(LivingDamageEvent event) {
        bellSound(event.getEntity());
    }

    public static void bellSound(LivingEntity entity) {
        if (!entity.level().isClientSide()) {
            LazyOptional<ICuriosItemHandler> curiosItemHandler = CuriosApi.getCuriosInventory(entity);
            if (curiosItemHandler.isPresent() && curiosItemHandler.resolve().isPresent()) {
                List<SlotResult> curioSlots = curiosItemHandler.resolve().get().findCurios((i) -> i.is(PurrfectItemTags.BELL_COLLARS) || isBellSound(i));
                for (SlotResult slot : curioSlots) {
                    SoundEvent soundEvent = PurrfectSounds.COLLAR_BELL.get();
                    entity.level().playSound(null, entity.getX(), entity.getY() + (entity.getBbHeight() / 2f), entity.getZ(), soundEvent, SoundSource.PLAYERS, 0.5f, 1.0f);
                }
            }
        }
    }
}
