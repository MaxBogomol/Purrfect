package mod.maxbogomol.purrfect.client.model.block;

import mod.maxbogomol.fluffy_fur.client.model.block.CustomBlockModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class YarnModel extends CustomBlockModel {

    public YarnModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition model = root.addOrReplaceChild("model", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5, new CubeDeformation(0F)), PartPose.ZERO);
        PartDefinition model1 = model.addOrReplaceChild("model1", CubeListBuilder.create().texOffs(0, 10).addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5, new CubeDeformation(0.15F)), PartPose.ZERO);

        return LayerDefinition.create(mesh, 32, 32);
    }
}
