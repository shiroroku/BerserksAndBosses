package crimsonspade.berserksandbosses;

import crimsonspade.berserksandbosses.Enchantment.RebellionEnchantment;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		RebellionEnchantment.handlePlayerTick(event);
	}
}
