package crimsonspade.berserksandbosses.Client;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Client.EntityModels.*;
import crimsonspade.berserksandbosses.Client.EntityRenderers.*;
import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BerserksAndBosses.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRendererEvent {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BarrenBonerottModel.LAYER_LOCATION, BarrenBonerottModel::createBodyLayer);
        event.registerLayerDefinition(FrigidBonerottModel.LAYER_LOCATION, FrigidBonerottModel::createBodyLayer);
        event.registerLayerDefinition(BloodumbraModel.LAYER_LOCATION, BloodumbraModel::createBodyLayer);
        event.registerLayerDefinition(CrimpaModel.LAYER_LOCATION, CrimpaModel::createBodyLayer);
        event.registerLayerDefinition(WarpaModel.LAYER_LOCATION, WarpaModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.SHURIKEN_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SPACEFRACTURE_SHURIKEN_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BARREN_BONEROTT.get(), BarrenBonerottRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FRIGID_BONEROTT.get(), FrigidBonerottRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BLOODUMBRA.get(), BloodumbraRenderer::new);
        event.registerEntityRenderer(EntityRegistry.CRIMPA.get(), CrimpaRenderer::new);
        event.registerEntityRenderer(EntityRegistry.WARPA.get(), WarpaRenderer::new);
    }
}
