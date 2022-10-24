package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BerserkAxolotlModel;
import crimsonspade.berserksandbosses.Client.EntityModels.BerserkStriderModel;
import crimsonspade.berserksandbosses.Entity.BerserkAxolotl;
import crimsonspade.berserksandbosses.Entity.BerserkStrider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BerserkStriderRenderer extends MobRenderer<BerserkStrider, BerserkStriderModel<BerserkStrider>> {
    public static final ResourceLocation BERSERK_STRIDER_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/berserk_strider.png");

    public BerserkStriderRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new BerserkStriderModel<>(p_174304_.bakeLayer(BerserkStriderModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(BerserkStrider pEntity) {
        return BERSERK_STRIDER_LOCATION;
    }
}
