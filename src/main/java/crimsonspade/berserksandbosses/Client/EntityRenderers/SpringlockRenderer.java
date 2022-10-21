package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.NormpaModel;
import crimsonspade.berserksandbosses.Client.EntityModels.SpringlockModel;
import crimsonspade.berserksandbosses.Entity.Blizzpa;
import crimsonspade.berserksandbosses.Entity.Springlock;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SpringlockRenderer extends MobRenderer<Springlock, SpringlockModel<Springlock>> {
    public static final ResourceLocation SPRINGLOCK_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/springlock.png");

    public SpringlockRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new SpringlockModel<>(p_174304_.bakeLayer(SpringlockModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Springlock pEntity) {
        return SPRINGLOCK_LOCATION;
    }
}
