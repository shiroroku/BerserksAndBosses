package crimsonspade.berserksandbosses.Client.EntityModels;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.FleshRaptor;
import crimsonspade.berserksandbosses.Entity.Springlock;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FleshRaptorModel<T extends FleshRaptor> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in
    // the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(BerserksAndBosses.MODID, "flesh_raptor"), "main");
    public final ModelPart Head;
    public final ModelPart Neck;
    public final ModelPart body;
    public final ModelPart bone6;
    public final ModelPart bone5;
    public final ModelPart bone4;
    public final ModelPart bone3;
    public final ModelPart Tail;

    public FleshRaptorModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.Neck = root.getChild("Neck");
        this.body = root.getChild("body");
        this.bone6 = root.getChild("bone6");
        this.bone5 = root.getChild("bone5");
        this.bone4 = root.getChild("bone4");
        this.bone3 = root.getChild("bone3");
        this.Tail = root.getChild("Tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Head = partdefinition.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -5.0F, -10.0F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 14)
                        .addBox(-3.0F, -6.0F, -11.0F, 7.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(124, 124)
                        .addBox(0.0F, -8.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 124)
                        .addBox(0.0F, -8.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 124)
                        .addBox(0.0F, -8.0F, -8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(0.0F, -9.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(0.0F, -9.0F, -5.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(0.0F, -9.0F, -8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, -10.0F));
        PartDefinition HeadSpikesLeft = Head.addOrReplaceChild("HeadSpikesLeft", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-14.0F, 20.0F, 12.0F, 0.0F, 0.0F, 0.5236F));
        PartDefinition Spike25 = HeadSpikesLeft.addOrReplaceChild(
                "Spike25", CubeListBuilder.create().texOffs(124, 124).addBox(0.0F, -32.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(122, 125).addBox(0.0F, -33.0F, -13.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition Spike26 = HeadSpikesLeft.addOrReplaceChild(
                "Spike26", CubeListBuilder.create().texOffs(124, 124).addBox(0.0F, -32.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(122, 125).addBox(0.0F, -33.0F, -13.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, -3.0F));
        PartDefinition Spike27 = HeadSpikesLeft.addOrReplaceChild(
                "Spike27", CubeListBuilder.create().texOffs(124, 124).addBox(0.0F, -32.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(122, 125).addBox(0.0F, -33.0F, -13.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, -6.0F));
        PartDefinition HeadSpikesright = Head.addOrReplaceChild("HeadSpikesright", CubeListBuilder.create(),
                PartPose.offsetAndRotation(13.0F, 21.0F, 12.0F, 0.0F, 0.0F, -0.48F));
        PartDefinition Spike28 = HeadSpikesright.addOrReplaceChild(
                "Spike28", CubeListBuilder.create().texOffs(124, 124).addBox(0.0F, -32.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(122, 125).addBox(0.0F, -33.0F, -13.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition Spike29 = HeadSpikesright.addOrReplaceChild(
                "Spike29", CubeListBuilder.create().texOffs(124, 124).addBox(0.0F, -32.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(122, 125).addBox(0.0F, -33.0F, -13.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, -3.0F));
        PartDefinition Spike30 = HeadSpikesright.addOrReplaceChild(
                "Spike30", CubeListBuilder.create().texOffs(124, 124).addBox(0.0F, -32.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(122, 125).addBox(0.0F, -33.0F, -13.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, -6.0F));
        PartDefinition Neck = partdefinition.addOrReplaceChild("Neck",
                CubeListBuilder.create().texOffs(0, 106).addBox(-1.0F, -27.0F, -13.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(124, 118)
                        .addBox(0.0F, -27.0F, -12.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(0.0F, -26.0F, -10.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(0.0F, -23.0F, -10.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(0.0F, -23.0F, -8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125).addBox(0.0F, -26.0F, -8.0F, 1.0F,
                                2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 11.0F, 15.0F, 0.7418F, 0.0F, 0.0F));
        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 31).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(92, 104)
                        .addBox(-5.0F, -9.0F, -6.0F, 10.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(4.0F, -9.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(4.0F, -9.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(-5.0F, -9.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(-5.0F, -6.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(-5.0F, -3.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(-5.0F, 0.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(-5.0F, 3.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(-5.0F, 6.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(4.0F, -6.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(4.0F, -3.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(4.0F, 0.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(4.0F, 3.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 125)
                        .addBox(4.0F, 6.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-5.0F, -9.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(4.0F, -6.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-5.0F, -6.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(4.0F, -3.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-5.0F, -3.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(4.0F, 0.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-5.0F, 0.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(4.0F, 3.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-5.0F, 3.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(4.0F, 6.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125).addBox(-5.0F, 6.0F, 3.0F, 1.0F, 1.0F,
                                2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 3.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition RotatedSpikesonleft = body.addOrReplaceChild("RotatedSpikesonleft", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-1.0F, 0.0F, 3.0F, 0.0F, 0.6109F, 0.0F));
        PartDefinition Spike1 = RotatedSpikesonleft.addOrReplaceChild(
                "Spike1", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -8.0F, 0.0F));
        PartDefinition Spike2 = RotatedSpikesonleft.addOrReplaceChild(
                "Spike2", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -5.0F, 0.0F));
        PartDefinition Spike3 = RotatedSpikesonleft.addOrReplaceChild(
                "Spike3", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -2.0F, 0.0F));
        PartDefinition Spike4 = RotatedSpikesonleft
                .addOrReplaceChild("Spike4",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 1.0F, 0.0F));
        PartDefinition Spike5 = RotatedSpikesonleft
                .addOrReplaceChild("Spike5",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition Spike6 = RotatedSpikesonleft
                .addOrReplaceChild("Spike6",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition RotatedSpikesonleft2 = body.addOrReplaceChild("RotatedSpikesonleft2", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-5.0F, 0.0F, 3.0F, 0.0F, 0.6109F, 0.0F));
        PartDefinition Spike13 = RotatedSpikesonleft2.addOrReplaceChild(
                "Spike13", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -8.0F, 0.0F));
        PartDefinition Spike14 = RotatedSpikesonleft2.addOrReplaceChild(
                "Spike14", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -5.0F, 0.0F));
        PartDefinition Spike15 = RotatedSpikesonleft2.addOrReplaceChild(
                "Spike15", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -2.0F, 0.0F));
        PartDefinition Spike16 = RotatedSpikesonleft2
                .addOrReplaceChild("Spike16",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 1.0F, 0.0F));
        PartDefinition Spike17 = RotatedSpikesonleft2
                .addOrReplaceChild("Spike17",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition Spike18 = RotatedSpikesonleft2
                .addOrReplaceChild("Spike18",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition RotatedSpikesonright = body.addOrReplaceChild("RotatedSpikesonright", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-8.0F, 0.0F, -3.0F, 0.0F, -0.6545F, 0.0F));
        PartDefinition Spike7 = RotatedSpikesonright.addOrReplaceChild(
                "Spike7", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -8.0F, 0.0F));
        PartDefinition Spike8 = RotatedSpikesonright.addOrReplaceChild(
                "Spike8", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -5.0F, 0.0F));
        PartDefinition Spike9 = RotatedSpikesonright.addOrReplaceChild(
                "Spike9", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -2.0F, 0.0F));
        PartDefinition Spike10 = RotatedSpikesonright
                .addOrReplaceChild("Spike10",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 1.0F, 0.0F));
        PartDefinition Spike11 = RotatedSpikesonright
                .addOrReplaceChild("Spike11",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition Spike12 = RotatedSpikesonright
                .addOrReplaceChild("Spike12",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition RotatedSpikesonright2 = body.addOrReplaceChild("RotatedSpikesonright2", CubeListBuilder.create(),
                PartPose.offsetAndRotation(-4.0F, 0.0F, -3.0F, 0.0F, -0.6545F, 0.0F));
        PartDefinition Spike19 = RotatedSpikesonright2.addOrReplaceChild(
                "Spike19", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -8.0F, 0.0F));
        PartDefinition Spike20 = RotatedSpikesonright2.addOrReplaceChild(
                "Spike20", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -5.0F, 0.0F));
        PartDefinition Spike21 = RotatedSpikesonright2.addOrReplaceChild(
                "Spike21", CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -2.0F, 0.0F));
        PartDefinition Spike22 = RotatedSpikesonright2
                .addOrReplaceChild("Spike22",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 1.0F, 0.0F));
        PartDefinition Spike23 = RotatedSpikesonright2
                .addOrReplaceChild("Spike23",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 4.0F, 0.0F));
        PartDefinition Spike24 = RotatedSpikesonright2
                .addOrReplaceChild("Spike24",
                        CubeListBuilder.create().texOffs(122, 125).addBox(5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                                .texOffs(124, 125).addBox(5.0F, -1.0F, 5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                        PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6",
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(6.0F, 4.3434F, -6.221F));
        PartDefinition Arm = bone6.addOrReplaceChild("Arm",
                CubeListBuilder.create().texOffs(30, 17).addBox(0.0F, -3.6566F, -2.221F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(116, 0)
                        .addBox(0.0F, -7.6566F, -5.221F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(96, 121)
                        .addBox(0.0F, -10.6566F, -3.221F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(122, 119)
                        .addBox(2.0F, -10.6566F, -3.221F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(111, 118)
                        .addBox(1.0F, -10.6566F, -5.221F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.3434F, 1.221F, 1.7453F, 0.0F, 0.0F));
        PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-6.0F, 4.3434F, -5.221F));
        PartDefinition Arm2 = bone5.addOrReplaceChild("Arm2",
                CubeListBuilder.create().texOffs(112, 0).addBox(-4.0F, -3.6566F, -2.221F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(116, 0)
                        .addBox(-3.0F, -7.6566F, -5.221F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(94, 122)
                        .addBox(-3.0F, -10.6566F, -3.221F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 107)
                        .addBox(-1.0F, -10.6566F, -3.221F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(124, 124)
                        .addBox(-2.0F, -10.6566F, -5.221F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.3434F, 0.221F, 1.7453F, 0.0F, 0.0F));
        PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-6.0F, 5.3434F, 8.779F));
        PartDefinition leg1 = bone4.addOrReplaceChild("leg1",
                CubeListBuilder.create().texOffs(100, 0).addBox(-19.0F, -3.3772F, -2.0465F, 7.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
                        .texOffs(98, 0).addBox(-18.0F, 2.6228F, 4.9535F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(12.0F, 0.6566F, -1.779F, -0.8727F, 0.0F, 0.0F));
        PartDefinition bone = leg1.addOrReplaceChild("bone",
                CubeListBuilder.create().texOffs(104, 117).addBox(-13.0F, 15.0F, 23.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 117)
                        .addBox(-11.0F, 15.0F, 23.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 117)
                        .addBox(-9.0F, 15.0F, 23.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 117)
                        .addBox(-7.0F, 15.0F, 19.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 117)
                        .addBox(-7.0F, 15.0F, 20.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 0).addBox(-13.0F, 4.0F, 21.0F, 7.0F,
                                11.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-6.0F, -11.3772F, 1.9535F, -0.6981F, 0.0F, 0.0F));
        PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3",
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(6.0F, 5.3434F, 8.779F));
        PartDefinition leg2 = bone3.addOrReplaceChild("leg2",
                CubeListBuilder.create().texOffs(100, 0).addBox(12.0F, -1.2024F, -2.5661F, 7.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
                        .texOffs(98, 0).addBox(13.0F, 4.7976F, 4.4339F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-12.0F, -0.3434F, 0.221F, -0.8727F, 0.0F, 0.0F));
        PartDefinition bone2 = leg2.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(108, 0).addBox(-13.0F, 4.0F, 21.0F, 7.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(104, 117)
                        .addBox(-7.0F, 15.0F, 23.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 117)
                        .addBox(-9.0F, 15.0F, 23.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 117)
                        .addBox(-11.0F, 15.0F, 23.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 117)
                        .addBox(-13.0F, 15.0F, 19.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 117)
                        .addBox(-13.0F, 15.0F, 20.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(25.0F, -9.2024F, 1.4339F, -0.6981F, 0.0F, 0.0F));
        PartDefinition Tail = partdefinition.addOrReplaceChild("Tail",
                CubeListBuilder.create().texOffs(102, 0).addBox(-5.0F, -2.0F, 0.0F, 10.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(106, 0)
                        .addBox(-4.0F, -2.0F, 3.0F, 8.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(110, 0)
                        .addBox(-3.0F, -2.0F, 6.0F, 6.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(114, 0)
                        .addBox(-2.0F, -2.0F, 9.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(118, 0)
                        .addBox(-1.0F, -2.0F, 12.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(120, 0)
                        .addBox(-1.0F, -2.0F, 15.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(118, 0)
                        .addBox(-1.0F, -2.0F, 17.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(116, 122)
                        .addBox(1.0F, -2.0F, 19.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(116, 122)
                        .addBox(-1.0F, -3.0F, 19.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(116, 122)
                        .addBox(-2.0F, -1.0F, 19.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(116, 122)
                        .addBox(0.0F, 0.0F, 19.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-1.0F, -4.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(120, 125)
                        .addBox(-1.0F, -5.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(120, 125)
                        .addBox(-1.0F, -5.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(120, 125)
                        .addBox(-1.0F, -5.0F, 6.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(120, 125)
                        .addBox(-1.0F, -5.0F, 9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(120, 125)
                        .addBox(-1.0F, -5.0F, 12.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(120, 125)
                        .addBox(-1.0F, -5.0F, 15.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-1.0F, -4.0F, 3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-1.0F, -4.0F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-1.0F, -4.0F, 9.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-1.0F, -4.0F, 12.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(122, 125)
                        .addBox(-1.0F, -4.0F, 15.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 4.0F, 11.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
                               float blue, float alpha) {
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Head.xRot = headPitch / (180F / (float) Math.PI);
        this.bone3.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
        this.bone5.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
        this.bone4.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
        this.bone6.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
    }
}
