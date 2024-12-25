package mod.maxbogomol.purrfect.common.item;

import mod.maxbogomol.purrfect.registry.client.PurrfectModels;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class PurrfectRenderBlockItem extends BlockItem {

    public PurrfectRenderBlockItem(Block block, Properties properties) {
        super(block, properties);
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