package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BarrenBonerottModel;
import crimsonspade.berserksandbosses.Client.EntityModels.BloodumbraModel;
import crimsonspade.berserksandbosses.Entity.BarrenBonerott;
import crimsonspade.berserksandbosses.Entity.Bloodumbra;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class BloodumbraRenderer extends MobRenderer<Bloodumbra, BloodumbraModel<Bloodumbra>> {
    public static final ResourceLocation BLOODUMBRA_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/bloodumbra.png");

    public BloodumbraRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new BloodumbraModel(p_174304_.bakeLayer(BloodumbraModel.LAYER_LOCATION)), 0.3F);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/bloodumbra_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(Bloodumbra pEntity) {
        return BLOODUMBRA_LOCATION;
    }
}
