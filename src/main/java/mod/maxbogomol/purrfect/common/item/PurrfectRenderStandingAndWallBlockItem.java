package mod.maxbogomol.purrfect.common.item;

import mod.maxbogomol.purrfect.registry.client.PurrfectModels;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class PurrfectRenderStandingAndWallBlockItem extends StandingAndWallBlockItem {

    public PurrfectRenderStandingAndWallBlockItem(Block block, Block wallBlock, Properties properties, Direction attachmentDirection) {
        super(block, wallBlock, properties, attachmentDirection);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return PurrfectModels.itemRenderer;
            }
        });
    }
}