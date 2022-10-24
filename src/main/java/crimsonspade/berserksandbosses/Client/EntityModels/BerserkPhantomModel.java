package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.BerserkPhantom;
import crimsonspade.berserksandbosses.Entity.Bloodumbra;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BerserkPhantomModel<T extends BerserkPhantom> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "berserk_phantom"), "main");
    public final ModelPart Head;
    public final ModelPart body;
    public final ModelPart left_wing;
    public final ModelPart left_wing_tip;
    public final ModelPart right_wing;
    public final ModelPart right_wing_tip;

    public BerserkPhantomModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.body = root.getChild("body");
        this.left_wing = root.getChild("left_wing");
        this.left_wing_tip = root.getChild("left_wing_tip");
        this.right_wing = root.getChild("right_wing");
        this.right_wing_tip = root.getChild("right_wing_tip");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, -8.0F));
        PartDefinition Jaw1 = Head.addOrReplaceChild("Jaw1",
                CubeListBuilder.create().texOffs(168, 228).addBox(-14.0F, -17.0F, -24.0F, 28.0F, 12.0F, 16.0F, new CubeDeformation(0.0F))
                        .texOffs(440, 17).addBox(-14.0F, -6.0F, -24.0F, 28.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 8.0F, 8.0F, -0.0436F, 0.0F, 0.0F));
        PartDefinition Jaw2 = Head.addOrReplaceChild("Jaw2",
                CubeListBuilder.create().texOffs(0, 232).addBox(-14.0F, -10.0F, -24.0F, 28.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
                        .texOffs(440, 17).addBox(-14.0F, -9.0F, -24.0F, 28.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 11.0F, 10.0F, 0.1745F, 0.0F, 0.0F));
        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, 0.0F, -16.0F, 24.0F, 24.0F, 64.0F, new CubeDeformation(0.0F)).texOffs(344, 237)
                        .addBox(-11.0F, 1.0F, -15.0F, 22.0F, 22.0F, 62.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-1.0F, -6.0F, -10.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-1.0F, -6.0F, 10.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-1.0F, -6.0F, 30.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 4.0F, 8.0F));
        PartDefinition tail1 = body.addOrReplaceChild("tail1",
                CubeListBuilder.create().texOffs(113, 0).addBox(-10.0F, -2.0F, 0.0F, 20.0F, 20.0F, 40.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 6.0F, 48.0F));
        PartDefinition tail2 = tail1.addOrReplaceChild("tail2",
                CubeListBuilder.create().texOffs(0, 89).addBox(-8.0F, -3.0F, 0.0F, 16.0F, 16.0F, 37.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 3.0F, 40.0F));
        PartDefinition tail3 = tail2.addOrReplaceChild("tail3",
                CubeListBuilder.create().texOffs(155, 172).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 41.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 37.0F));
        PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing",
                CubeListBuilder.create().texOffs(384, 0).mirror().addBox(0.0F, -4.0F, -4.0F, 56.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                        .mirror(false).texOffs(344, 456).mirror().addBox(0.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, new CubeDeformation(0.0F))
                        .mirror(false),
                PartPose.offset(12.0F, 15.0F, 2.0F));
        PartDefinition left_wing_tip = partdefinition.addOrReplaceChild("left_wing_tip",
                CubeListBuilder.create().texOffs(392, 0).mirror().addBox(0.0F, -2.0F, -2.0F, 56.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                        .mirror(false).texOffs(-56, 456).mirror().addBox(0.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, new CubeDeformation(0.0F))
                        .mirror(false),
                PartPose.offsetAndRotation(55.0F, 15.0F, 2.0F, 0.0F, 0.2182F, 0.0F));
        PartDefinition right_wing = partdefinition.addOrReplaceChild(
                "right_wing", CubeListBuilder.create().texOffs(344, 456).addBox(-56.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, new CubeDeformation(0.0F))
                        .texOffs(384, 0).addBox(-56.0F, -4.0F, -4.0F, 56.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-12.0F, 14.0F, 2.0F));
        PartDefinition right_wing_tip = partdefinition.addOrReplaceChild("right_wing_tip",
                CubeListBuilder.create().texOffs(-56, 456).addBox(-56.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, new CubeDeformation(0.0F)).texOffs(392, 0)
                        .addBox(-56.0F, -2.0F, -2.0F, 56.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-55.0F, 14.0F, 2.0F, 0.0F, -0.2182F, 0.0F));
        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_wing_tip.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_wing_tip.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Head.xRot = headPitch / (180F / (float) Math.PI);
    }
}
