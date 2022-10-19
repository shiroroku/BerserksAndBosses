package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.Crimpa;
import crimsonspade.berserksandbosses.Entity.Warpa;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WarpaModel<T extends Warpa> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "warpa"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;

    public WarpaModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 40)
                        .addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 70)
                        .addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)),
                PartPose.offset(0.0F, -11.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, -6.0F, -3.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -13.0F, -1.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(114, 0).addBox(-2.3075F, -0.8657F, -2.0F, 4.0F, 18.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(60, 58).addBox(-4.6541F, 11.4681F, -26.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(60, 58).addBox(-4.6541F, 10.4681F, -22.0F, 8.0F, 9.0F, 20.0F, new CubeDeformation(0.0F))
                        .texOffs(60, 58).addBox(-4.6541F, 13.4681F, -26.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(60, 58).addBox(0.3459F, 9.4681F, -25.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(60, 58).addBox(-4.6541F, 17.4681F, -26.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(60, 58).addBox(-4.6541F, 15.4681F, -26.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-8.0F, -12.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
                CubeListBuilder.create().texOffs(108, 0)
                        .addBox(-3.6541F, -0.5319F, -3.0F, 4.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(67, 72)
                        .addBox(-4.3075F, 13.1343F, -9.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(60, 58)
                        .addBox(0.6925F, 13.1343F, -12.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(60, 58)
                        .addBox(0.6925F, 15.1343F, -12.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(60, 58)
                        .addBox(0.6925F, 17.1343F, -12.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(60, 58)
                        .addBox(-2.3075F, 12.1343F, -11.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(9.0F, -12.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
                CubeListBuilder.create().texOffs(37, 0)
                        .addBox(-11.5F, 0.0F, -3.0F, 6.0F, 25.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 109)
                        .addBox(-12.5F, 13.0F, -4.0F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0F, -1.0F, 0.0F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
                CubeListBuilder.create().texOffs(60, 0)
                        .addBox(6.5F, 0.0F, -3.0F, 6.0F, 25.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 109)
                        .addBox(5.5F, 13.0F, -4.0F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-5.0F, -1.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
        this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
    }
}
