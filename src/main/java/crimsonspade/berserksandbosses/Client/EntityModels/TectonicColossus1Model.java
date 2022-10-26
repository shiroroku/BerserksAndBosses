package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.Springlock;
import crimsonspade.berserksandbosses.Entity.TectonicColossus1;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TectonicColossus1Model<T extends TectonicColossus1> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "tectonic_colossus_1"), "main");
    public final ModelPart head;
    public final ModelPart body;
    public final ModelPart right_arm;
    public final ModelPart left_arm;
    public final ModelPart Leg1;
    public final ModelPart Leg2;

    public TectonicColossus1Model(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.Leg1 = root.getChild("Leg1");
        this.Leg2 = root.getChild("Leg2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(96, 113).addBox(-4.0F, -4.0F, -7.5F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -9.0F, -4.0F));
        PartDefinition body = partdefinition.addOrReplaceChild(
                "body", CubeListBuilder.create().texOffs(70, 76).addBox(-9.0F, -4.0F, -6.0F, 18.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                        .texOffs(98, 103).addBox(-4.5F, 8.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)),
                PartPose.offset(0.0F, -5.0F, 0.0F));
        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
                CubeListBuilder.create().texOffs(0, 97).addBox(-5.0F, 0.5F, -4.0F, 5.0F, 25.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 84)
                        .addBox(-6.0F, -3.0F, -5.0F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(44, 99)
                        .addBox(-7.0F, -4.0F, -2.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-9.0F, -8.0F, 0.0F));
        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
                CubeListBuilder.create().texOffs(22, 97).addBox(0.0F, 0.5F, -4.0F, 5.0F, 25.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(30, 83)
                        .addBox(0.0F, -3.0F, -5.0F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(62, 99)
                        .addBox(1.0F, -4.0F, -2.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(9.0F, -8.0F, 0.0F));
        PartDefinition Leg1 = partdefinition.addOrReplaceChild("Leg1",
                CubeListBuilder.create().texOffs(66, 107).addBox(0.0F, 0.0F, -2.0F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offset(1.0F, 8.0F, 0.0F));
        PartDefinition Leg2 = partdefinition.addOrReplaceChild("Leg2",
                CubeListBuilder.create().texOffs(44, 107).addBox(-6.0F, 0.0F, -2.0F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-1.0F, 8.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
        this.Leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.Leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
    }
}
