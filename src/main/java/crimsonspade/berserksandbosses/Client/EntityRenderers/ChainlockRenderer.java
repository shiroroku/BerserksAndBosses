package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.ChainlockModel;
import crimsonspade.berserksandbosses.Client.EntityModels.SpringlockModel;
import crimsonspade.berserksandbosses.Entity.Chainlock;
import crimsonspade.berserksandbosses.Entity.Springlock;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ChainlockRenderer extends MobRenderer<Chainlock, ChainlockModel<Chainlock>> {
    public static final ResourceLocation CHAINLOCK_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/chainlock.png");

    public ChainlockRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ChainlockModel<>(p_174304_.bakeLayer(ChainlockModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Chainlock pEntity) {
        return CHAINLOCK_LOCATION;
    }
}
