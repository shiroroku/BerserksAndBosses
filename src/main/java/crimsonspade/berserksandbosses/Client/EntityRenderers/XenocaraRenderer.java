package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.NormpaModel;
import crimsonspade.berserksandbosses.Client.EntityModels.XenocaraModel;
import crimsonspade.berserksandbosses.Entity.Blizzpa;
import crimsonspade.berserksandbosses.Entity.Xenocara;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class XenocaraRenderer extends MobRenderer<Xenocara, XenocaraModel<Xenocara>> {
    public static final ResourceLocation XENOCARA_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/xenocara.png");

    public XenocaraRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new XenocaraModel<>(p_174304_.bakeLayer(XenocaraModel.LAYER_LOCATION)), 0.3F);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/xenocara_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(Xenocara pEntity) {
        return XENOCARA_LOCATION;
    }
}
