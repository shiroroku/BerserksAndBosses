package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BarrenBonerottModel;
import crimsonspade.berserksandbosses.Entity.BarrenBonerott;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class BarrenBonerottRenderer extends MobRenderer<BarrenBonerott, BarrenBonerottModel<BarrenBonerott>> {
    public static final ResourceLocation BARRENBONEROTT_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/barren_bonerott.png");

    public BarrenBonerottRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new BarrenBonerottModel<>(p_174304_.bakeLayer(BarrenBonerottModel.LAYER_LOCATION)), 0.3F);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/barren_bonerott_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(BarrenBonerott pEntity) {
        return BARRENBONEROTT_LOCATION;
    }
}
