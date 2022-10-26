package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.SpringlockModel;
import crimsonspade.berserksandbosses.Client.EntityModels.TectonicColossus1Model;
import crimsonspade.berserksandbosses.Entity.Springlock;
import crimsonspade.berserksandbosses.Entity.TectonicColossus1;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TectonicColossus1Renderer extends MobRenderer<TectonicColossus1, TectonicColossus1Model<TectonicColossus1>> {
    public static final ResourceLocation COLOSSUS_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/tectonic_colossus_1.png");

    public TectonicColossus1Renderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new TectonicColossus1Model<>(p_174304_.bakeLayer(TectonicColossus1Model.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(TectonicColossus1 pEntity) {
        return COLOSSUS_LOCATION;
    }
}
