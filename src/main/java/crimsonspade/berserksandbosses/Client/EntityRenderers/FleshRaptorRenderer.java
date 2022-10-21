package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.FleshRaptorModel;
import crimsonspade.berserksandbosses.Client.EntityModels.NormpaModel;
import crimsonspade.berserksandbosses.Entity.Blizzpa;
import crimsonspade.berserksandbosses.Entity.FleshRaptor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class FleshRaptorRenderer extends MobRenderer<FleshRaptor, FleshRaptorModel<FleshRaptor>> {
    public static final ResourceLocation FLESH_RAPTOR_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/flesh_raptor.png");

    public FleshRaptorRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new FleshRaptorModel<>(p_174304_.bakeLayer(FleshRaptorModel.LAYER_LOCATION)), 0.3F);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/flesh_raptor_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(FleshRaptor pEntity) {
        return FLESH_RAPTOR_LOCATION;
    }
}
