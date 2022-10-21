package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.Chainlock;
import crimsonspade.berserksandbosses.Entity.Springlock;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ChainlockModel<T extends Chainlock> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BerserksAndBosses.MODID, "chainlock"), "main");
    private final ModelPart Head;
    private final ModelPart body;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;

    public ChainlockModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.body = root.getChild("body");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, -6.0F));

        PartDefinition UpperJaw = Head.addOrReplaceChild("UpperJaw", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(104, 17).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition headwear = UpperJaw.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone7 = UpperJaw.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(104, -4).addBox(0.0F, -32.0F, -8.0F, 0.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, -16.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition LowerJaw = Head.addOrReplaceChild("LowerJaw", CubeListBuilder.create().texOffs(96, 87).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(104, 17).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(112, 18).addBox(-4.0F, -5.0F, 2.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition headwear2 = LowerJaw.addOrReplaceChild("headwear2", CubeListBuilder.create().texOffs(39, 64).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(64, 0).addBox(-6.0F, 2.0F, -4.0F, 12.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(96, 1).addBox(-3.5F, 12.0F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -11.0F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 109).addBox(-13.0F, -2.5F, -3.0F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

        PartDefinition bone4 = right_arm.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(40, 112).addBox(-13.0F, 10.5F, -3.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(-11.0F, 10.5F, -6.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 6.0F, -0.6109F, 0.0F, 0.0F));

        PartDefinition bone2 = right_arm.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 23).addBox(4.0F, -29.0F, -8.0F, 0.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 18.0F, 4.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(20, 109).addBox(9.0F, -2.5F, -3.0F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -5.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition bone3 = left_arm.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(60, 112).addBox(9.0F, -20.5F, -3.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(11.0F, -20.5F, -6.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.0F, -11.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition bone = left_arm.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 23).addBox(4.0F, -29.0F, -8.0F, 0.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 17.0F, 4.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(88, 113).addBox(-1.5F, -7.0F, -3.0F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 11.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition bone6 = right_leg.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(112, 97).addBox(-0.5F, 2.0F, -3.0F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(108, 113).addBox(-4.5F, -7.0F, -3.0F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 11.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition bone5 = left_leg.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(-5.0F, 13.0F, 2.0F));

        PartDefinition left_leg_r1 = bone5.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(96, 97).addBox(1.5F, -11.0F, -3.0F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Head.xRot = headPitch / (180F / (float) Math.PI);
        this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}
