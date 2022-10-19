package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BarrenBonerottModel;
import crimsonspade.berserksandbosses.Client.EntityModels.CrimpaModel;
import crimsonspade.berserksandbosses.Entity.BarrenBonerott;
import crimsonspade.berserksandbosses.Entity.Crimpa;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class CrimpaRenderer extends MobRenderer<Crimpa, CrimpaModel<Crimpa>> {
    public static final ResourceLocation CRIMPA_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/crimpa.png");

    public CrimpaRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new CrimpaModel<>(p_174304_.bakeLayer(CrimpaModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Crimpa pEntity) {
        return CRIMPA_LOCATION;
    }
}
