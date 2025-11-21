package mod.maxbogomol.purrfect.common.item.equipment.curio;

import mod.maxbogomol.fluffy_fur.integration.common.curios.BaseCurioItem;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.registry.common.PurrfectSounds;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
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
import java.util.List;

public class CollarItem extends BaseCurioItem {

    public static CollarColor COLLAR = new CollarColor("collar");
    public static CollarColor WHITE = new CollarColor("white_collar");
    public static CollarColor LIGHT_GRAY = new CollarColor("light_gray_collar");
    public static CollarColor GRAY = new CollarColor("gray_collar");
    public static CollarColor BLACK = new CollarColor("black_collar");
    public static CollarColor BROWN = new CollarColor("brown_collar");
    public static CollarColor RED = new CollarColor("red_collar");
    public static CollarColor ORANGE = new CollarColor("orange_collar");
    public static CollarColor YELLOW = new CollarColor("yellow_collar");
    public static CollarColor LIME = new CollarColor("lime_collar");
    public static CollarColor GREEN = new CollarColor("green_collar");
    public static CollarColor CYAN = new CollarColor("cyan_collar");
    public static CollarColor LIGHT_BLUE = new CollarColor("light_blue_collar");
    public static CollarColor BLUE = new CollarColor("blue_collar");
    public static CollarColor PURPLE = new CollarColor("purple_collar");
    public static CollarColor MAGENTA = new CollarColor("magenta_collar");
    public static CollarColor PINK = new CollarColor("pink_collar");
    public static CollarColor RAINBOW = new CollarColor("rainbow_collar");

    public static CollarColor IRON_BELL = new CollarColor("iron_bell");
    public static CollarColor GOLDEN_BELL = new CollarColor("golden_bell");

    public static CollarColor SPIKES = new CollarColor("spikes");

    public CollarColor color = COLLAR;
    public CollarColor bell;
    public CollarColor spikes;

    public CollarItem(Properties properties) {
        super(properties);
    }

    public CollarItem setColor(CollarColor color) {
        this.color = color;
        return this;
    }

    public CollarItem setBell(CollarColor bell) {
        this.bell = bell;
        return this;
    }

    public CollarItem setSpikes(CollarColor spikes) {
        this.spikes = spikes;
        return this;
    }

    @Nonnull
    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo(SoundEvents.ARMOR_EQUIP_LEATHER, 1.0f, 1.0f);
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
                List<SlotResult> curioSlots = curiosItemHandler.resolve().get().findCurios((i) -> i.is(PurrfectItemTags.BELL_COLLARS));
                for (SlotResult slot : curioSlots) {
                    SoundEvent soundEvent = PurrfectSounds.COLLAR_BELL.get();
                    entity.level().playSound(null, entity.getX(), entity.getY() + (entity.getBbHeight() / 2f), entity.getZ(), soundEvent, SoundSource.PLAYERS, 0.5f, 1.0f);
                }
            }
        }
    }

    public ResourceLocation getCollarBaseTexture(ItemStack stack, LivingEntity entity) {
        return color.getTexture();
    }

    public ResourceLocation getCollarBellTexture(ItemStack stack, LivingEntity entity) {
        if (bell != null) return bell.getTexture();
        return null;
    }

    public ResourceLocation getCollarSpikesTexture(ItemStack stack, LivingEntity entity) {
        if (spikes != null) return spikes.getTexture();
        return null;
    }

    public static class CollarColor {
        public String modId;
        public String texture;

        public CollarColor(String modId, String texture) {
            this.modId = modId;
            this.texture = texture;
        }

        public CollarColor(String texture) {
            this.modId = Purrfect.MOD_ID;
            this.texture = texture;
        }

        @OnlyIn(Dist.CLIENT)
        public ResourceLocation getTexture() {
            return new ResourceLocation(modId, "textures/entity/curio/collar/" + texture + ".png");
        }
    }
}
