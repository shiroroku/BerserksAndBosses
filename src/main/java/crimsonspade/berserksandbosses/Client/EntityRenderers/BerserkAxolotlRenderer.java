package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BerserkAxolotlModel;
import crimsonspade.berserksandbosses.Client.EntityModels.ChainlockModel;
import crimsonspade.berserksandbosses.Entity.BerserkAxolotl;
import crimsonspade.berserksandbosses.Entity.Chainlock;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BerserkAxolotlRenderer extends MobRenderer<BerserkAxolotl, BerserkAxolotlModel<BerserkAxolotl>> {
    public static final ResourceLocation BERSERK_AXOLOTL_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/berserk_axolotl.png");

    public BerserkAxolotlRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new BerserkAxolotlModel<>(p_174304_.bakeLayer(BerserkAxolotlModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(BerserkAxolotl pEntity) {
        return BERSERK_AXOLOTL_LOCATION;
    }
}
