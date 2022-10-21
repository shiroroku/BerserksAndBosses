package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.NetherWidow;
import crimsonspade.berserksandbosses.Entity.Xenocara;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class NetherWidowModel<T extends NetherWidow> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "nether_widow"), "main");
    public final ModelPart head;
    public final ModelPart neck;
    public final ModelPart body;
    public final ModelPart leg1;
    public final ModelPart leg2;
    public final ModelPart leg3;
    public final ModelPart leg4;
    public final ModelPart leg5;
    public final ModelPart leg6;
    public final ModelPart leg7;
    public final ModelPart leg8;

    public NetherWidowModel(ModelPart root) {
        this.head = root.getChild("head");
        this.neck = root.getChild("neck");
        this.body = root.getChild("body");
        this.leg1 = root.getChild("leg1");
        this.leg2 = root.getChild("leg2");
        this.leg3 = root.getChild("leg3");
        this.leg4 = root.getChild("leg4");
        this.leg5 = root.getChild("leg5");
        this.leg6 = root.getChild("leg6");
        this.leg7 = root.getChild("leg7");
        this.leg8 = root.getChild("leg8");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(32, 4).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 15.0F, -6.0F));
        PartDefinition neck = partdefinition
                .addOrReplaceChild("neck",
                        CubeListBuilder.create().texOffs(5, 11).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
                                .texOffs(0, 24).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 15.0F, 0.0F));
        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 33).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(9, 20)
                        .addBox(-5.0F, -5.0F, -8.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 20)
                        .addBox(-5.0F, -5.0F, 13.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 20)
                        .addBox(-2.0F, -1.0F, 15.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 20).addBox(1.0F, -1.0F, 15.0F, 1.0F,
                                2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 11.0F, 13.0F, 0.5236F, 0.0F, 0.0F));
        PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-5.0F, 15.0F, 6.0F));
        PartDefinition bone = leg1.addOrReplaceChild("bone",
                CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.3054F, 0.3054F));
        PartDefinition bone16 = bone.addOrReplaceChild("bone16",
                CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.4399F));
        PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(5.0F, 15.0F, 6.0F));
        PartDefinition bone2 = leg2.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, -0.3054F, -0.3054F));
        PartDefinition bone15 = bone2.addOrReplaceChild("bone15",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.3526F));
        PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-5.0F, 15.0F, 3.0F));
        PartDefinition bone3 = leg3.addOrReplaceChild("bone3",
                CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.3054F));
        PartDefinition bone14 = bone3.addOrReplaceChild("bone14",
                CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.4399F));
        PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(5.0F, 15.0F, 3.0F));
        PartDefinition bone4 = leg4.addOrReplaceChild("bone4",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, -0.1309F, -0.3054F));
        PartDefinition bone13 = bone4.addOrReplaceChild("bone13",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.3526F));
        PartDefinition leg5 = partdefinition.addOrReplaceChild("leg5",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-5.0F, 15.0F, 0.0F));
        PartDefinition bone5 = leg5.addOrReplaceChild("bone5",
                CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.0873F, 0.3054F));
        PartDefinition bone12 = bone5.addOrReplaceChild("bone12",
                CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.4399F));
        PartDefinition leg6 = partdefinition.addOrReplaceChild("leg6",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(5.0F, 15.0F, 0.0F));
        PartDefinition bone6 = leg6.addOrReplaceChild("bone6",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.1309F, -0.3054F));
        PartDefinition bone11 = bone6.addOrReplaceChild("bone11",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.3526F));
        PartDefinition leg7 = partdefinition.addOrReplaceChild("leg7",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-5.0F, 15.0F, -3.0F));
        PartDefinition bone7 = leg7.addOrReplaceChild("bone7",
                CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.3054F, 0.3054F));
        PartDefinition bone10 = bone7.addOrReplaceChild("bone10",
                CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.4399F));
        PartDefinition leg8 = partdefinition.addOrReplaceChild("leg8",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(5.0F, 15.0F, -3.0F));
        PartDefinition bone8 = leg8.addOrReplaceChild("bone8",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.3054F, -0.3054F));
        PartDefinition bone9 = bone8.addOrReplaceChild("bone9",
                CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.3526F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leg8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
        this.leg1.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.leg4.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        this.leg5.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.leg2.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.leg3.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.leg8.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.leg6.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.leg7.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
    }
}
