package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.BerserkAxolotl;
import crimsonspade.berserksandbosses.Entity.Xenocara;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class XenocaraModel<T extends Xenocara> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "xenocara"), "main");
    public final ModelPart Head;
    public final ModelPart Torso;
    public final ModelPart RightArm;
    public final ModelPart LeftArm;
    public final ModelPart RightLeg;
    public final ModelPart LeftLeg;

    public XenocaraModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.Torso = root.getChild("Torso");
        this.RightArm = root.getChild("RightArm");
        this.LeftArm = root.getChild("LeftArm");
        this.RightLeg = root.getChild("RightLeg");
        this.LeftLeg = root.getChild("LeftLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -19.0F, -12.0F, 0.0F, 0.0F, 0.0873F));
        PartDefinition UpperJaw = Head.addOrReplaceChild(
                "UpperJaw", CubeListBuilder.create().texOffs(96, 0).addBox(-18.0F, 0.0F, -11.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 11).addBox(-18.0F, 3.0F, -11.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(14.2701F, -3.1033F, 3.0F));
        PartDefinition LowerJaw = Head.addOrReplaceChild("LowerJaw",
                CubeListBuilder.create().texOffs(64, 0).addBox(-18.0F, 0.0F, -11.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(64, 11)
                        .addBox(-18.0F, 2.0F, -11.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(72, 12).addBox(-18.0F, -4.0F, -5.0F, 8.0F,
                                6.0F, 0.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(14.2701F, 0.8967F, 3.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 0.0F));
        PartDefinition UpperTorso = Torso.addOrReplaceChild("UpperTorso",
                CubeListBuilder.create().texOffs(86, 110).addBox(-6.0F, -41.0F, -10.0F, 12.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 112)
                        .addBox(-4.0F, -41.0F, -9.0F, 8.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(60, 0)
                        .addBox(-1.0F, -41.0F, -1.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(94, 71)
                        .addBox(-5.0F, -42.0F, -9.0F, 10.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(47, 0).addBox(-1.0F, -43.0F, -3.0F, 2.0F,
                                2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -12.0F, 23.0F, 0.7418F, 0.0F, 0.0F));
        PartDefinition bone10 = UpperTorso.addOrReplaceChild("bone10",
                CubeListBuilder.create().texOffs(106, 61).addBox(-5.0F, -44.0F, 3.0F, 10.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(60, 0)
                        .addBox(-1.0F, -44.0F, 4.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -6.0F, 4.0F, 0.3054F, 0.0F, 0.0F));
        PartDefinition bone13 = bone10.addOrReplaceChild("bone13",
                CubeListBuilder.create().texOffs(114, 6).addBox(5.0F, -61.0F, 24.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(4.0F, 18.0F, -27.0F, 0.0F, -0.1309F, 0.0F));
        PartDefinition bone14 = bone10.addOrReplaceChild("bone14",
                CubeListBuilder.create().texOffs(114, 6).addBox(5.0F, -61.0F, 24.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-14.0F, 18.0F, -26.0F, 0.0F, 0.1309F, 0.0F));
        PartDefinition bone11 = bone10.addOrReplaceChild("bone11",
                CubeListBuilder.create().texOffs(54, 121).addBox(-4.0F, -41.0F, 3.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(60, 0)
                        .addBox(-1.0F, -41.0F, 4.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -14.0F, 22.0F, 0.6545F, 0.0F, 0.0F));
        PartDefinition bone12 = bone11.addOrReplaceChild("bone12",
                CubeListBuilder.create().texOffs(72, 124).addBox(-3.0F, -38.0F, 3.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -11.0F, 22.0F, 0.6545F, 0.0F, 0.0F));
        PartDefinition bone15 = bone12.addOrReplaceChild("bone15",
                CubeListBuilder.create().texOffs(118, 58).addBox(-2.0F, -37.0F, 3.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -8.0F, 22.0F, 0.6545F, 0.0F, 0.0F));
        PartDefinition bone9 = UpperTorso.addOrReplaceChild("bone9",
                CubeListBuilder.create().texOffs(106, 118).addBox(-3.0F, -45.0F, -8.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -9.0F, 21.0F, 0.5672F, 0.0F, 0.0F));
        PartDefinition MiddleTorso = Torso.addOrReplaceChild("MiddleTorso",
                CubeListBuilder.create().texOffs(90, 94).addBox(-5.0F, 4.0F, -5.0F, 10.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 114)
                        .addBox(-4.0F, 4.0F, -4.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(60, 0).addBox(-1.0F, 4.0F, 4.0F, 2.0F, 7.0F,
                                1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -37.0F, -5.0F, 0.48F, 0.0F, 0.0F));
        PartDefinition LowerTorso = Torso.addOrReplaceChild("LowerTorso",
                CubeListBuilder.create().texOffs(100, 79).addBox(-3.5F, -29.0F, -4.0F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.5F)).texOffs(34, 116)
                        .addBox(-2.5F, -29.0F, -3.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.5F)).texOffs(64, 0)
                        .addBox(-0.5F, -29.0F, 4.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.5F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2.0212F, -1.5266F, -1.0F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-6.0F, -17.0F, -8.0F, 0.0F, 0.0F, 0.48F));
        PartDefinition bone7 = RightArm.addOrReplaceChild("bone7",
                CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -38.0F, -5.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(5.9788F, 45.4734F, -18.0F, -0.6109F, 0.0F, 0.0F));
        PartDefinition bone19 = RightArm.addOrReplaceChild("bone19",
                CubeListBuilder.create().texOffs(0, 106).addBox(-54.0F, -23.0F, 10.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(51.9788F, 42.4734F, -25.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition bone20 = RightArm.addOrReplaceChild("bone20",
                CubeListBuilder.create().texOffs(0, 106).addBox(-54.0F, -23.0F, 10.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(54.9788F, 33.4734F, -32.0F, -0.6109F, 0.0F, 0.0F));
        PartDefinition bone21 = RightArm.addOrReplaceChild("bone21",
                CubeListBuilder.create().texOffs(0, 106).addBox(-8.0F, -27.0F, -6.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0212F, 51.4734F, -3.0F, -1.5708F, -1.3963F, 1.5708F));
        PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
                CubeListBuilder.create().texOffs(0, 0).addBox(-1.1624F, -1.6069F, -2.0F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(6.0F, -17.0F, -7.0F, 0.0F, 0.0F, -0.4363F));
        PartDefinition bone8 = LeftArm.addOrReplaceChild("bone8",
                CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -38.0F, -5.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(6.8376F, 45.3931F, -19.0F, -0.6109F, 0.0F, 0.0F));
        PartDefinition bone16 = bone8.addOrReplaceChild("bone16",
                CubeListBuilder.create().texOffs(0, 106).addBox(-8.0F, -27.0F, -6.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, -0.5236F, 0.0F, 0.0F));
        PartDefinition bone17 = bone8.addOrReplaceChild("bone17",
                CubeListBuilder.create().texOffs(0, 106).addBox(-8.0F, -27.0F, -6.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(3.0F, 2.0F, -7.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition bone18 = bone8.addOrReplaceChild("bone18",
                CubeListBuilder.create().texOffs(0, 106).addBox(-8.0F, -27.0F, -6.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-10.0F, 0.0F, -16.0F, -2.7768F, 1.0624F, -2.8196F));
        PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
                CubeListBuilder.create().texOffs(12, 0).addBox(-1.5F, -1.0342F, -3.2156F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F))
                        .texOffs(7, 114).addBox(-0.5F, -0.0342F, -2.2156F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-4.0F, -1.0F, -1.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition bone = RightLeg.addOrReplaceChild("bone",
                CubeListBuilder.create().texOffs(36, 0).addBox(-8.5F, 0.0F, -3.0F, 3.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(8.0F, 8.9658F, 0.7844F, -0.2182F, 0.0F, 0.0F));
        PartDefinition bone3 = RightLeg.addOrReplaceChild("bone3",
                CubeListBuilder.create().texOffs(27, 67).addBox(-7.5F, 7.0F, -2.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(8.0F, 8.9658F, -3.2156F, 0.2182F, 0.0F, 0.0F));
        PartDefinition bone5 = RightLeg.addOrReplaceChild("bone5",
                CubeListBuilder.create().texOffs(27, 67).addBox(-12.5F, -22.0F, -2.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(13.0F, 32.9658F, 1.7844F, 0.0873F, 0.0F, 0.0F));
        PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
                CubeListBuilder.create().texOffs(12, 0).addBox(-3.5F, -1.0457F, -2.9541F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F))
                        .texOffs(7, 114).addBox(-2.5F, -0.0457F, -1.9541F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(4.0F, -1.0F, -1.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition bone2 = LeftLeg.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(36, 0).addBox(-8.5F, 0.0F, -3.0F, 3.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(6.0F, 8.9543F, 1.0459F, -0.2182F, 0.0F, 0.0F));
        PartDefinition bone4 = LeftLeg.addOrReplaceChild("bone4",
                CubeListBuilder.create().texOffs(27, 67).addBox(-7.5F, 7.0F, -2.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(6.0F, 8.9543F, -2.9541F, 0.2182F, 0.0F, 0.0F));
        PartDefinition bone6 = LeftLeg.addOrReplaceChild("bone6",
                CubeListBuilder.create().texOffs(27, 67).addBox(-12.5F, -22.0F, -2.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(11.0F, 32.9543F, 2.0459F, 0.0873F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}
