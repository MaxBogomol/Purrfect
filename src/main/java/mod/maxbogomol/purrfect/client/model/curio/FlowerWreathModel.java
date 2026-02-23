package mod.maxbogomol.purrfect.client.model.curio;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class FlowerWreathModel extends HumanoidModel {
    public ModelPart root, model;

    public FlowerWreathModel(ModelPart root) {
        super(root);
        this.root = root;
        this.model = root.getChild("head").getChild("model");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = HumanoidModel.createMesh(new CubeDeformation(0), 1);
        PartDefinition root = mesh.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", new CubeListBuilder(), PartPose.ZERO);
        PartDefinition body = root.addOrReplaceChild("body", new CubeListBuilder(), PartPose.ZERO);

        PartDefinition model = head.addOrReplaceChild("model", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.55F)), PartPose.ZERO);
        PartDefinition model1 = head.addOrReplaceChild("model1", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.85F)), PartPose.ZERO);

        PartDefinition model2 = model.addOrReplaceChild("model2", CubeListBuilder.create().texOffs(-10, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(0.0f, -8.2f, -4.8f, (float) Math.toRadians(55f),0.0f, 0.0f));
        PartDefinition model3 = model.addOrReplaceChild("model3", CubeListBuilder.create().texOffs(-10, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(0.0f, -8.2f, 4.8f, (float) Math.toRadians(59f), (float) Math.toRadians(177f), 0.0f));
        PartDefinition model4 = model.addOrReplaceChild("model4", CubeListBuilder.create().texOffs(-10, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(-4.8f, -8.2f, 0.0f, (float) Math.toRadians(47f), (float) Math.toRadians(91f), 0.0f));
        PartDefinition model5 = model.addOrReplaceChild("model5", CubeListBuilder.create().texOffs(-10, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(4.8f, -8.2f, 0.0f, (float) Math.toRadians(38f), (float) Math.toRadians(-86f), 0.0f));

        PartDefinition model6 = model.addOrReplaceChild("model6", CubeListBuilder.create().texOffs(10, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(-4.25f, -10.2f, 0.0f, (float) Math.toRadians(45f + 30f), (float) Math.toRadians(91f), (float) Math.toRadians(10f)));
        PartDefinition model7 = model.addOrReplaceChild("model7", CubeListBuilder.create().texOffs(10, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(4.25f, -10.2f, 0.0f, (float) Math.toRadians(47f + 30f), (float) Math.toRadians(-86f), (float) Math.toRadians(-10f)));

        PartDefinition model8 = model.addOrReplaceChild("model8", CubeListBuilder.create().texOffs(30, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(0.0f, -10.2f, -4.8f, (float) Math.toRadians(55f + 30f),0.0f, 0.0f));
        PartDefinition model9 = model.addOrReplaceChild("model9", CubeListBuilder.create().texOffs(30, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(0.0f, -10.2f, 4.8f, (float) Math.toRadians(59f + 30f), (float) Math.toRadians(177f), 0.0f));
        PartDefinition model10 = model.addOrReplaceChild("model10", CubeListBuilder.create().texOffs(30, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(-4.4f, -10.2f, 0.0f, (float) Math.toRadians(47f + 30f), (float) Math.toRadians(91f), 0.0f));
        PartDefinition model11 = model.addOrReplaceChild("model11", CubeListBuilder.create().texOffs(30, 16).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),  PartPose.offsetAndRotation(4.4f, -10.2f, 0.0f, (float) Math.toRadians(38f + 30f), (float) Math.toRadians(-86f), 0.0f));

        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(root.getChild("head"));
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(root.getChild("body"));
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
