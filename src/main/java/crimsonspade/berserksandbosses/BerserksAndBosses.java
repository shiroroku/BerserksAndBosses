package crimsonspade.berserksandbosses;

import com.mojang.logging.LogUtils;
import crimsonspade.berserksandbosses.Registry.BrewingRegistry;
import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import crimsonspade.berserksandbosses.Registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(BerserksAndBosses.MODID)
public class BerserksAndBosses {

	public static final String MODID = "berserksandbosses";
	private static final Logger LOGGER = LogUtils.getLogger();

	public BerserksAndBosses() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemRegistry.ITEMS.register(eventBus);
		EntityRegistry.ENTITIES.register(eventBus);
		eventBus.addListener(this::setup);
	}

	public static final CreativeModeTab CREATIVETAB = new CreativeModeTab(MODID) {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(Items.EGG);
		}
	};

	private void setup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(()->{
			new BrewingRegistry().registerRecipes();
		});
	}
	
}
