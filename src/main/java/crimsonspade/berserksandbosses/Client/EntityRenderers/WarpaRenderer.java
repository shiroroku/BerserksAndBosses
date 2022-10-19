package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.CrimpaModel;
import crimsonspade.berserksandbosses.Client.EntityModels.WarpaModel;
import crimsonspade.berserksandbosses.Entity.Crimpa;
import crimsonspade.berserksandbosses.Entity.Warpa;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WarpaRenderer extends MobRenderer<Warpa, WarpaModel<Warpa>> {
    public static final ResourceLocation WARPA_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/warpa.png");

    public WarpaRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new WarpaModel<>(p_174304_.bakeLayer(WarpaModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Warpa pEntity) {
        return WARPA_LOCATION;
    }
}
