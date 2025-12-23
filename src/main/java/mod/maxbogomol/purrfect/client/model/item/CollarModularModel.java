package mod.maxbogomol.purrfect.client.model.item;

import mod.maxbogomol.fluffy_fur.client.model.item.CustomItemOverrides;
import mod.maxbogomol.fluffy_fur.client.model.item.CustomModel;
import mod.maxbogomol.purrfect.api.furry.CollarPart;
import mod.maxbogomol.purrfect.common.collar.AccessoryCollarPart;
import mod.maxbogomol.purrfect.common.collar.ColorCollarPart;
import mod.maxbogomol.purrfect.common.collar.DecorationCollarPart;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CollarModularModel extends CustomModel {

    public CollarModularModel(BakedModel baseModel, CustomItemOverrides itemOverrides) {
        super(baseModel, itemOverrides);
    }

    @Override
    public List<BakedModel> getRenderPasses(ItemStack itemStack, boolean fabulous) {
        List<BakedModel> list = new ArrayList<>();
        CollarPart colorPart = CollarItem.getColor(itemStack);
        CollarPart accessoryPart = CollarItem.getAccessory(itemStack);
        CollarPart decorationPart = CollarItem.getDecoration(itemStack);

        if (colorPart instanceof ColorCollarPart colorCollarPart) {
            BakedModel colorModel = colorCollarPart.getModel();
            if (accessoryPart instanceof AccessoryCollarPart accessoryCollarPart) {
                if (accessoryCollarPart.isBell()) {
                    colorModel = colorCollarPart.getBellModel();
                }
            }
            list.add(colorModel);
        }
        if (decorationPart instanceof DecorationCollarPart decorationCollarPart) {
            list.add(decorationCollarPart.getModel());
        }
        if (accessoryPart instanceof AccessoryCollarPart accessoryCollarPart) {
            list.add(accessoryCollarPart.getModel());
        }

        if (!list.isEmpty()) return list;
        return super.getRenderPasses(itemStack, fabulous);
    }
}
