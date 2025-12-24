package mod.maxbogomol.purrfect.common.collar;

import mod.maxbogomol.purrfect.api.furry.CollarPart;
import mod.maxbogomol.purrfect.client.model.curio.CollarModel;
import mod.maxbogomol.purrfect.registry.client.PurrfectModels;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AccessoryCollarPart extends CollarPart {
    @OnlyIn(Dist.CLIENT)
    public BakedModel model;

    public AccessoryCollarPart(String id) {
        super(id);
    }

    @OnlyIn(Dist.CLIENT)
    public void setModel(BakedModel model) {
        this.model = model;
    }

    @OnlyIn(Dist.CLIENT)
    public BakedModel getModel() {
        return model;
    }

    @OnlyIn(Dist.CLIENT)
    public CollarModel getCollarModel() {
        return PurrfectModels.COLLAR;
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        String id = getId();
        int i = id.indexOf(":");
        String modId = id.substring(0, i);
        String partId = id.substring(i + 1);
        return new ResourceLocation(modId, "textures/entity/curio/collar/accessory/" + partId + ".png");
    }

    public String getTranslatedName() {
        return getTranslatedName(id);
    }

    public static String getTranslatedName(String id) {
        int i = id.indexOf(":");
        String modId = id.substring(0, i);
        String partId = id.substring(i + 1);
        return "collar_part.accessory." + modId + "." + partId;
    }

    public boolean isBell() {
        return false;
    }

    public boolean isLock() {
        return false;
    }

    public boolean isBellSound() {
        return false;
    }
}
