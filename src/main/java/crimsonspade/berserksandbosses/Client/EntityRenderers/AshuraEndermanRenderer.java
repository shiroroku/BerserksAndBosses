package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.AshuraEndermanModel;
import crimsonspade.berserksandbosses.Client.EntityModels.BarrenBonerottModel;
import crimsonspade.berserksandbosses.Entity.AshuraEnderman;
import crimsonspade.berserksandbosses.Entity.BarrenBonerott;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class AshuraEndermanRenderer extends MobRenderer<AshuraEnderman, AshuraEndermanModel<AshuraEnderman>> {
    public static final ResourceLocation ASHURA_ENDERMAN_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/ashura_enderman.png");

    public AshuraEndermanRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new AshuraEndermanModel<>(p_174304_.bakeLayer(AshuraEndermanModel.LAYER_LOCATION)), 0.3F);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/ashura_enderman.png"));
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(AshuraEnderman pEntity) {
        return ASHURA_ENDERMAN_LOCATION;
    }
}
