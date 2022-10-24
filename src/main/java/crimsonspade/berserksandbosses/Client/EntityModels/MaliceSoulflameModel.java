package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.BerserkPhantom;
import crimsonspade.berserksandbosses.Entity.MaliceSoulflame;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MaliceSoulflameModel<T extends MaliceSoulflame> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "malice_soulflame"), "main");
    public final ModelPart body;
    public final ModelPart body2;
    public final ModelPart body3;
    public final ModelPart left_wing;
    public final ModelPart right_wing;
    public final ModelPart left_wing2;
    public final ModelPart right_wing2;

    public MaliceSoulflameModel(ModelPart root) {
        this.body = root.getChild("body");
        this.body2 = root.getChild("body2");
        this.body3 = root.getChild("body3");
        this.left_wing = root.getChild("left_wing");
        this.right_wing = root.getChild("right_wing");
        this.left_wing2 = root.getChild("left_wing2");
        this.right_wing2 = root.getChild("right_wing2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 19.0F, -1.0F));
        PartDefinition body2 = partdefinition.addOrReplaceChild("body2",
                CubeListBuilder.create().texOffs(0, 10).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 19.0F, -1.0F));
        PartDefinition body3 = partdefinition.addOrReplaceChild("body3",
                CubeListBuilder.create().texOffs(0, 22).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 19.0F, -1.0F));
        PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing",
                CubeListBuilder.create().texOffs(16, 14).addBox(0.0F, 1.0F, 0.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.5F, 16.0F, 1.0F, 0.2182F, 0.0873F, 0.0F));
        PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing",
                CubeListBuilder.create().texOffs(16, 14).addBox(0.0F, 1.0F, 0.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-0.5F, 16.0F, 1.0F, 0.2182F, -0.0873F, 0.0F));
        PartDefinition left_wing2 = partdefinition.addOrReplaceChild("left_wing2",
                CubeListBuilder.create().texOffs(16, 14).addBox(0.0F, 1.0F, 0.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(1.5F, 18.0F, 1.0F, 0.0F, 0.2182F, 0.0F));
        PartDefinition right_wing2 = partdefinition.addOrReplaceChild("right_wing2",
                CubeListBuilder.create().texOffs(16, 14).addBox(0.0F, 1.0F, 0.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.5F, 18.0F, 1.0F, 0.0F, -0.2182F, 0.0F));
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_wing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_wing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.right_wing2.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.right_wing.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.left_wing.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.body2.yRot = ageInTicks;
        this.body3.zRot = ageInTicks;
        this.body.xRot = ageInTicks;
        this.left_wing2.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
    }
}
