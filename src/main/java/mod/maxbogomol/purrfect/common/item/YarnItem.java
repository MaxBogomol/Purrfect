package mod.maxbogomol.purrfect.common.item;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.entity.YarnEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class YarnItem extends Item {

    public static YarnColor WHITE = YarnColor.create(Purrfect.MOD_ID, "white");
    public static YarnColor LIGHT_GRAY = YarnColor.create(Purrfect.MOD_ID, "light_gray");
    public static YarnColor GRAY = YarnColor.create(Purrfect.MOD_ID, "gray");
    public static YarnColor BLACK = YarnColor.create(Purrfect.MOD_ID, "black");
    public static YarnColor BROWN = YarnColor.create(Purrfect.MOD_ID, "brown");
    public static YarnColor RED = YarnColor.create(Purrfect.MOD_ID, "red");
    public static YarnColor ORANGE = YarnColor.create(Purrfect.MOD_ID, "orange");
    public static YarnColor YELLOW = YarnColor.create(Purrfect.MOD_ID, "yellow");
    public static YarnColor LIME = YarnColor.create(Purrfect.MOD_ID, "lime");
    public static YarnColor GREEN = YarnColor.create(Purrfect.MOD_ID, "green");
    public static YarnColor CYAN = YarnColor.create(Purrfect.MOD_ID, "cyan");
    public static YarnColor LIGHT_BLUE = YarnColor.create(Purrfect.MOD_ID, "light_blue");
    public static YarnColor BLUE = YarnColor.create(Purrfect.MOD_ID, "blue");
    public static YarnColor PURPLE = YarnColor.create(Purrfect.MOD_ID, "purple");
    public static YarnColor MAGENTA = YarnColor.create(Purrfect.MOD_ID, "magenta");
    public static YarnColor PINK = YarnColor.create(Purrfect.MOD_ID, "pink");
    public static YarnColor RAINBOW = YarnColor.create(Purrfect.MOD_ID, "rainbow");

    public YarnColor color;

    public YarnItem(YarnColor color, Properties properties) {
        super(properties);
        this.color = color;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        YarnEntity entity = new YarnEntity(level, player);
        entity.setItem(stack);

        entity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 0.5f, 2f);
        level.addFreshEntity(entity);

        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }

        return InteractionResultHolder.success(stack);
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getYarnTexture() {
        return color.getTexture();
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getYarnTrailTexture() {
        return color.getTrailTexture();
    }

    public static class YarnColor {
        public ResourceLocation texture;
        public ResourceLocation textureTrail;

        public YarnColor(ResourceLocation texture, ResourceLocation textureTrail) {
            this.texture = texture;
            this.textureTrail = textureTrail;
        }

        @OnlyIn(Dist.CLIENT)
        public ResourceLocation getTexture() {
            return texture;
        }

        @OnlyIn(Dist.CLIENT)
        public ResourceLocation getTrailTexture() {
            return textureTrail;
        }

        public static YarnColor create(String modId, String yarn) {
            return new YarnColor(new ResourceLocation(modId, "textures/yarn/" + yarn + ".png"), new ResourceLocation(modId, "yarn/" + yarn + "_trail"));
        }
    }
}
