package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.AshuraEnderman;
import crimsonspade.berserksandbosses.Entity.Bloodumbra;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class AshuraEndermanModel<T extends AshuraEnderman> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "ashura_enderman"), "main");
    public final ModelPart head1;
    public final ModelPart head2;
    public final ModelPart head3;
    public final ModelPart body;
    public final ModelPart right_arm1;
    public final ModelPart right_arm2;
    public final ModelPart right_arm3;
    public final ModelPart left_arm1;
    public final ModelPart left_arm2;
    public final ModelPart left_arm3;
    public final ModelPart right_leg;
    public final ModelPart left_leg;

    public AshuraEndermanModel(ModelPart root) {
        this.head1 = root.getChild("head1");
        this.head2 = root.getChild("head2");
        this.head3 = root.getChild("head3");
        this.body = root.getChild("body");
        this.right_arm1 = root.getChild("right_arm1");
        this.right_arm2 = root.getChild("right_arm2");
        this.right_arm3 = root.getChild("right_arm3");
        this.left_arm1 = root.getChild("left_arm1");
        this.left_arm2 = root.getChild("left_arm2");
        this.left_arm3 = root.getChild("left_arm3");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head1 = partdefinition.addOrReplaceChild("head1",
                CubeListBuilder.create().texOffs(0, 0).addBox(-5.4582F, -4.8674F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -20.0F, -7.0F, 0.0F, 0.0F, -0.48F));
        PartDefinition headwear = head1.addOrReplaceChild("headwear",
                CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.5F)),
                PartPose.offset(-1.4582F, 7.1326F, -4.0F));
        PartDefinition head2 = partdefinition.addOrReplaceChild("head2",
                CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, -15.0F, 0.0F, 2.641F, 0.4737F, 2.9442F));
        PartDefinition headwear2 = head2.addOrReplaceChild("headwear2",
                CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.5F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head3 = partdefinition.addOrReplaceChild("head3",
                CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(4.0F, -15.0F, 1.0F, 2.4986F, -0.3828F, -2.7159F));
        PartDefinition headwear3 = head3.addOrReplaceChild("headwear3",
                CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.5F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(32, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -15.0F, 0.0F));
        PartDefinition Neck = body.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(56, 22).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition right_arm1 = partdefinition.addOrReplaceChild("right_arm1",
                CubeListBuilder.create().texOffs(56, 0).addBox(-0.8294F, -0.7527F, -1.0576F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(34, 17).addBox(-0.8294F, 15.2473F, -14.0576F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(34, 17)
                        .addBox(-1.8294F, 13.2473F, -20.0576F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 26)
                        .addBox(1.1706F, 14.2473F, -21.0576F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 5)
                        .addBox(1.1706F, 12.2473F, -18.0576F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 29)
                        .addBox(1.1706F, 16.2473F, -21.0576F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 25)
                        .addBox(1.1706F, 18.2473F, -21.0576F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-4.0F, -13.0F, 0.0F, -0.6962F, 0.8181F, 0.5306F));
        PartDefinition right_arm2 = partdefinition.addOrReplaceChild("right_arm2",
                CubeListBuilder.create().texOffs(56, 0).addBox(-11.0F, -2.0F, -1.0F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 17)
                        .addBox(-11.0F, 14.0F, -14.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(34, 17)
                        .addBox(-12.0F, 12.0F, -20.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 26)
                        .addBox(-9.0F, 13.0F, -21.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 5)
                        .addBox(-9.0F, 11.0F, -18.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 29)
                        .addBox(-9.0F, 15.0F, -21.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 25).addBox(-9.0F, 17.0F, -21.0F, 3.0F,
                                1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, -20.0F, -5.0F, 2.2104F, 0.7909F, -2.0862F));
        PartDefinition right_arm3 = partdefinition.addOrReplaceChild("right_arm3",
                CubeListBuilder.create().texOffs(56, 0).addBox(-11.0F, -2.0F, -1.0F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 17)
                        .addBox(-11.0F, 14.0F, -14.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(34, 17)
                        .addBox(-12.0F, 12.0F, -20.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 26)
                        .addBox(-9.0F, 13.0F, -21.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 5)
                        .addBox(-9.0F, 11.0F, -18.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 29)
                        .addBox(-9.0F, 15.0F, -21.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 25).addBox(-9.0F, 17.0F, -21.0F, 3.0F,
                                1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-10.0F, -9.0F, -5.0F, 2.0345F, 0.7401F, 2.6631F));
        PartDefinition left_arm1 = partdefinition.addOrReplaceChild("left_arm1",
                CubeListBuilder.create().texOffs(56, 0).mirror().addBox(-0.9792F, -0.8115F, -1.0486F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
                        .mirror(false).texOffs(34, 17).mirror().addBox(-0.9792F, 15.1885F, -14.0486F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                        .mirror(false).texOffs(34, 17).addBox(-1.9792F, 13.1885F, -20.0486F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 5).addBox(-3.9792F, 12.1885F, -18.0486F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 26)
                        .addBox(-3.9792F, 14.1885F, -21.0486F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 29)
                        .addBox(-3.9792F, 16.1885F, -21.0486F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 25)
                        .addBox(-3.9792F, 18.1885F, -21.0486F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(4.0F, -14.0F, 0.0F, -0.6311F, -0.7007F, -0.4585F));
        PartDefinition left_arm2 = partdefinition.addOrReplaceChild("left_arm2",
                CubeListBuilder.create().texOffs(56, 0).mirror().addBox(9.0F, -2.0F, -1.0F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
                        .mirror(false).texOffs(34, 17).mirror().addBox(9.0F, 14.0F, -14.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                        .mirror(false).texOffs(34, 17).addBox(8.0F, 12.0F, -20.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 5)
                        .addBox(6.0F, 11.0F, -18.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 26)
                        .addBox(6.0F, 13.0F, -21.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 29)
                        .addBox(6.0F, 15.0F, -21.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 25).addBox(6.0F, 17.0F, -21.0F, 3.0F,
                                1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(12.0F, -14.0F, 0.0F, 1.874F, -0.3206F, 3.0844F));
        PartDefinition left_arm3 = partdefinition.addOrReplaceChild("left_arm3",
                CubeListBuilder.create().texOffs(56, 0).mirror().addBox(9.0F, -2.0F, -1.0F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
                        .mirror(false).texOffs(34, 17).mirror().addBox(9.0F, 14.0F, -14.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                        .mirror(false).texOffs(34, 17).addBox(8.0F, 12.0F, -20.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 5)
                        .addBox(6.0F, 11.0F, -18.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 26)
                        .addBox(6.0F, 13.0F, -21.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 29)
                        .addBox(6.0F, 15.0F, -21.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 25).addBox(6.0F, 17.0F, -21.0F, 3.0F,
                                1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(5.0F, -5.0F, -2.0F, 2.1687F, -0.4147F, -2.0719F));
        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
                CubeListBuilder.create().texOffs(56, 0).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 30.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-2.0F, -6.0F, -1.0F));
        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(56, 0).mirror()
                .addBox(-1.0F, 0.0F, -1.0F, 3.0F, 30.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -6.0F, -1.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
                               float alpha) {
        head1.render(poseStack, buffer, packedLight, packedOverlay);
        head2.render(poseStack, buffer, packedLight, packedOverlay);
        head3.render(poseStack, buffer, packedLight, packedOverlay);
        body.render(poseStack, buffer, packedLight, packedOverlay);
        right_arm1.render(poseStack, buffer, packedLight, packedOverlay);
        right_arm2.render(poseStack, buffer, packedLight, packedOverlay);
        right_arm3.render(poseStack, buffer, packedLight, packedOverlay);
        left_arm1.render(poseStack, buffer, packedLight, packedOverlay);
        left_arm2.render(poseStack, buffer, packedLight, packedOverlay);
        left_arm3.render(poseStack, buffer, packedLight, packedOverlay);
        right_leg.render(poseStack, buffer, packedLight, packedOverlay);
        left_leg.render(poseStack, buffer, packedLight, packedOverlay);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.left_arm1.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.head1.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head1.xRot = headPitch / (180F / (float) Math.PI);
        this.right_arm1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
    }
}
