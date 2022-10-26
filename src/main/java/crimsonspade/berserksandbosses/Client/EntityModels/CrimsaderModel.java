package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.Crimsader;
import crimsonspade.berserksandbosses.Entity.Pitchful;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class CrimsaderModel<T extends Crimsader> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "crimsader"), "main");
    public final ModelPart Head;
    public final ModelPart UpperTorso;
    public final ModelPart LowerRightArm;
    public final ModelPart LowerLeftArm;

    public CrimsaderModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.UpperTorso = root.getChild("UpperTorso");
        this.LowerRightArm = root.getChild("LowerRightArm");
        this.LowerLeftArm = root.getChild("LowerLeftArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -27.0F, -22.0F, 0.3054F, 0.0F, 0.0F));
        PartDefinition UpperJaw = Head.addOrReplaceChild("UpperJaw",
                CubeListBuilder.create().texOffs(198, 0).addBox(-6.0F, -9.0F, -17.0F, 12.0F, 11.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(1, 220)
                        .addBox(-6.0F, 0.0F, -17.0F, 12.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -1.9477F, 0.8309F, -0.2182F, 0.0F, 0.0F));
        PartDefinition HeadSpikes = UpperJaw.addOrReplaceChild("HeadSpikes",
                CubeListBuilder.create().texOffs(240, 0).addBox(-6.0F, -44.0F, -15.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(240, 0)
                        .addBox(-6.0F, -44.0F, -10.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(240, 0).addBox(-6.0F, -44.0F, -5.0F, 4.0F,
                                4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-27.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition LowerJaw = Head.addOrReplaceChild("LowerJaw",
                CubeListBuilder.create().texOffs(120, 145).addBox(-10.0F, -30.0F, -16.0F, 12.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
                        .texOffs(1, 220).addBox(-10.0F, -27.0F, -16.0F, 12.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(2, 75)
                        .addBox(-9.0F, -35.0F, -7.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(18, 226)
                        .addBox(-10.0F, -35.0F, -3.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(2, 75)
                        .addBox(1.0F, -35.0F, -7.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0F, 29.0523F, -0.1691F));
        PartDefinition UpperTorso = partdefinition.addOrReplaceChild("UpperTorso",
                CubeListBuilder.create().texOffs(124, 0).addBox(-8.0F, -21.0F, -7.0F, 16.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(192, 32)
                        .addBox(-9.0F, -19.0F, -7.5F, 18.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(0, 40)
                        .addBox(-7.0F, -2.0F, -6.0F, 14.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(65, 0).addBox(-4.5F, 4.0F, -3.0F, 9.0F,
                                1.0F, 6.0F, new CubeDeformation(0.5F)),
                PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 1.0472F, 0.0F, 0.0F));
        PartDefinition RightShoulderArmor = UpperTorso.addOrReplaceChild("RightShoulderArmor",
                CubeListBuilder.create().texOffs(96, 0).addBox(-1.0F, -25.0F, 0.0F, 8.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-1.0F, -25.0F, 3.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-9.0F, -10.0F, -18.0F, -0.7245F, -0.1758F, -0.195F));
        PartDefinition LeftShoulderArmor = UpperTorso.addOrReplaceChild("LeftShoulderArmor",
                CubeListBuilder.create().texOffs(96, 0).addBox(-1.0F, -25.0F, 0.0F, 8.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-1.0F, -25.0F, 3.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(3.0F, -11.0F, -17.0F, -0.7245F, 0.1758F, 0.195F));
        PartDefinition RightBackVeil = UpperTorso.addOrReplaceChild("RightBackVeil", CubeListBuilder.create(),
                PartPose.offsetAndRotation(4.0F, -6.0F, -11.0F, -0.1074F, -0.2865F, 0.3646F));
        PartDefinition cube_r1 = RightBackVeil.addOrReplaceChild("cube_r1",
                CubeListBuilder.create().texOffs(83, 14).addBox(-17.0F, -4.0F, 8.0F, 0.0F, 10.0F, 29.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 1.0908F));
        PartDefinition LeftBackVeil = UpperTorso.addOrReplaceChild("LeftBackVeil", CubeListBuilder.create(),
                PartPose.offsetAndRotation(6.0F, -37.0F, 4.0F, 0.8261F, -0.4985F, -2.6701F));
        PartDefinition cube_r2 = LeftBackVeil.addOrReplaceChild("cube_r2",
                CubeListBuilder.create().texOffs(83, 14).addBox(-17.0F, -4.0F, 8.0F, 0.0F, 10.0F, 29.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 1.0908F));
        PartDefinition Neck = UpperTorso.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(183, 0).addBox(-4.0F, -51.0F, -9.5F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 25.0F, 5.0F));
        PartDefinition TailSegment1 = UpperTorso.addOrReplaceChild("TailSegment1",
                CubeListBuilder.create().texOffs(0, 245).addBox(-7.0F, -45.0F, 6.0F, 14.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 51.0F, -4.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition bone = TailSegment1.addOrReplaceChild("bone",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, -42.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone11 = TailSegment1.addOrReplaceChild("bone11",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(9.0F, -42.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition TailSegment2 = TailSegment1.addOrReplaceChild("TailSegment2",
                CubeListBuilder.create().texOffs(200, 242).addBox(-8.0F, -16.0F, -6.0F, 16.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -28.0F, 11.0F));
        PartDefinition bone2 = TailSegment2.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-7.0F, -11.0F, 1.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone12 = TailSegment2.addOrReplaceChild("bone12",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(11.0F, -11.0F, 1.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition TailSegment3 = TailSegment2.addOrReplaceChild("TailSegment3",
                CubeListBuilder.create().texOffs(192, 199).addBox(-9.0F, -42.0F, 4.0F, 18.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 28.0F, -11.0F));
        PartDefinition bone3 = TailSegment3.addOrReplaceChild("bone3",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, -36.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone13 = TailSegment3.addOrReplaceChild("bone13",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(12.0F, -36.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition MainTailSegment = TailSegment3.addOrReplaceChild("MainTailSegment",
                CubeListBuilder.create().texOffs(66, 218).addBox(-10.0F, -39.0F, 3.0F, 20.0F, 22.0F, 16.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bone4 = MainTailSegment.addOrReplaceChild("bone4",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, -31.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone16 = MainTailSegment.addOrReplaceChild("bone16",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(12.0F, -31.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone14 = MainTailSegment.addOrReplaceChild("bone14",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, -26.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone17 = MainTailSegment.addOrReplaceChild("bone17",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(12.0F, -26.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone15 = MainTailSegment.addOrReplaceChild("bone15",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, -21.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone18 = MainTailSegment.addOrReplaceChild("bone18",
                CubeListBuilder.create().texOffs(240, 71).addBox(-4.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(12.0F, -21.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition TailSegment4 = MainTailSegment.addOrReplaceChild("TailSegment4",
                CubeListBuilder.create().texOffs(138, 236).addBox(-9.0F, -20.0F, 4.0F, 18.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition bone5 = TailSegment4.addOrReplaceChild("bone5",
                CubeListBuilder.create().texOffs(240, 71).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-7.0F, -18.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone19 = TailSegment4.addOrReplaceChild("bone19",
                CubeListBuilder.create().texOffs(240, 71).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(11.0F, -18.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition TailSegment5 = TailSegment4.addOrReplaceChild("TailSegment5",
                CubeListBuilder.create().texOffs(66, 199).addBox(-8.0F, -19.0F, 5.0F, 16.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition bone6 = TailSegment5.addOrReplaceChild("bone6",
                CubeListBuilder.create().texOffs(240, 71).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-6.0F, -15.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone20 = TailSegment5.addOrReplaceChild("bone20",
                CubeListBuilder.create().texOffs(240, 71).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(10.0F, -15.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition TailSegment6 = TailSegment5.addOrReplaceChild("TailSegment6",
                CubeListBuilder.create().texOffs(18, 200).addBox(-7.0F, -18.0F, 6.0F, 14.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 1.0F, 1.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition bone7 = TailSegment6.addOrReplaceChild("bone7",
                CubeListBuilder.create().texOffs(240, 71).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-3.0F, -13.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone34 = TailSegment6.addOrReplaceChild("bone34",
                CubeListBuilder.create().texOffs(240, 71).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(7.0F, -13.0F, 12.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition TailSegment7 = TailSegment6.addOrReplaceChild("TailSegment7",
                CubeListBuilder.create().texOffs(0, 200).addBox(-4.5F, -14.0F, 8.0F, 9.0F, 8.0F, 6.0F, new CubeDeformation(0.5F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition TailSegment8 = TailSegment7.addOrReplaceChild("TailSegment8",
                CubeListBuilder.create().texOffs(0, 191).addBox(-3.5F, -5.0F, 9.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.5F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition TailSegment9 = TailSegment8.addOrReplaceChild("TailSegment9",
                CubeListBuilder.create().texOffs(0, 185).addBox(-2.5F, 2.0F, 10.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.5F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition TailEnd = TailSegment9.addOrReplaceChild("TailEnd", CubeListBuilder.create(), PartPose.offset(0.0F, -28.0F, 11.0F));
        PartDefinition bone21 = TailEnd.addOrReplaceChild("bone21",
                CubeListBuilder.create().texOffs(0, 175).addBox(-4.0F, 33.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(26.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone22 = TailEnd.addOrReplaceChild("bone22",
                CubeListBuilder.create().texOffs(0, 176).addBox(-4.0F, 33.0F, -3.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(26.0F, 16.0F, 1.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition bone23 = TailEnd.addOrReplaceChild("bone23",
                CubeListBuilder.create().texOffs(0, 178).addBox(-4.0F, 33.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(26.0F, 22.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition LowerRightArm = partdefinition.addOrReplaceChild("LowerRightArm",
                CubeListBuilder.create().texOffs(56, 119).addBox(-40.0F, -18.5F, -23.0F, 8.0F, 23.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(60, 21)
                        .addBox(-39.0F, -17.5F, -15.0F, 6.0F, 21.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 234)
                        .addBox(-39.0F, -17.5F, -24.0F, 6.0F, 21.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(242, 185)
                        .addBox(-41.0F, -17.5F, -22.0F, 1.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(242, 185)
                        .addBox(-32.0F, -17.5F, -22.0F, 1.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(159, 90)
                        .addBox(-39.0F, -19.5F, -22.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(208, 139)
                        .addBox(-39.0F, 4.5F, -22.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(25.0F, -7.0F, -4.0F, 0.7601F, 0.3323F, 0.4144F));
        PartDefinition UpperRightArm = LowerRightArm.addOrReplaceChild("UpperRightArm",
                CubeListBuilder.create().texOffs(64, 88).addBox(-22.0F, -34.5F, -27.0F, 8.0F, 9.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(149, 80)
                        .addBox(-21.0F, -35.5F, -26.0F, 6.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(135, 189)
                        .addBox(-21.0F, -25.5F, -26.0F, 6.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(0, 142)
                        .addBox(-14.0F, -33.5F, -27.0F, 1.0F, 7.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(0, 142)
                        .addBox(-23.0F, -33.5F, -27.0F, 1.0F, 7.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(83, 14)
                        .addBox(-18.0F, -26.0F, -27.0F, 0.0F, 10.0F, 29.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-18.0F, 30.0F, -18.0F));
        PartDefinition ArmSpikes = UpperRightArm.addOrReplaceChild("ArmSpikes",
                CubeListBuilder.create().texOffs(240, 78).addBox(-22.0F, -1.0F, -28.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(240, 78)
                        .addBox(-22.0F, -1.0F, -23.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(240, 78)
                        .addBox(-22.0F, -1.0F, -18.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(240, 78).addBox(-22.0F, -1.0F, -13.0F,
                                4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-9.0F, -45.0F, 2.0F, 0.0F, 0.0F, -0.7854F));
        PartDefinition RightHand = UpperRightArm.addOrReplaceChild("RightHand",
                CubeListBuilder.create().texOffs(0, 110).addBox(-17.0F, -5.0F, -38.0F, 8.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(35, 155)
                        .addBox(-18.0F, -2.5F, -37.0F, 1.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(11, 155)
                        .addBox(-9.0F, -2.5F, -37.0F, 1.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-23.0F, -24.0F, 3.0F, 0.0F, -0.6545F, -0.829F));
        PartDefinition RightIndex = RightHand.addOrReplaceChild("RightIndex",
                CubeListBuilder.create().texOffs(106, 157).addBox(-13.0F, -4.0F, -42.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(244, 87)
                        .addBox(-13.0F, -4.0F, -44.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
        PartDefinition bone28 = RightIndex.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offset(15.0F, 0.0F, -7.0F));
        PartDefinition cube_r3 = bone28.addOrReplaceChild("cube_r3",
                CubeListBuilder.create().texOffs(244, 87).addBox(4.0F, -4.0F, -44.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));
        PartDefinition RightMiddle = RightHand.addOrReplaceChild("RightMiddle",
                CubeListBuilder.create().texOffs(244, 87).addBox(-13.0F, -1.0F, -44.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(106, 102)
                        .addBox(-13.0F, -1.0F, -42.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.0436F, 0.0F, 0.0F));
        PartDefinition bone29 = RightMiddle.addOrReplaceChild("bone29", CubeListBuilder.create(), PartPose.offset(15.0F, 3.0F, -7.0F));
        PartDefinition cube_r4 = bone29.addOrReplaceChild("cube_r4",
                CubeListBuilder.create().texOffs(244, 87).addBox(4.0F, -4.0F, -44.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));
        PartDefinition RightRing = RightHand.addOrReplaceChild("RightRing",
                CubeListBuilder.create().texOffs(244, 87).addBox(-13.0F, 2.0F, -44.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(158, 122)
                        .addBox(-13.0F, 2.0F, -42.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
        PartDefinition bone30 = RightRing.addOrReplaceChild("bone30", CubeListBuilder.create(), PartPose.offset(15.0F, 6.0F, -7.0F));
        PartDefinition cube_r5 = bone30.addOrReplaceChild("cube_r5",
                CubeListBuilder.create().texOffs(244, 87).addBox(4.0F, -4.0F, -44.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));
        PartDefinition RightPinky = RightHand.addOrReplaceChild("RightPinky",
                CubeListBuilder.create().texOffs(244, 87).addBox(-13.0F, 5.0F, -44.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(137, 124)
                        .addBox(-13.0F, 5.0F, -42.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition bone31 = RightPinky.addOrReplaceChild("bone31", CubeListBuilder.create(), PartPose.offset(15.0F, 9.0F, -7.0F));
        PartDefinition cube_r6 = bone31.addOrReplaceChild("cube_r6",
                CubeListBuilder.create().texOffs(244, 87).addBox(4.0F, -4.0F, -44.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));
        PartDefinition RightThumb = RightHand.addOrReplaceChild(
                "RightThumb", CubeListBuilder.create().texOffs(102, 111).addBox(-11.0F, -7.0F, -36.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(244, 87).addBox(-7.0F, -7.0F, -38.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bone33 = RightThumb.addOrReplaceChild("bone33",
                CubeListBuilder.create().texOffs(244, 87).addBox(-13.0F, -7.0F, -41.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-24.0F, 0.0F, 0.0F, 0.0F, -0.7418F, 0.0F));
        PartDefinition LowerLeftArm = partdefinition.addOrReplaceChild("LowerLeftArm",
                CubeListBuilder.create().texOffs(56, 119).addBox(-40.0F, -18.5F, -23.0F, 8.0F, 23.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(60, 21)
                        .addBox(-39.0F, -17.5F, -15.0F, 6.0F, 21.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 234)
                        .addBox(-39.0F, -17.5F, -24.0F, 6.0F, 21.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(242, 185)
                        .addBox(-41.0F, -17.5F, -22.0F, 1.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(242, 185)
                        .addBox(-32.0F, -17.5F, -22.0F, 1.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(176, 108)
                        .addBox(-39.0F, -19.5F, -22.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(208, 139)
                        .addBox(-39.0F, 4.5F, -22.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(37.0F, -33.0F, 20.0F, 0.7601F, -0.3323F, -0.4144F));
        PartDefinition UpperLeftArm = LowerLeftArm.addOrReplaceChild("UpperLeftArm",
                CubeListBuilder.create().texOffs(64, 88).addBox(-22.0F, -34.5F, -27.0F, 8.0F, 9.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(144, 94)
                        .addBox(-21.0F, -35.5F, -26.0F, 6.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(135, 189)
                        .addBox(-21.0F, -25.5F, -26.0F, 6.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(0, 142)
                        .addBox(-14.0F, -33.5F, -27.0F, 1.0F, 7.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(0, 142)
                        .addBox(-23.0F, -33.5F, -27.0F, 1.0F, 7.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(83, 14)
                        .addBox(-18.0F, -26.0F, -27.0F, 0.0F, 10.0F, 29.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-18.0F, 30.0F, -18.0F));
        PartDefinition ArmSpikes3 = UpperLeftArm.addOrReplaceChild("ArmSpikes3",
                CubeListBuilder.create().texOffs(240, 78).addBox(-22.0F, -1.0F, -28.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(240, 78)
                        .addBox(-22.0F, -1.0F, -23.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(240, 78)
                        .addBox(-22.0F, -1.0F, -18.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(240, 78).addBox(-22.0F, -1.0F, -13.0F,
                                4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -45.0F, 2.0F, 0.0F, 0.0F, -0.7854F));
        PartDefinition LeftHand = UpperLeftArm.addOrReplaceChild("LeftHand",
                CubeListBuilder.create().texOffs(218, 161).addBox(-17.0F, -5.0F, -38.0F, 8.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                        .texOffs(35, 155).addBox(-18.0F, -2.5F, -37.0F, 1.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(11, 155)
                        .addBox(-9.0F, -2.5F, -37.0F, 1.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, -2.0F, -22.0F, 0.0F, 0.9599F, 1.1781F));
        PartDefinition RightIndex2 = LeftHand.addOrReplaceChild("RightIndex2",
                CubeListBuilder.create().texOffs(106, 157).addBox(-15.0F, -4.0F, -42.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(244, 87)
                        .addBox(-17.0F, -4.0F, -44.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
        PartDefinition bone24 = RightIndex2.addOrReplaceChild("bone24", CubeListBuilder.create(), PartPose.offset(7.0F, 0.0F, -7.0F));
        PartDefinition cube_r7 = bone24.addOrReplaceChild("cube_r7",
                CubeListBuilder.create().texOffs(244, 87).addBox(4.0F, -4.0F, -44.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));
        PartDefinition RightMiddle2 = LeftHand.addOrReplaceChild("RightMiddle2",
                CubeListBuilder.create().texOffs(244, 87).addBox(-15.0F, -1.0F, -44.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(106, 102)
                        .addBox(-13.0F, -1.0F, -42.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-2.0F, 2.0F, 0.0F, -0.0436F, 0.0F, 0.0F));
        PartDefinition bone25 = RightMiddle2.addOrReplaceChild("bone25", CubeListBuilder.create(), PartPose.offset(9.0F, 3.0F, -7.0F));
        PartDefinition cube_r8 = bone25.addOrReplaceChild("cube_r8",
                CubeListBuilder.create().texOffs(244, 87).addBox(4.0F, -4.0F, -44.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));
        PartDefinition RightRing2 = LeftHand.addOrReplaceChild("RightRing2",
                CubeListBuilder.create().texOffs(244, 87).addBox(-15.0F, 2.0F, -44.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(158, 122)
                        .addBox(-13.0F, 2.0F, -42.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-2.0F, -2.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
        PartDefinition bone26 = RightRing2.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offset(9.0F, 6.0F, -7.0F));
        PartDefinition cube_r9 = bone26.addOrReplaceChild("cube_r9",
                CubeListBuilder.create().texOffs(244, 87).addBox(4.0F, -4.0F, -44.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));
        PartDefinition RightPinky2 = LeftHand.addOrReplaceChild("RightPinky2",
                CubeListBuilder.create().texOffs(244, 87).addBox(-15.0F, 5.0F, -44.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(137, 124)
                        .addBox(-13.0F, 5.0F, -42.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-2.0F, -5.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition bone27 = RightPinky2.addOrReplaceChild("bone27", CubeListBuilder.create(), PartPose.offset(9.0F, 9.0F, -7.0F));
        PartDefinition cube_r10 = bone27.addOrReplaceChild("cube_r10",
                CubeListBuilder.create().texOffs(244, 87).addBox(4.0F, -4.0F, -44.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));
        PartDefinition RightThumb2 = LeftHand.addOrReplaceChild(
                "RightThumb2", CubeListBuilder.create().texOffs(102, 111).addBox(-11.0F, -7.0F, -36.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(244, 87).addBox(-13.0F, -7.0F, -38.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-8.0F, 0.0F, 0.0F));
        PartDefinition bone32 = RightThumb2.addOrReplaceChild("bone32",
                CubeListBuilder.create().texOffs(244, 87).addBox(-13.0F, -7.0F, -41.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-30.0F, 0.0F, 0.0F, 0.0F, -0.7418F, 0.0F));
        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        UpperTorso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LowerRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LowerLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Head.xRot = headPitch / (180F / (float) Math.PI);
    }
}
