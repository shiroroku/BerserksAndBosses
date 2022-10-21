package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.NormpaModel;
import crimsonspade.berserksandbosses.Entity.Blizzpa;
import crimsonspade.berserksandbosses.Entity.Normpa;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlizzpaRenderer extends MobRenderer<Blizzpa, NormpaModel<Blizzpa>> {
    public static final ResourceLocation BLIZZPA_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/blizzpa.png");

    public BlizzpaRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new NormpaModel<>(p_174304_.bakeLayer(NormpaModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Blizzpa pEntity) {
        return BLIZZPA_LOCATION;
    }
}
