package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.Bloodumbra;
import crimsonspade.berserksandbosses.Entity.FrigidBonerott;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class BloodumbraModel<T extends Bloodumbra> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "bloodumbra"), "main");
    public final ModelPart head;
    public final ModelPart body;
    public final ModelPart left_arm;
    public final ModelPart right_arm;
    public final ModelPart bone4;
    public final ModelPart bone3;
    public final ModelPart bone2;
    public final ModelPart bone;

    public BloodumbraModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.bone4 = root.getChild("bone4");
        this.bone3 = root.getChild("bone3");
        this.bone2 = root.getChild("bone2");
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition headwear = head.addOrReplaceChild("headwear",
                CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-1.0F, 7.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-1.0F, 1.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(1.0F, 6.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(1.0F, 6.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-1.0F, 6.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-2.0F, 5.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(2.0F, 5.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(3.0F, 3.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-3.0F, 3.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-2.0F, 1.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(2.0F, 1.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(1.0F, 0.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-1.0F, 0.0F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(1.0F, 2.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-3.0F, 6.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-3.0F, 2.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-4.0F, 5.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(-4.0F, 3.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(2.0F, 5.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 16)
                        .addBox(2.0F, 3.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
                CubeListBuilder.create().texOffs(40, 16).addBox(9.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-4.0F, 3.0F, -5.0F, -1.7538F, -0.3681F, -0.136F));
        PartDefinition Finger1 = left_arm.addOrReplaceChild("Finger1",
                CubeListBuilder.create().texOffs(24, 0).addBox(4.0F, -13.0F, -6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 16)
                        .addBox(4.0F, -12.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(6.0F, 21.0F, 1.0F, 0.0F, 0.1745F, 0.0F));
        PartDefinition Finger2 = left_arm.addOrReplaceChild("Finger2",
                CubeListBuilder.create().texOffs(24, 0).addBox(4.0F, -13.0F, -6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 16)
                        .addBox(4.0F, -12.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(7.0F, 21.0F, 0.0F, 0.0F, -0.1745F, 0.0F));
        PartDefinition Finger6 = left_arm.addOrReplaceChild(
                "Finger6", CubeListBuilder.create().texOffs(24, 0).addBox(4.0F, -13.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(40, 16).addBox(4.0F, -12.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(2.0F, 22.0F, 3.0F));
        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
                CubeListBuilder.create().texOffs(0, 32).addBox(-13.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(4.0F, 3.0F, -5.0F, -1.6389F, 0.328F, 0.0734F));
        PartDefinition Finger3 = right_arm.addOrReplaceChild("Finger3",
                CubeListBuilder.create().texOffs(24, 0).addBox(4.0F, -13.0F, -6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 16)
                        .addBox(4.0F, -12.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-15.0F, 21.0F, 0.0F, 0.0F, -0.1745F, 0.0F));
        PartDefinition Finger4 = right_arm.addOrReplaceChild("Finger4",
                CubeListBuilder.create().texOffs(24, 0).addBox(4.0F, -13.0F, -6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 16)
                        .addBox(4.0F, -12.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-16.0F, 21.0F, 2.0F, 0.0F, 0.3054F, 0.0F));
        PartDefinition Finger5 = right_arm.addOrReplaceChild(
                "Finger5", CubeListBuilder.create().texOffs(24, 0).addBox(4.0F, -13.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(40, 16).addBox(6.0F, -12.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-13.0F, 22.0F, 3.0F));
        PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4",
                CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-3.0F, 12.0F, 0.0F));
        PartDefinition Leg4 = bone4.addOrReplaceChild("Leg4",
                CubeListBuilder.create().texOffs(8, 54).addBox(-4.0F, -16.0F, -6.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(28, 46)
                        .addBox(-4.0F, -14.0F, 0.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, 11.0F, 10.0F, 0.4363F, -0.9599F, 0.0F));
        PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3",
                CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(3.0F, 12.0F, 0.0F));
        PartDefinition Leg3 = bone3.addOrReplaceChild("Leg3",
                CubeListBuilder.create().texOffs(8, 54).addBox(-4.0F, -16.0F, -6.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(28, 46)
                        .addBox(-4.0F, -14.0F, 0.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(9.0F, 11.0F, 9.0F, 0.4363F, 0.6109F, 0.0F));
        PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(3.0F, 12.0F, 0.0F));
        PartDefinition Leg2 = bone2.addOrReplaceChild("Leg2",
                CubeListBuilder.create().texOffs(44, 54).addBox(-4.0F, -16.0F, -6.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 47)
                        .addBox(-4.0F, -14.0F, -6.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(8.0F, 13.0F, -5.0F, -0.3927F, -0.7418F, 0.0F));
        PartDefinition bone = partdefinition.addOrReplaceChild("bone",
                CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-3.0F, 12.0F, 0.0F));
        PartDefinition Leg1 = bone.addOrReplaceChild("Leg1",
                CubeListBuilder.create().texOffs(44, 54).addBox(-4.0F, -16.0F, -6.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 47)
                        .addBox(-4.0F, -14.0F, -6.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-3.0F, 13.0F, -9.0F, -0.3927F, 0.7418F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
        this.bone3.zRot = Mth.cos(limbSwing) * -1.0F * limbSwingAmount;
        this.bone2.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.bone4.zRot = Mth.cos(limbSwing) * 1.0F * limbSwingAmount;
        this.bone.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
    }
}
