package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.Bloodumbra;
import crimsonspade.berserksandbosses.Entity.CalamityGolem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CalamityGolemModel<T extends CalamityGolem> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "calamity_golem"), "main");
    public final ModelPart UpperJaw;
    public final ModelPart body;
    public final ModelPart right_arm;
    public final ModelPart left_arm;
    public final ModelPart right_leg;
    public final ModelPart left_leg;

    public CalamityGolemModel(ModelPart root) {
        this.UpperJaw = root.getChild("UpperJaw");
        this.body = root.getChild("body");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition UpperJaw = partdefinition.addOrReplaceChild("UpperJaw",
                CubeListBuilder.create().texOffs(0, 113).addBox(-4.0F, -5.0F, -8.5F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(122, 91)
                        .addBox(-1.0F, -7.0F, -9.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(122, 86)
                        .addBox(-1.0F, -6.0F, -0.5F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(108, 80)
                        .addBox(-1.0F, -6.0F, -8.5F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(122, 90)
                        .addBox(-5.0F, -7.0F, -5.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 90)
                        .addBox(4.0F, -7.0F, -5.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(-8, 79)
                        .addBox(-4.0F, -1.0F, -8.5F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -14.0F, -5.0F));
        PartDefinition LowerJaw = UpperJaw.addOrReplaceChild("LowerJaw",
                CubeListBuilder.create().texOffs(32, 118).addBox(-4.0F, 1.0F, -11.5F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 79)
                        .addBox(-4.0F, -3.0F, -6.5F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(-8, 79)
                        .addBox(-4.0F, 2.0F, -11.5F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 3.0F));
        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(62, 105).addBox(-11.0F, -2.0F, -6.0F, 22.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(88, 89)
                        .addBox(-6.5F, 10.0F, -4.0F, 13.0F, 9.0F, 7.0F, new CubeDeformation(0.5F)).texOffs(0, 106)
                        .addBox(-1.0F, -3.0F, 4.5F, 2.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 117)
                        .addBox(-1.0F, 10.0F, 3.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 104)
                        .addBox(-1.0F, -3.0F, -3.5F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -13.0F, 0.0F));
        PartDefinition EvokerFang1 = body.addOrReplaceChild("EvokerFang1", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-6.0F, -11.0F, 3.0F, -0.519F, -0.1925F, -0.49F));
        PartDefinition base = EvokerFang1.addOrReplaceChild("base",
                CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition upper_jaw = EvokerFang1.addOrReplaceChild("upper_jaw", CubeListBuilder.create(), PartPose.offset(-2.5F, -14.0F, 1.0F));
        PartDefinition upper_jaw_rotation = upper_jaw.addOrReplaceChild("upper_jaw_rotation",
                CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
                        .addBox(-2.0F, -7.0F, -4.0F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, 7.0F, 4.0F, 0.0F, 0.0F, 3.0107F));
        PartDefinition lower_jaw = EvokerFang1.addOrReplaceChild("lower_jaw", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-1.5F, -14.0F, 1.0F, 0.0F, 0.0F, 0.1309F));
        PartDefinition lower_jaw_rotation = lower_jaw.addOrReplaceChild("lower_jaw_rotation",
                CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0F, 7.0F, 4.0F, 3.1416F, 0.0F, 0.0F));
        PartDefinition EvokerFang2 = body.addOrReplaceChild("EvokerFang2", CubeListBuilder.create(),
                PartPose.offsetAndRotation(15.0F, -7.0F, 2.0F, -0.5773F, 0.1624F, 0.4068F));
        PartDefinition base2 = EvokerFang2.addOrReplaceChild("base2",
                CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition upper_jaw2 = EvokerFang2.addOrReplaceChild("upper_jaw2", CubeListBuilder.create(), PartPose.offset(-2.5F, -14.0F, 1.0F));
        PartDefinition upper_jaw_rotation2 = upper_jaw2.addOrReplaceChild("upper_jaw_rotation2",
                CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, 7.0F, 4.0F, 0.0F, 0.0F, 3.0107F));
        PartDefinition lower_jaw2 = EvokerFang2.addOrReplaceChild("lower_jaw2", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-1.5F, -14.0F, 1.0F, 0.0F, 0.0F, 0.1309F));
        PartDefinition lower_jaw_rotation2 = lower_jaw2.addOrReplaceChild("lower_jaw_rotation2",
                CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0F, 7.0F, 4.0F, 3.1416F, 0.0F, 0.0F));
        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
                CubeListBuilder.create().texOffs(4, 4).addBox(-6.0F, -3.5F, -3.0F, 6.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(17, 8)
                        .addBox(-7.0F, -3.5F, -1.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(13, 36)
                        .addBox(-6.0F, 13.5F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(11, 13)
                        .addBox(-7.0F, -4.5F, -1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
                        .addBox(-3.5F, 13.0F, -4.0F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-11.0F, -13.0F, 0.0F));
        PartDefinition Rotate = right_arm.addOrReplaceChild("Rotate",
                CubeListBuilder.create().texOffs(40, 0).addBox(22.5F, 13.0F, -11.0F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(20.0F, 0.0F, -7.0F, 0.0F, 3.1416F, 0.0F));
        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
                CubeListBuilder.create().texOffs(4, 4).addBox(0.0F, -3.5F, -3.0F, 6.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(13, 36)
                        .addBox(0.0F, 13.5F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
                        .addBox(2.5F, 13.0F, -4.0F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(17, 8)
                        .addBox(6.0F, -3.5F, -1.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(11, 13)
                        .addBox(1.0F, -4.5F, -1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(11.0F, -13.0F, 0.0F));
        PartDefinition Rotate2 = left_arm.addOrReplaceChild("Rotate2",
                CubeListBuilder.create().texOffs(40, 0).addBox(22.5F, 13.0F, -11.0F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(26.0F, 0.0F, -7.0F, 0.0F, 3.1416F, 0.0F));
        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
                CubeListBuilder.create().texOffs(84, 0).addBox(-3.5F, -2.0F, -3.0F, 6.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(122, 80)
                        .addBox(-2.0F, -2.0F, -3.5F, 2.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 8)
                        .addBox(-4.5F, 13.0F, -4.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-6.0F, 4.0F, 0.0F));
        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
                CubeListBuilder.create().texOffs(106, 0).addBox(-2.5F, -2.0F, -3.0F, 6.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
                        .addBox(-3.5F, 13.0F, -4.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(122, 80)
                        .addBox(0.0F, -2.0F, -3.5F, 2.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(6.0F, 4.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        UpperJaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.UpperJaw.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.UpperJaw.xRot = headPitch / (180F / (float) Math.PI);
    }
}
