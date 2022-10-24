package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.BerserkPhantomModel;
import crimsonspade.berserksandbosses.Client.EntityModels.PitchfulModel;
import crimsonspade.berserksandbosses.Entity.BerserkPhantom;
import crimsonspade.berserksandbosses.Entity.Pitchful;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class PitchfulRenderer extends MobRenderer<Pitchful, PitchfulModel<Pitchful>> {
    public static final ResourceLocation PITCHFUL_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/pitchful.png");

    public PitchfulRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new PitchfulModel<>(p_174304_.bakeLayer(PitchfulModel.LAYER_LOCATION)), 0.3F);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public @NotNull RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/pitchful_glow.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(Pitchful pEntity) {
        return PITCHFUL_LOCATION;
    }
}
