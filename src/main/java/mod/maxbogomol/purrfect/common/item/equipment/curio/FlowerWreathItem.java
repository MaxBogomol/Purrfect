package mod.maxbogomol.purrfect.common.item.equipment.curio;

import mod.maxbogomol.fluffy_fur.integration.common.curios.BaseCurioItem;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.common.network.item.PinkPetalsFlowerWreathPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import javax.annotation.Nonnull;
import java.util.List;

public class FlowerWreathItem extends BaseCurioItem {

    public static FlowerWreathColor DANDELION = new FlowerWreathColor("dandelion");
    public static FlowerWreathColor POPPY = new FlowerWreathColor("poppy");
    public static FlowerWreathColor BLUE_ORCHID = new FlowerWreathColor("blue_orchid");
    public static FlowerWreathColor ALLIUM = new FlowerWreathColor("allium");
    public static FlowerWreathColor AZURE_BLUET = new FlowerWreathColor("azure_bluet");
    public static FlowerWreathColor RED_TULIP = new FlowerWreathColor("red_tulip");
    public static FlowerWreathColor ORANGE_TULIP = new FlowerWreathColor("orange_tulip");
    public static FlowerWreathColor WHITE_TULIP = new FlowerWreathColor("white_tulip");
    public static FlowerWreathColor PINK_TULIP = new FlowerWreathColor("pink_tulip");
    public static FlowerWreathColor OXEYE_DAISY = new FlowerWreathColor("oxeye_daisy");
    public static FlowerWreathColor CORNFLOWER = new FlowerWreathColor("cornflower");
    public static FlowerWreathColor LILY_OF_THE_VALLEY = new FlowerWreathColor("lily_of_the_valley");
    public static FlowerWreathColor PINK_PETALS = new PinkPetalsColor("pink_petals");
    public static FlowerWreathColor SUNFLOWER = new FlowerWreathColor("sunflower");
    public static FlowerWreathColor LILAC = new FlowerWreathColor("lilac");
    public static FlowerWreathColor ROSE_BUSH = new FlowerWreathColor("rose_bush");
    public static FlowerWreathColor PEONY = new FlowerWreathColor("peony");
    public static FlowerWreathColor DEAD_BUSH = new FlowerWreathColor("dead_bush");
    public static FlowerWreathColor WITHER_ROSE = new WitherRoseColor("wither_rose");
    public static FlowerWreathColor TORCHFLOWER = new FlowerWreathColor("torchflower");
    public static FlowerWreathColor PITCHER_PLANT = new FlowerWreathColor("pitcher_plant");
    public static FlowerWreathColor CUTIE = new FlowerWreathColor("cutie");

    public FlowerWreathColor color = DANDELION;

    public FlowerWreathItem(Properties properties) {
        super(properties);
    }

    public FlowerWreathItem setColor(FlowerWreathColor color) {
        this.color = color;
        return this;
    }

    @Nonnull
    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo(SoundEvents.CHERRY_LEAVES_PLACE, 1.0f, 1.0f);
    }

    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        LazyOptional<ICuriosItemHandler> curiosItemHandler = CuriosApi.getCuriosInventory(entity);
        if (curiosItemHandler.isPresent() && curiosItemHandler.resolve().isPresent()) {
            List<SlotResult> curioSlots = curiosItemHandler.resolve().get().findCurios((i) -> i.getItem() instanceof FlowerWreathItem);
            for (SlotResult slotResult : curioSlots) {
                if (slotResult.stack().getItem() instanceof FlowerWreathItem flowerWreathItem) {
                    flowerWreathItem.onDamage(event);
                }
            }
        }
    }

    public void onDamage(LivingDamageEvent event) {
        color.onLivingDamage(event);
    }

    public ResourceLocation getTexture(ItemStack stack, LivingEntity entity) {
        return color.getTexture();
    }

    public static class FlowerWreathColor {
        public String modId;
        public String texture;

        public FlowerWreathColor(String modId, String texture) {
            this.modId = modId;
            this.texture = texture;
        }

        public FlowerWreathColor(String texture) {
            this.modId = Purrfect.MOD_ID;
            this.texture = texture;
        }

        @OnlyIn(Dist.CLIENT)
        public ResourceLocation getTexture() {
            return new ResourceLocation(modId, "textures/entity/curio/flower_wreath/" + texture + ".png");
        }

        public void onLivingDamage(LivingDamageEvent event) {

        }
    }

    public static class PinkPetalsColor extends FlowerWreathColor {

        public PinkPetalsColor(String modId, String texture) {
            super(modId, texture);
        }

        public PinkPetalsColor(String texture) {
            super(texture);
        }

        public void onLivingDamage(LivingDamageEvent event) {
            LivingEntity entity = event.getEntity();
            if (!entity.level().isClientSide()) {
                PurrfectPacketHandler.sendToTracking(entity.level(), entity.blockPosition(), new PinkPetalsFlowerWreathPacket(entity.getEyePosition()));
            }
        }
    }

    public static class WitherRoseColor extends FlowerWreathColor {

        public WitherRoseColor(String modId, String texture) {
            super(modId, texture);
        }

        public WitherRoseColor(String texture) {
            super(texture);
        }

        public void onLivingDamage(LivingDamageEvent event) {
            LivingEntity entity = event.getEntity();
            if (!entity.level().isClientSide()) {
                if (event.getSource().getEntity() instanceof LivingEntity livingEntity) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60));
                }
            }
        }
    }
}
