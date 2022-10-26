package crimsonspade.berserksandbosses.Client.EntityRenderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.TectonicColossus2Model;
import crimsonspade.berserksandbosses.Entity.TectonicColossus2;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TectonicColossus2Renderer extends GeoEntityRenderer<TectonicColossus2> {
    public TectonicColossus2Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TectonicColossus2Model());
        this.shadowRadius = 1;
    }

    @Override
    public ResourceLocation getTextureLocation(TectonicColossus2 instance) {
        return new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/tectonic_colossus_2.png");
    }

    @Override
    protected float getDeathMaxRotation(TectonicColossus2 entity) {
        return 0f;
    }

    @Override
    public void render(GeoModel model, TectonicColossus2 animatable, float partialTicks, RenderType type, PoseStack matrixStackIn,
                       @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                       int packedOverlayIn, float red, float green, float blue, float alpha) {
        renderEarly(animatable, matrixStackIn, partialTicks, renderTypeBuffer, vertexBuilder, packedLightIn,
                packedOverlayIn, red, green, blue, alpha);

        if (renderTypeBuffer != null) {
            vertexBuilder = renderTypeBuffer.getBuffer(type);
        }
        //Makes it that the entity is only rendered with a red overlay when hurt but not on death.
        renderRecursively(model.topLevelBones.get(0), matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.pack(0,
                OverlayTexture.v(animatable.hurtTime > 0)), red, green, blue, alpha);
    }
}
