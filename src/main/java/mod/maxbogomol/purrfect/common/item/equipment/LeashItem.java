package mod.maxbogomol.purrfect.common.item.equipment;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.furry.FurryPlayerHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LeashItem extends Item {

    public static LeashColor LEASH = LeashColor.create(Purrfect.MOD_ID, "leash");
    public static LeashColor WHITE = LeashColor.create(Purrfect.MOD_ID, "white");
    public static LeashColor LIGHT_GRAY = LeashColor.create(Purrfect.MOD_ID, "light_gray");
    public static LeashColor GRAY = LeashColor.create(Purrfect.MOD_ID, "gray");
    public static LeashColor BLACK = LeashColor.create(Purrfect.MOD_ID, "black");
    public static LeashColor BROWN = LeashColor.create(Purrfect.MOD_ID, "brown");
    public static LeashColor RED = LeashColor.create(Purrfect.MOD_ID, "red");
    public static LeashColor ORANGE = LeashColor.create(Purrfect.MOD_ID, "orange");
    public static LeashColor YELLOW = LeashColor.create(Purrfect.MOD_ID, "yellow");
    public static LeashColor LIME = LeashColor.create(Purrfect.MOD_ID, "lime");
    public static LeashColor GREEN = LeashColor.create(Purrfect.MOD_ID, "green");
    public static LeashColor CYAN = LeashColor.create(Purrfect.MOD_ID, "cyan");
    public static LeashColor LIGHT_BLUE = LeashColor.create(Purrfect.MOD_ID, "light_blue");
    public static LeashColor BLUE = LeashColor.create(Purrfect.MOD_ID, "blue");
    public static LeashColor PURPLE = LeashColor.create(Purrfect.MOD_ID, "purple");
    public static LeashColor MAGENTA = LeashColor.create(Purrfect.MOD_ID, "magenta");
    public static LeashColor PINK = LeashColor.create(Purrfect.MOD_ID, "pink");
    public static LeashColor RAINBOW = LeashColor.create(Purrfect.MOD_ID, "rainbow");
    public static LeashColor CHAIN = LeashColor.create(Purrfect.MOD_ID, "chain", 0.0625f * 3f, 1f, 0.15f);

    public LeashColor color;

    public LeashItem(LeashColor color, Properties properties) {
        super(properties);
        this.color = color;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (player.isShiftKeyDown()) {
            int slot = hand == InteractionHand.OFF_HAND ? player.getInventory().getContainerSize() - 1 : player.getInventory().selected;
            Player t = FurryPlayerHandler.getLeashedPlayer(player, slot);
            if (t != null) {
                if (!player.level().isClientSide()) {
                    FurryPlayerHandler.setLeashedPlayer(player, slot, null);
                    FurryPlayerHandler.setLeash(player, slot, null);
                    level.playSound(null, t.position().x(), t.position().y(), t.position().z(), SoundEvents.LEASH_KNOT_BREAK, SoundSource.PLAYERS, 1f, 1f);
                }
                return InteractionResultHolder.success(stack);
            }
        }

        return InteractionResultHolder.pass(stack);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        int slot = usedHand == InteractionHand.OFF_HAND ? player.getInventory().getContainerSize() - 1 : player.getInventory().selected;
        Player t = FurryPlayerHandler.getLeashedPlayer(player, slot);
        if (interactionTarget instanceof Player target) {
            if (t == null && FurryPlayerHandler.hasCollar(target)) {
                if (!player.level().isClientSide()) {
                    FurryPlayerHandler.setLeashedPlayer(player, slot, target);
                    FurryPlayerHandler.setLeash(player, slot, stack);
                    player.level().playSound(null, target.position().x(), target.position().y(), target.position().z(), SoundEvents.LEASH_KNOT_PLACE, SoundSource.PLAYERS, 1f, 1f);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getLeashTexture() {
        return color.getTexture();
    }

    @OnlyIn(Dist.CLIENT)
    public float getLeashTextureWidth() {
        return color.getTextureWidth();
    }

    @OnlyIn(Dist.CLIENT)
    public float getLeashTextureHeight() {
        return color.getTextureHeight();
    }

    @OnlyIn(Dist.CLIENT)
    public float getLeashWidth() {
        return color.getWidth();
    }

    public static class LeashColor {
        public ResourceLocation texture;
        public float textureWidth = 0.0625f;
        public float textureHeight = 0.75f;
        public float width = 0.05f;

        public LeashColor(ResourceLocation texture) {
            this.texture = texture;
        }

        public LeashColor(ResourceLocation texture, float textureWidth, float textureHeight, float width) {
            this.texture = texture;
            this.textureWidth = textureWidth;
            this.textureHeight = textureHeight;
            this.width = width;
        }

        @OnlyIn(Dist.CLIENT)
        public ResourceLocation getTexture() {
            return texture;
        }

        @OnlyIn(Dist.CLIENT)
        public float getTextureWidth() {
            return textureWidth;
        }

        @OnlyIn(Dist.CLIENT)
        public float getTextureHeight() {
            return textureHeight;
        }

        @OnlyIn(Dist.CLIENT)
        public float getWidth() {
            return width;
        }

        public static LeashColor create(String modId, String yarn) {
            return new LeashColor(new ResourceLocation(modId, "leash/" + yarn));
        }

        public static LeashColor create(String modId, String yarn, float textureWidth, float textureHeight, float width) {
            return new LeashColor(new ResourceLocation(modId, "leash/" + yarn), textureWidth, textureHeight, width);
        }
    }
}
