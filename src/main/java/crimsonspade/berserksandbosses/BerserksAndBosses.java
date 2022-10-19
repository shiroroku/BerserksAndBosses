package crimsonspade.berserksandbosses;

import com.mojang.logging.LogUtils;
import crimsonspade.berserksandbosses.Entity.*;
import crimsonspade.berserksandbosses.Registry.BrewingRegistry;
import crimsonspade.berserksandbosses.Registry.EnchantmentRegistry;
import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import crimsonspade.berserksandbosses.Registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(BerserksAndBosses.MODID)
public class BerserksAndBosses {

	public static final String MODID = "berserksandbosses";
	public static final Logger LOGGER = LogUtils.getLogger();

	public BerserksAndBosses() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		EntityRegistry.ENTITIES.register(eventBus);
		EnchantmentRegistry.ENCHANTMENTS.register(eventBus);

		ItemRegistry.ITEMS.register(eventBus);
		eventBus.addListener(this::setup);
		eventBus.addListener(BerserksAndBosses::entityAttributeEvent);
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
		});
	}

	private static void entityAttributeEvent(EntityAttributeCreationEvent event) {
		event.put(EntityRegistry.BARREN_BONEROTT.get(), BarrenBonerott.setAttributes());
		event.put(EntityRegistry.FRIGID_BONEROTT.get(), FrigidBonerott.setAttributes());
		event.put(EntityRegistry.BLOODUMBRA.get(), Bloodumbra.setAttributes());
		event.put(EntityRegistry.CRIMPA.get(), Crimpa.setAttributes());
		event.put(EntityRegistry.WARPA.get(), Warpa.setAttributes());
	}

}
