package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BerserkPhantomModel;
import crimsonspade.berserksandbosses.Client.EntityModels.MaliceSoulflameModel;
import crimsonspade.berserksandbosses.Entity.BerserkPhantom;
import crimsonspade.berserksandbosses.Entity.MaliceSoulflame;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MaliceSoulflameRenderer extends MobRenderer<MaliceSoulflame, MaliceSoulflameModel<MaliceSoulflame>> {
    public static final ResourceLocation MALICE_SOULFLAME_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/malice_soulflame.png");

    public MaliceSoulflameRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new MaliceSoulflameModel<>(p_174304_.bakeLayer(MaliceSoulflameModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(MaliceSoulflame pEntity) {
        return MALICE_SOULFLAME_LOCATION;
    }
}
