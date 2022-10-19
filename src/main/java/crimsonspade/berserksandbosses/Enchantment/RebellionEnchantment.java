package crimsonspade.berserksandbosses.Enchantment;

import crimsonspade.berserksandbosses.Registry.EnchantmentRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.LogicalSide;

import java.util.Map;

public class RebellionEnchantment extends Enchantment {

	public RebellionEnchantment() {
		super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[] { EquipmentSlot.CHEST });
	}

	public static void handlePlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.side == LogicalSide.SERVER && event.player.tickCount % 2 == 0) {
			Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(event.player.getItemBySlot(EquipmentSlot.CHEST));
			if (enchantments.containsKey(EnchantmentRegistry.rebellion.get())) {
				//todo add damage reduction
			}
		}
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

}
