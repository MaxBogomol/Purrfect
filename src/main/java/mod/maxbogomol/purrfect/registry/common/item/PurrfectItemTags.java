package mod.maxbogomol.purrfect.registry.common.item;

import mod.maxbogomol.purrfect.Purrfect;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class PurrfectItemTags {
    public static final TagKey<Item> GLOW_FLAG_INGREDIENT = TagKey.create(Registries.ITEM, new ResourceLocation(Purrfect.MOD_ID, "glow_flag_ingredient"));
    public static final TagKey<Item> BELL_COLLARS = TagKey.create(Registries.ITEM, new ResourceLocation(Purrfect.MOD_ID, "bell_collars"));
    public static final TagKey<Item> LEASH_COLLARS = TagKey.create(Registries.ITEM, new ResourceLocation(Purrfect.MOD_ID, "leash_collars"));
}
