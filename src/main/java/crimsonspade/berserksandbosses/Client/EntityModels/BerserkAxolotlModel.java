package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.BerserkAxolotl;
import crimsonspade.berserksandbosses.Entity.Chainlock;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BerserkAxolotlModel<T extends BerserkAxolotl> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "berserk_axolotl"), "main");
    public final ModelPart Head;
    public final ModelPart body;
    public final ModelPart tail;
    public final ModelPart Leg1;
    public final ModelPart Leg2;
    public final ModelPart Leg3;
    public final ModelPart Leg4;

    public BerserkAxolotlModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.body = root.getChild("body");
        this.tail = root.getChild("tail");
        this.Leg1 = root.getChild("Leg1");
        this.Leg2 = root.getChild("Leg2");
        this.Leg3 = root.getChild("Leg3");
        this.Leg4 = root.getChild("Leg4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, -25.0F));
        PartDefinition UpperJaw = Head.addOrReplaceChild("UpperJaw",
                CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -20.0F, -52.0F, 38.0F, 16.0F, 28.0F, new CubeDeformation(0.0F)).texOffs(436, 28)
                        .addBox(-19.0F, -30.0F, -26.0F, 38.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(-28, 478).addBox(-19.0F, -7.0F, -52.0F,
                                38.0F, 0.0F, 28.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 12.0F, 24.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition LowerJaw = Head.addOrReplaceChild("LowerJaw",
                CubeListBuilder.create().texOffs(0, 283).addBox(-19.0F, -7.0F, -52.0F, 38.0F, 7.0F, 28.0F, new CubeDeformation(0.0F))
                        .texOffs(-28, 478).addBox(-19.0F, -4.0F, -52.0F, 38.0F, 0.0F, 28.0F, new CubeDeformation(0.0F)).texOffs(0, 486)
                        .addBox(-19.0F, -10.0F, -27.0F, 38.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(482, 0)
                        .addBox(-34.0F, -28.0F, -26.0F, 15.0F, 28.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(452, 0)
                        .addBox(19.0F, -28.0F, -26.0F, 15.0F, 28.0F, 0.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 8.0F, 25.0F));
        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(324, 0).addBox(-16.0F, -11.0F, -28.0F, 32.0F, 17.0F, 48.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 460).addBox(0.0F, -17.0F, -26.0F, 0.0F, 6.0F, 46.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 11.0F, 4.0F));
        PartDefinition tail = partdefinition.addOrReplaceChild(
                "tail", CubeListBuilder.create().texOffs(415, 65).addBox(-12.0F, -9.0F, 1.0F, 24.0F, 15.0F, 24.0F, new CubeDeformation(0.0F))
                        .texOffs(92, 483).addBox(0.0F, -14.0F, 1.0F, 0.0F, 5.0F, 24.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 11.0F, 23.0F));
        PartDefinition bone2 = tail.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(428, 104).addBox(-9.0F, -12.0F, 21.0F, 18.0F, 12.0F, 24.0F, new CubeDeformation(0.0F))
                        .texOffs(140, 482).addBox(0.0F, -18.0F, 21.0F, 0.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 6.0F, 4.0F));
        PartDefinition bone3 = bone2.addOrReplaceChild("bone3",
                CubeListBuilder.create().texOffs(436, 140).addBox(-7.0F, -10.0F, 45.0F, 14.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
                        .texOffs(188, 482).addBox(0.0F, -16.0F, 45.0F, 0.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bone4 = bone3.addOrReplaceChild(
                "bone4", CubeListBuilder.create().texOffs(448, 175).addBox(-4.0F, -8.0F, 69.0F, 8.0F, 8.0F, 24.0F, new CubeDeformation(0.0F))
                        .texOffs(236, 452).addBox(0.0F, -13.0F, 69.0F, 0.0F, 13.0F, 47.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition Leg1 = partdefinition.addOrReplaceChild("Leg1",
                CubeListBuilder.create().texOffs(480, 497).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(-3.0F, 5.0F, -7.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(3.0F, 5.0F, -7.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(0.0F, 5.0F, -7.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-11.0F, 17.0F, -18.0F));
        PartDefinition Leg2 = partdefinition.addOrReplaceChild("Leg2",
                CubeListBuilder.create().texOffs(480, 497).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(-3.0F, 5.0F, -5.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(3.0F, 5.0F, -5.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(0.0F, 5.0F, -5.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(11.0F, 17.0F, -20.0F));
        PartDefinition Leg3 = partdefinition.addOrReplaceChild("Leg3",
                CubeListBuilder.create().texOffs(480, 497).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(-3.0F, 5.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(3.0F, 5.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(0.0F, 5.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(11.0F, 17.0F, 19.0F));
        PartDefinition Leg4 = partdefinition.addOrReplaceChild("Leg4",
                CubeListBuilder.create().texOffs(480, 497).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(-3.0F, 5.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(3.0F, 5.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(330, 507)
                        .addBox(0.0F, 5.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-11.0F, 17.0F, 19.0F));
        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.Leg3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Head.xRot = headPitch / (180F / (float) Math.PI);
        this.Leg4.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.Leg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}
