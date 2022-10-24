package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.BerserkStrider;
import crimsonspade.berserksandbosses.Entity.Bloodumbra;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BerserkStriderModel<T extends BerserkStrider> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "berserk_strider"), "main");
    public final ModelPart body;
    public final ModelPart RightLeg;
    public final ModelPart LeftLeg;

    public BerserkStriderModel(ModelPart root) {
        this.body = root.getChild("body");
        this.RightLeg = root.getChild("RightLeg");
        this.LeftLeg = root.getChild("LeftLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, -3.0F));
        PartDefinition bone = body.addOrReplaceChild("bone",
                CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -41.0F, -24.0F, 48.0F, 31.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(144, 63)
                        .addBox(-24.0F, -13.0F, -24.0F, 48.0F, 0.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(0, 415)
                        .addBox(0.0F, -51.0F, -34.0F, 0.0F, 29.0F, 68.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition SpinalSpikeLeft = bone.addOrReplaceChild("SpinalSpikeLeft",
                CubeListBuilder.create().texOffs(0, 415).addBox(0.0F, -74.0F, -34.0F, 0.0F, 29.0F, 68.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-9.0F, 22.0F, 0.0F, 0.0F, 0.0F, 0.2182F));
        PartDefinition SpinalSpikeRight = bone.addOrReplaceChild("SpinalSpikeRight",
                CubeListBuilder.create().texOffs(0, 415).addBox(0.0F, -74.0F, -34.0F, 0.0F, 29.0F, 68.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(9.0F, 22.0F, 0.0F, 0.0F, 0.0F, -0.2182F));
        PartDefinition Hair1 = bone.addOrReplaceChild("Hair1",
                CubeListBuilder.create().texOffs(476, -18).addBox(-25.0F, -38.0F, -11.0F, 0.0F, 15.0F, 18.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.2182F));
        PartDefinition Hair2 = bone.addOrReplaceChild("Hair2",
                CubeListBuilder.create().texOffs(0, 88).addBox(-25.0F, -38.0F, -11.0F, 0.0F, 15.0F, 18.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, 22.0F, 16.0F, 0.0F, 0.0F, 0.2182F));
        PartDefinition Hair3 = bone.addOrReplaceChild("Hair3",
                CubeListBuilder.create().texOffs(0, 4).addBox(-25.0F, -38.0F, -12.0F, 0.0F, 15.0F, 11.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, 16.0F, 15.0F, 0.0F, 0.0F, 0.2182F));
        PartDefinition Hair4 = bone.addOrReplaceChild("Hair4",
                CubeListBuilder.create().texOffs(476, -3).addBox(-25.0F, -38.0F, -11.0F, 0.0F, 15.0F, 18.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(57.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.2182F));
        PartDefinition Hair5 = bone.addOrReplaceChild("Hair5",
                CubeListBuilder.create().texOffs(0, 73).addBox(-25.0F, -38.0F, -11.0F, 0.0F, 15.0F, 18.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(57.0F, 11.0F, 16.0F, 0.0F, 0.0F, -0.2182F));
        PartDefinition Hair6 = bone.addOrReplaceChild("Hair6",
                CubeListBuilder.create().texOffs(0, -11).addBox(-25.0F, -38.0F, -12.0F, 0.0F, 15.0F, 11.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(56.0F, 6.0F, 15.0F, 0.0F, 0.0F, -0.1745F));
        PartDefinition bone2 = body.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(192, 0).addBox(-24.0F, -13.0F, -24.0F, 48.0F, 15.0F, 48.0F, new CubeDeformation(0.0F))
                        .texOffs(144, 63).addBox(-24.0F, -10.0F, -24.0F, 48.0F, 0.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(193, 74)
                        .addBox(-24.0F, -27.0F, 21.0F, 48.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 3.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
                CubeListBuilder.create().texOffs(213, 82).addBox(0.0F, 3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-14.0F, -8.0F, 15.0F));
        PartDefinition Bend = RightLeg.addOrReplaceChild("Bend",
                CubeListBuilder.create().texOffs(290, 0).addBox(-18.0F, -18.0F, -5.0F, 10.0F, 23.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(288, 0)
                        .addBox(-18.0F, -5.0F, -24.0F, 10.0F, 10.0F, 19.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(14.0F, 12.0F, 9.0F, 0.7418F, 0.0F, 0.0F));
        PartDefinition Foot = Bend.addOrReplaceChild("Foot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -22.0F));
        PartDefinition cube_r1 = Foot.addOrReplaceChild("cube_r1",
                CubeListBuilder.create().texOffs(498, 496).addBox(-15.0F, -26.0F, -5.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
                        .texOffs(498, 496).addBox(-11.0F, -26.0F, -5.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(294, 0)
                        .addBox(-19.0F, -17.0F, -5.0F, 12.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.829F, 0.0F, 0.0F));
        PartDefinition bone4 = Foot.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(2.0F, -3.0F, 19.0F));
        PartDefinition cube_r2 = bone4.addOrReplaceChild("cube_r2",
                CubeListBuilder.create().texOffs(498, 496).addBox(-18.0F, -26.0F, -5.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, -22.0F, 0.8171F, 0.1603F, -0.1487F));
        PartDefinition bone3 = Foot.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(-3.0F, 1.0F, 23.0F));
        PartDefinition cube_r3 = bone3.addOrReplaceChild("cube_r3",
                CubeListBuilder.create().texOffs(498, 496).addBox(-8.0F, -26.0F, -5.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, -22.0F, 0.8171F, -0.1603F, 0.1487F));
        PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
                CubeListBuilder.create().texOffs(213, 82).addBox(-1.0F, 3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(13.0F, -8.0F, 15.0F));
        PartDefinition Bend2 = LeftLeg.addOrReplaceChild("Bend2",
                CubeListBuilder.create().texOffs(290, 0).addBox(-18.0F, -18.0F, -5.0F, 10.0F, 23.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(288, 1)
                        .addBox(-18.0F, -5.0F, -24.0F, 10.0F, 10.0F, 19.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(13.0F, 12.0F, 9.0F, 0.7418F, 0.0F, 0.0F));
        PartDefinition Foot2 = Bend2.addOrReplaceChild("Foot2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -22.0F));
        PartDefinition cube_r4 = Foot2.addOrReplaceChild("cube_r4",
                CubeListBuilder.create().texOffs(498, 496).addBox(-15.0F, -26.0F, -5.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
                        .texOffs(498, 496).addBox(-11.0F, -26.0F, -5.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(294, 0)
                        .addBox(-19.0F, -17.0F, -5.0F, 12.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.829F, 0.0F, 0.0F));
        PartDefinition bone5 = Foot2.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(2.0F, -3.0F, 19.0F));
        PartDefinition cube_r5 = bone5.addOrReplaceChild("cube_r5",
                CubeListBuilder.create().texOffs(498, 496).addBox(-18.0F, -26.0F, -5.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, -22.0F, 0.8171F, 0.1603F, -0.1487F));
        PartDefinition bone6 = Foot2.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(-3.0F, 1.0F, 23.0F));
        PartDefinition cube_r6 = bone6.addOrReplaceChild("cube_r6",
                CubeListBuilder.create().texOffs(498, 496).addBox(-8.0F, -26.0F, -5.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, -22.0F, 0.8171F, -0.1603F, 0.1487F));
        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}
