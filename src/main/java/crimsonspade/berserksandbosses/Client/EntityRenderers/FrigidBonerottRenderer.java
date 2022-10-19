package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BarrenBonerottModel;
import crimsonspade.berserksandbosses.Client.EntityModels.FrigidBonerottModel;
import crimsonspade.berserksandbosses.Entity.BarrenBonerott;
import crimsonspade.berserksandbosses.Entity.FrigidBonerott;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class FrigidBonerottRenderer extends MobRenderer<FrigidBonerott, FrigidBonerottModel<FrigidBonerott>> {
    public static final ResourceLocation FRIGIDBONEROTT_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/frigid_bonerott.png");

    public FrigidBonerottRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new FrigidBonerottModel<>(p_174304_.bakeLayer(FrigidBonerottModel.LAYER_LOCATION)), 0.3F);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/frigid_bonerott_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(FrigidBonerott pEntity) {
        return FRIGIDBONEROTT_LOCATION;
    }
}
