package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BerserkAxolotlModel;
import crimsonspade.berserksandbosses.Client.EntityModels.BerserkPhantomModel;
import crimsonspade.berserksandbosses.Entity.BerserkAxolotl;
import crimsonspade.berserksandbosses.Entity.BerserkPhantom;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BerserkPhantomRenderer extends MobRenderer<BerserkPhantom, BerserkPhantomModel<BerserkPhantom>> {
    public static final ResourceLocation BERSERK_PHANTOM_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/berserk_phantom.png");

    public BerserkPhantomRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new BerserkPhantomModel<>(p_174304_.bakeLayer(BerserkPhantomModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(BerserkPhantom pEntity) {
        return BERSERK_PHANTOM_LOCATION;
    }
}
