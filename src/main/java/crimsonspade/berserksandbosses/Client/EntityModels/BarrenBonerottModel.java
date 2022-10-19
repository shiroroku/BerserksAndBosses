package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.BarrenBonerott;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BarrenBonerottModel<T extends BarrenBonerott> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "barren_bonerott"), "main");
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public BarrenBonerottModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 0).addBox(-4.7654F, -7.5932F, -7.4998F, 8.0F, 8.0F, 8.0F,
                        new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.4363F, 0.0F, -0.3927F));

        PartDefinition headwear = head.addOrReplaceChild("headwear",
                CubeListBuilder.create().texOffs(0, 44).addBox(-4.0F, -14.0F, -4.0F, 8.0F, 10.0F, 10.0F,
                        new CubeDeformation(0.5F)),
                PartPose.offsetAndRotation(-0.7654F, 5.4068F, -1.4998F, 0.3054F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(16, 16)
                        .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(10, 17)
                        .addBox(0.0F, 0.0F, 2.0F, 0.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

        PartDefinition Neck = body.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(36, 55).addBox(-1.0F, -31.0F, 0.0F, 2.0F, 7.0F, 2.0F,
                        new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 21.0F, 15.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(5.0F, 0.0F, 0.0F));

        PartDefinition bone = left_arm.addOrReplaceChild("bone",
                CubeListBuilder.create().texOffs(40, 14).mirror()
                        .addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.9599F, -0.3491F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-5.0F, 0.0F, 0.0F));

        PartDefinition bone2 = right_arm.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(40, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F,
                        new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.2182F, 0.0F, 0.2182F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-1.0F, -4.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(2.0F, 12.0F, 6.1F));

        PartDefinition bone3 = left_leg.addOrReplaceChild("bone3",
                CubeListBuilder.create().texOffs(40, 14).mirror()
                        .addBox(-1.0F, -4.0F, -1.1F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 17)
                        .addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-2.0F, 9.0F, 6.1F));

        PartDefinition bone4 = right_leg.addOrReplaceChild("bone4",
                CubeListBuilder.create().texOffs(40, 14).addBox(-1.0F, -4.0F, -1.1F, 2.0F, 16.0F, 2.0F,
                        new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.1745F, 0.2182F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
        this.right_arm.xRot = Mth.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount;
        this.left_leg.xRot = Mth.cos(limbSwing * 0.5f) * 0.8F * limbSwingAmount;
    }
}
