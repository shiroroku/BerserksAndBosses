package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.NormpaModel;
import crimsonspade.berserksandbosses.Client.EntityModels.WarpaModel;
import crimsonspade.berserksandbosses.Entity.Normpa;
import crimsonspade.berserksandbosses.Entity.Warpa;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class NormpaRenderer extends MobRenderer<Normpa, NormpaModel<Normpa>> {
    public static final ResourceLocation NORMPA_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/normpa.png");

    public NormpaRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new NormpaModel<>(p_174304_.bakeLayer(NormpaModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Normpa pEntity) {
        return NORMPA_LOCATION;
    }
}
