package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.ChainlockModel;
import crimsonspade.berserksandbosses.Client.EntityModels.DevolterModel;
import crimsonspade.berserksandbosses.Entity.Chainlock;
import crimsonspade.berserksandbosses.Entity.Devolter;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DevolterRenderer extends MobRenderer<Devolter, DevolterModel<Devolter>> {
    public static final ResourceLocation DEVOLTER_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/devolter.png");

    public DevolterRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new DevolterModel<>(p_174304_.bakeLayer(DevolterModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Devolter pEntity) {
        return DEVOLTER_LOCATION;
    }
}
