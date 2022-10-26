package crimsonspade.berserksandbosses.Client.EntityModels;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.TectonicColossus2;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TectonicColossus2Model extends AnimatedGeoModel<TectonicColossus2> {
    @Override
    public ResourceLocation getModelLocation(TectonicColossus2 object) {
        return new ResourceLocation(BerserksAndBosses.MODID, "geo/tectonic_colossus_2.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TectonicColossus2 object) {
        return new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/tectonic_colossus_2.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TectonicColossus2 animatable) {
        return new ResourceLocation(BerserksAndBosses.MODID, "animations/tectonic_colossus_2.animation.json");
    }
}
