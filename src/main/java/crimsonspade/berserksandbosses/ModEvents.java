package crimsonspade.berserksandbosses;

import crimsonspade.berserksandbosses.Enchantment.RebellionEnchantment;
import crimsonspade.berserksandbosses.Entity.AshuraEnderman;
import crimsonspade.berserksandbosses.Entity.TectonicColossus1;
import crimsonspade.berserksandbosses.Entity.TectonicColossus2;
import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		RebellionEnchantment.handlePlayerTick(event);
	}

	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event){
		if(event.getEntity() instanceof EnderMan entity && event.getSource().isFire() && !event.getEntity().getLevel().isClientSide()){
			AshuraEnderman toSpawn = new AshuraEnderman(EntityRegistry.ASHURA_ENDERMAN.get(), event.getEntity().level);
			toSpawn.setPos(entity.position());
			entity.level.addFreshEntity(toSpawn);
		}
	}
}
