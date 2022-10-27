package crimsonspade.berserksandbosses;

import com.mojang.logging.LogUtils;
import crimsonspade.berserksandbosses.Client.EntityRenderers.TectonicColossus2Renderer;
import crimsonspade.berserksandbosses.Entity.*;
import crimsonspade.berserksandbosses.Registry.*;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(BerserksAndBosses.MODID)
public class BerserksAndBosses {

	public static final String MODID = "berserksandbosses";
	public static final Logger LOGGER = LogUtils.getLogger();

	public BerserksAndBosses() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		EntityRegistry.ENTITIES.register(eventBus);
		EnchantmentRegistry.ENCHANTMENTS.register(eventBus);
		SoundRegistry.SOUND_EVENTS.register(eventBus);
		ItemRegistry.ITEMS.register(eventBus);

		eventBus.addListener(this::setup);
		eventBus.addListener(BerserksAndBosses::entityAttributeEvent);

		GeckoLib.initialize();
	}

	public static final CreativeModeTab CREATIVETAB = new CreativeModeTab(MODID) {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(Items.EGG);
		}
	};

	private void setup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(ModEvents.class);
		event.enqueueWork(() -> {
			new BrewingRegistry().registerRecipes();

			SpawnPlacements.register(EntityRegistry.CRIMPA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
			SpawnPlacements.register(EntityRegistry.WARPA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
			SpawnPlacements.register(EntityRegistry.NORMPA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMobSpawnRules);
			SpawnPlacements.register(EntityRegistry.BLIZZPA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
			SpawnPlacements.register(EntityRegistry.BARREN_BONEROTT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(EntityRegistry.FRIGID_BONEROTT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(EntityRegistry.BLOODUMBRA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(EntityRegistry.DEVOLTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(EntityRegistry.FLESH_RAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(EntityRegistry.ASHURA_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(EntityRegistry.NETHER_WIDOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(EntityRegistry.MALICE_SOULFLAME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMobSpawnRules);
			SpawnPlacements.register(EntityRegistry.XENOCARA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMobSpawnRules);
			SpawnPlacements.register(EntityRegistry.CRIMSADER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMobSpawnRules);
			SpawnPlacements.register(EntityRegistry.SPRINGLOCK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMobSpawnRules);
			SpawnPlacements.register(EntityRegistry.CHAINLOCK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMobSpawnRules);
		});
	}

	private static void entityAttributeEvent(EntityAttributeCreationEvent event) {
		event.put(EntityRegistry.BARREN_BONEROTT.get(), BarrenBonerott.setAttributes());
		event.put(EntityRegistry.FRIGID_BONEROTT.get(), FrigidBonerott.setAttributes());
		event.put(EntityRegistry.BLOODUMBRA.get(), Bloodumbra.setAttributes());
		event.put(EntityRegistry.CRIMPA.get(), Crimpa.setAttributes());
		event.put(EntityRegistry.WARPA.get(), Warpa.setAttributes());
		event.put(EntityRegistry.NORMPA.get(), Normpa.setAttributes());
		event.put(EntityRegistry.BLIZZPA.get(), Blizzpa.setAttributes());
		event.put(EntityRegistry.SPRINGLOCK.get(), Springlock.setAttributes());
		event.put(EntityRegistry.CHAINLOCK.get(), Chainlock.setAttributes());
		event.put(EntityRegistry.DEVOLTER.get(), Devolter.setAttributes());
		event.put(EntityRegistry.BERSERK_AXOLOTL.get(), BerserkAxolotl.setAttributes());
		event.put(EntityRegistry.FLESH_RAPTOR.get(), FleshRaptor.setAttributes());
		event.put(EntityRegistry.XENOCARA.get(), Xenocara.setAttributes());
		event.put(EntityRegistry.NETHER_WIDOW.get(), NetherWidow.setAttributes());
		event.put(EntityRegistry.ASHURA_ENDERMAN.get(), AshuraEnderman.setAttributes());
		event.put(EntityRegistry.CALAMITY_GOLEM.get(), CalamityGolem.setAttributes());
		event.put(EntityRegistry.BERSERK_STRIDER.get(), BerserkStrider.setAttributes());
		event.put(EntityRegistry.BERSERK_PHANTOM.get(), BerserkPhantom.setAttributes());
		event.put(EntityRegistry.PITCHFUL.get(), Pitchful.setAttributes());
		event.put(EntityRegistry.MALICE_SOULFLAME.get(), MaliceSoulflame.setAttributes());
		event.put(EntityRegistry.TECTONIC_COLOSSUS_2.get(), TectonicColossus2.setAttributes());
		event.put(EntityRegistry.TECTONIC_COLOSSUS_1.get(), TectonicColossus1.setAttributes());
		event.put(EntityRegistry.CRIMSADER.get(), Crimsader.setAttributes());
	}

}
