package mod.maxbogomol.purrfect.common.collar;

import mod.maxbogomol.purrfect.api.furry.CollarPart;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ColorCollarPart extends CollarPart {
    @OnlyIn(Dist.CLIENT)
    public BakedModel model;
    @OnlyIn(Dist.CLIENT)
    public BakedModel bellModel;
    @OnlyIn(Dist.CLIENT)
    public BakedModel lockModel;

    public ColorCollarPart(String id) {
        super(id);
    }

    @OnlyIn(Dist.CLIENT)
    public void setModel(BakedModel model) {
        this.model = model;
    }

    @OnlyIn(Dist.CLIENT)
    public void setBellModel(BakedModel model) {
        this.bellModel = model;
    }

    @OnlyIn(Dist.CLIENT)
    public void setLockModel(BakedModel model) {
        this.lockModel = model;
    }

    @OnlyIn(Dist.CLIENT)
    public BakedModel getModel() {
        return model;
    }

    @OnlyIn(Dist.CLIENT)
    public BakedModel getBellModel() {
        return bellModel;
    }

    @OnlyIn(Dist.CLIENT)
    public BakedModel getLockModel() {
        return lockModel;
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        String id = getId();
        int i = id.indexOf(":");
        String modId = id.substring(0, i);
        String partId = id.substring(i + 1);
        return new ResourceLocation(modId, "textures/entity/curio/collar/color/" + partId + ".png");
    }

    public String getTranslatedName() {
        return getTranslatedName(id);
    }

    public static String getTranslatedName(String id) {
        int i = id.indexOf(":");
        String modId = id.substring(0, i);
        String alchemyPotionId = id.substring(i + 1);
        return "collar_part.color." + modId + "." + alchemyPotionId;
    }
}
