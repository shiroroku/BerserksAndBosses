package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BerserkStriderModel;
import crimsonspade.berserksandbosses.Client.EntityModels.CrimsaderModel;
import crimsonspade.berserksandbosses.Entity.BerserkStrider;
import crimsonspade.berserksandbosses.Entity.Crimsader;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrimsaderRenderer extends MobRenderer<Crimsader, CrimsaderModel<Crimsader>> {
    public static final ResourceLocation CIMSADER_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/crimsader.png");

    public CrimsaderRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new CrimsaderModel<>(p_174304_.bakeLayer(CrimsaderModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Crimsader pEntity) {
        return CIMSADER_LOCATION;
    }
}
