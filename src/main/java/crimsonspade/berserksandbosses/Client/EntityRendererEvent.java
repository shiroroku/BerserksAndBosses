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
        event.registerLayerDefinition(NormpaModel.LAYER_LOCATION, NormpaModel::createBodyLayer);
        event.registerLayerDefinition(SpringlockModel.LAYER_LOCATION, SpringlockModel::createBodyLayer);
        event.registerLayerDefinition(ChainlockModel.LAYER_LOCATION, ChainlockModel::createBodyLayer);
        event.registerLayerDefinition(DevolterModel.LAYER_LOCATION, DevolterModel::createBodyLayer);
        event.registerLayerDefinition(BerserkAxolotlModel.LAYER_LOCATION, BerserkAxolotlModel::createBodyLayer);
        event.registerLayerDefinition(FleshRaptorModel.LAYER_LOCATION, FleshRaptorModel::createBodyLayer);
        event.registerLayerDefinition(XenocaraModel.LAYER_LOCATION, XenocaraModel::createBodyLayer);
        event.registerLayerDefinition(NetherWidowModel.LAYER_LOCATION, NetherWidowModel::createBodyLayer);
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
        event.registerEntityRenderer(EntityRegistry.NORMPA.get(), NormpaRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BLIZZPA.get(), BlizzpaRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SPRINGLOCK.get(), SpringlockRenderer::new);
        event.registerEntityRenderer(EntityRegistry.CHAINLOCK.get(), ChainlockRenderer::new);
        event.registerEntityRenderer(EntityRegistry.DEVOLTER.get(), DevolterRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BERSERK_AXOLOTL.get(), BerserkAxolotlRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FLESH_RAPTOR.get(), FleshRaptorRenderer::new);
        event.registerEntityRenderer(EntityRegistry.NETHER_WIDOW.get(), NetherWidowRenderer::new);
        event.registerEntityRenderer(EntityRegistry.XENOCARA.get(), XenocaraRenderer::new);
    }
}
