package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.BerserkPhantom;
import crimsonspade.berserksandbosses.Entity.Pitchful;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class PitchfulModel<T extends Pitchful> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "pitchful"), "main");
    public final ModelPart Head;
    public final ModelPart body;
    public final ModelPart bone10;
    public final ModelPart bone9;
    public final ModelPart bone8;
    public final ModelPart bone7;

    public PitchfulModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.body = root.getChild("body");
        this.bone10 = root.getChild("bone10");
        this.bone9 = root.getChild("bone9");
        this.bone8 = root.getChild("bone8");
        this.bone7 = root.getChild("bone7");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 1.0F, -17.0F, 0.3491F, 0.0F, -0.3491F));
        PartDefinition UpperJaw = Head.addOrReplaceChild("UpperJaw",
                CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -42.0F, -8.0F, 8.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(99, 32)
                        .addBox(-4.0F, -37.0F, -8.0F, 8.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.2453F, 36.8201F, -10.252F, -0.1309F, 0.0F, 0.0F));
        PartDefinition bone4 = UpperJaw.addOrReplaceChild("bone4",
                CubeListBuilder.create().texOffs(112, 26).addBox(-4.0F, -37.0F, -8.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition TeethLeft = UpperJaw.addOrReplaceChild("TeethLeft",
                CubeListBuilder.create().texOffs(102, 15).addBox(4.0F, -39.0F, -8.0F, 0.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition TeethLeft2 = UpperJaw.addOrReplaceChild("TeethLeft2",
                CubeListBuilder.create().texOffs(102, 15).addBox(4.0F, -39.0F, -8.0F, 0.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-8.0F, 2.0F, 0.0F));
        PartDefinition LowerJaw = Head.addOrReplaceChild("LowerJaw",
                CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -37.0F, -8.0F, 8.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(99, 32)
                        .addBox(-4.0F, -36.0F, -8.0F, 8.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.2453F, 37.8201F, 10.748F, 0.4363F, 0.0F, 0.0F));
        PartDefinition TeethLeft3 = LowerJaw.addOrReplaceChild("TeethLeft3",
                CubeListBuilder.create().texOffs(102, 17).addBox(4.0F, -39.0F, -8.0F, 0.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-8.0F, 0.0F, 0.0F));
        PartDefinition TeethLeft4 = LowerJaw.addOrReplaceChild("TeethLeft4",
                CubeListBuilder.create().texOffs(102, 17).addBox(4.0F, -39.0F, -8.0F, 0.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bone5 = LowerJaw.addOrReplaceChild("bone5",
                CubeListBuilder.create().texOffs(112, 24).addBox(-4.0F, -37.0F, -8.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -2.0F, 0.0F));
        PartDefinition bone6 = Head.addOrReplaceChild(
                "bone6", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, -39.0F, 4.0F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(112, 37).addBox(-4.0F, -39.0F, 4.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.2453F, 37.8201F, -5.252F));
        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(62, 0).addBox(-9.0F, 0.0F, -1.0F, 18.0F, 21.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 2.0F, -11.0F, 1.1781F, 0.0F, 0.0F));
        PartDefinition bone = body.addOrReplaceChild("bone",
                CubeListBuilder.create().texOffs(40, 0).addBox(-3.0F, -42.0F, 0.0F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 33.0F, 14.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition bone2 = body.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(112, 0).addBox(-5.0F, -31.0F, -8.0F, 1.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0F, 33.0F, 14.0F, 0.0F, -0.2182F, 0.0F));
        PartDefinition bone3 = body.addOrReplaceChild("bone3",
                CubeListBuilder.create().texOffs(120, 0).addBox(0.0F, -31.0F, -8.0F, 1.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(5.0F, 33.0F, 13.0F, 0.0F, 0.2182F, 0.0F));
        PartDefinition BackArm = body.addOrReplaceChild("BackArm",
                CubeListBuilder.create().texOffs(0, 114).addBox(-1.0F, -27.0F, -8.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 116)
                        .addBox(-1.0F, -37.0F, 2.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(2.0F, 39.0F, 14.0F, 0.0903F, -0.4623F, -0.2934F));
        PartDefinition Hand3 = BackArm.addOrReplaceChild("Hand3",
                CubeListBuilder.create().texOffs(93, 92).addBox(-17.0F, -2.0F, -5.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(6.0F, -48.0F, 2.0F, -1.4834F, -0.0057F, -0.9159F));
        PartDefinition Finger13 = Hand3.addOrReplaceChild("Finger13",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -10.0F, 4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-26.0F, 9.0F, -4.0F, 0.0958F, 0.0378F, 2.4425F));
        PartDefinition Finger14 = Hand3.addOrReplaceChild("Finger14",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-26.0F, 7.0F, 5.0F, 0.8751F, -0.5742F, 2.3313F));
        PartDefinition Finger15 = Hand3.addOrReplaceChild("Finger15",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-17.0F, 10.0F, 12.0F, 1.628F, -0.869F, 1.2624F));
        PartDefinition BackArm2 = body.addOrReplaceChild("BackArm2",
                CubeListBuilder.create().texOffs(0, 114).addBox(-1.0F, -27.0F, -8.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 116)
                        .addBox(-1.0F, -37.0F, 2.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-9.0F, 37.0F, 17.0F, 0.1845F, 0.3921F, 0.5544F));
        PartDefinition Hand4 = BackArm2.addOrReplaceChild("Hand4",
                CubeListBuilder.create().texOffs(92, 91).addBox(9.0F, -2.0F, -8.0F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-13.0F, -39.0F, 0.0F, -1.16F, -0.1864F, 0.1155F));
        PartDefinition Finger16 = Hand4.addOrReplaceChild("Finger16",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -10.0F, 4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(26.0F, 10.0F, -4.0F, -3.1395F, 0.2746F, 0.6958F));
        PartDefinition Finger17 = Hand4.addOrReplaceChild("Finger17",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(5.0F, 9.0F, 5.0F, 1.039F, -0.7261F, 2.0624F));
        PartDefinition Finger18 = Hand4.addOrReplaceChild("Finger18",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(9.0F, 10.0F, 8.0F, 1.5246F, -0.8695F, 1.3977F));
        PartDefinition bone10 = partdefinition.addOrReplaceChild("bone10",
                CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-9.0F, 1.0F, -6.0F));
        PartDefinition right_arm = bone10.addOrReplaceChild("right_arm",
                CubeListBuilder.create().texOffs(96, 104).addBox(-5.6308F, -1.2198F, -3.366F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.1309F, 0.0F, 0.9163F));
        PartDefinition Upperarm = right_arm.addOrReplaceChild("Upperarm",
                CubeListBuilder.create().texOffs(72, 106).addBox(-16.0F, -18.0F, -2.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 108)
                        .addBox(-15.0F, -18.0F, -1.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(19.3692F, 11.7802F, -8.366F, -0.4363F, 0.0F, -0.8727F));
        PartDefinition Hand2 = right_arm.addOrReplaceChild("Hand2",
                CubeListBuilder.create().texOffs(93, 92).addBox(-17.0F, -2.0F, -5.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(18.3692F, 10.7802F, -10.366F, -0.0435F, -0.0057F, -0.9159F));
        PartDefinition Finger7 = Hand2.addOrReplaceChild("Finger7",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -10.0F, 4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-26.0F, 9.0F, -4.0F, 0.0958F, -0.0491F, 2.4342F));
        PartDefinition Finger8 = Hand2.addOrReplaceChild("Finger8",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-26.0F, 7.0F, 5.0F, 0.8751F, -0.5742F, 2.3313F));
        PartDefinition Finger9 = Hand2.addOrReplaceChild("Finger9",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-18.0F, 10.0F, 12.0F, 1.5246F, -0.8695F, 1.3977F));
        PartDefinition bone9 = partdefinition.addOrReplaceChild("bone9",
                CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(9.0F, 1.0F, -7.0F));
        PartDefinition left_arm = bone9.addOrReplaceChild("left_arm",
                CubeListBuilder.create().texOffs(96, 104).addBox(-2.2465F, -0.9454F, -2.3849F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.1309F, 0.0F, -0.8727F));
        PartDefinition Upperarm2 = left_arm.addOrReplaceChild("Upperarm2",
                CubeListBuilder.create().texOffs(72, 106).addBox(10.0F, -18.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 108)
                        .addBox(11.0F, -18.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-20.2465F, 12.0546F, -7.3849F, -0.4363F, 0.0F, 0.8727F));
        PartDefinition Hand = left_arm.addOrReplaceChild("Hand",
                CubeListBuilder.create().texOffs(92, 91).addBox(9.0F, -2.0F, -8.0F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-19.2465F, 11.0546F, -7.3849F, -0.0873F, 0.0F, 0.8727F));
        PartDefinition Finger10 = Hand.addOrReplaceChild("Finger10",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -10.0F, 4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(26.0F, 10.0F, -4.0F, -3.1395F, 0.2746F, 0.6958F));
        PartDefinition Finger11 = Hand.addOrReplaceChild("Finger11",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(5.0F, 9.0F, 5.0F, 1.039F, -0.7261F, 2.0624F));
        PartDefinition Finger12 = Hand.addOrReplaceChild("Finger12",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(9.0F, 10.0F, 8.0F, 1.5246F, -0.8695F, 1.3977F));
        PartDefinition bone8 = partdefinition.addOrReplaceChild("bone8",
                CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-7.0F, 7.0F, 9.0F));
        PartDefinition left_leg = bone8.addOrReplaceChild("left_leg",
                CubeListBuilder.create().texOffs(96, 104).addBox(-2.3572F, -1.8483F, -3.0119F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0F, 1.0F, 0.0F, 1.9198F, -0.3747F, -0.2291F));
        PartDefinition LowerLeg2 = left_leg.addOrReplaceChild("LowerLeg2",
                CubeListBuilder.create().texOffs(72, 106).addBox(4.0F, 1.0F, 12.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 108)
                        .addBox(5.0F, 1.0F, 13.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.3572F, -3.8483F, 1.9881F, -1.6581F, 0.2182F, 0.0F));
        PartDefinition LowerLeg3 = left_leg.addOrReplaceChild("LowerLeg3",
                CubeListBuilder.create().texOffs(93, 92).addBox(3.0F, 14.0F, 9.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-12.3572F, -0.8483F, 4.9881F, -1.911F, 0.1033F, -0.4294F));
        PartDefinition Finger4 = LowerLeg3.addOrReplaceChild("Finger4",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -10.0F, 4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-6.0F, 26.0F, 13.0F, 0.0958F, -0.0491F, 2.4342F));
        PartDefinition Finger5 = LowerLeg3.addOrReplaceChild("Finger5",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, 23.0F, 20.0F, 0.8751F, -0.5742F, 2.3313F));
        PartDefinition Finger6 = LowerLeg3.addOrReplaceChild("Finger6",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(2.0F, 26.0F, 27.0F, 1.5246F, -0.8695F, 1.3977F));
        PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(9.0F, 6.0F, 8.0F));
        PartDefinition right_leg = bone7.addOrReplaceChild("right_leg",
                CubeListBuilder.create().texOffs(96, 104).addBox(-6.2094F, -15.0368F, -4.1659F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -1.2218F, 0.3747F, 0.2291F));
        PartDefinition LowerLeg = right_leg.addOrReplaceChild("LowerLeg",
                CubeListBuilder.create().texOffs(32, 106).addBox(-17.0F, -6.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 108)
                        .addBox(-16.0F, -6.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(13.7906F, -11.0368F, 8.8341F, -1.6581F, 0.2182F, 0.0F));
        PartDefinition LowerLeg4 = right_leg.addOrReplaceChild("LowerLeg4",
                CubeListBuilder.create().texOffs(93, 92).addBox(-18.0F, -6.0F, -4.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(14.7906F, -12.0368F, 9.8341F, -1.9007F, 0.1328F, -0.3427F));
        PartDefinition Finger = LowerLeg4.addOrReplaceChild("Finger",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -10.0F, 4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0F, -14.0F, -4.0F, 0.0F, 0.0F, -0.6545F));
        PartDefinition Finger2 = LowerLeg4.addOrReplaceChild("Finger2",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-12.0F, -13.0F, -12.0F, -0.843F, 0.7485F, -0.9394F));
        PartDefinition Finger3 = LowerLeg4.addOrReplaceChild("Finger3",
                CubeListBuilder.create().texOffs(0, 126).addBox(-23.0F, -4.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 119)
                        .addBox(-24.0F, -11.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-19.0F, -9.0F, -12.0F, -1.7524F, 0.981F, -2.0753F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bone10.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.bone7.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.bone9.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.bone8.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
    }
}
