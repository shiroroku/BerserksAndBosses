package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.NetherWidowModel;
import crimsonspade.berserksandbosses.Client.EntityModels.XenocaraModel;
import crimsonspade.berserksandbosses.Entity.NetherWidow;
import crimsonspade.berserksandbosses.Entity.Xenocara;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class NetherWidowRenderer extends MobRenderer<NetherWidow, NetherWidowModel<NetherWidow>> {
    public static final ResourceLocation NETHER_WIDOW_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/nether_widow.png");

    public NetherWidowRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new NetherWidowModel<>(p_174304_.bakeLayer(NetherWidowModel.LAYER_LOCATION)), 0.3F);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/nether_widow_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(NetherWidow pEntity) {
        return NETHER_WIDOW_LOCATION;
    }
}
