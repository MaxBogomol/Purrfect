package mod.maxbogomol.purrfect.registry.common.block;

import mod.maxbogomol.purrfect.Purrfect;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PurrfectBlockTags {
    public static final TagKey<Block> FLAGPOLE_CONNECTION = TagKey.create(Registries.BLOCK, new ResourceLocation(Purrfect.MOD_ID, "flagpole_connection"));
}
