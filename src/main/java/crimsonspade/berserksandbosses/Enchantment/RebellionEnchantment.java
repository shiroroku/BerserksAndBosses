package crimsonspade.berserksandbosses.Enchantment;

import crimsonspade.berserksandbosses.Registry.EnchantmentRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
				var negEffects = event.player.getActiveEffects().stream().filter(mobEffectInstance -> !mobEffectInstance.getEffect().isBeneficial()).count();
				switch (enchantments.get(EnchantmentRegistry.rebellion.get())){
					case 1: if (negEffects > 2){
						event.player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 1, false, false));
					}
					case 2: if (negEffects > 1){
						event.player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 1, false, false));
					}
					case 3: if (negEffects > 0){
						event.player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 1, false, false));
					}
				}
			}
		}
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

}
