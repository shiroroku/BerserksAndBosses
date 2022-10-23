package crimsonspade.berserksandbosses.Client.EntityRenderers;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.AshuraEndermanModel;
import crimsonspade.berserksandbosses.Client.EntityModels.CalamityGolemModel;
import crimsonspade.berserksandbosses.Entity.AshuraEnderman;
import crimsonspade.berserksandbosses.Entity.CalamityGolem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class CalamityGolemRenderer extends MobRenderer<CalamityGolem, CalamityGolemModel<CalamityGolem>> {
    public static final ResourceLocation CALAMITY_GOLEM_LOCATION = new ResourceLocation(BerserksAndBosses.MODID, "textures/entity/calamity_golem.png");

    public CalamityGolemRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new CalamityGolemModel<>(p_174304_.bakeLayer(CalamityGolemModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(CalamityGolem pEntity) {
        return CALAMITY_GOLEM_LOCATION;
    }
}
