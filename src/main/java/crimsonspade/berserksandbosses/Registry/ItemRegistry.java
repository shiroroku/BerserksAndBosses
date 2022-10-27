package crimsonspade.berserksandbosses.Registry;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.SpacefractureShurikenProjectile;
import crimsonspade.berserksandbosses.Item.ShurikenItem;
import crimsonspade.berserksandbosses.Item.SpacefractureShurikenItem;
import crimsonspade.berserksandbosses.Item.TectonicMedaillionItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ItemRegistry {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BerserksAndBosses.MODID);

	public static final RegistryObject<Item> RAW_RAPTOR_DRUMSTICK = ITEMS.register("raw_raptor_drumstick",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB).food(new FoodProperties.Builder().meat().nutrition(1).saturationMod(0.1f).effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 1f).effect(()-> new MobEffectInstance(MobEffects.WEAKNESS, 100, 1), 1f).effect(()-> new MobEffectInstance(MobEffects.WITHER, 100, 1), 1f).build()), "raw_raptor_drumstick"));

	public static final RegistryObject<Item> COOKED_RAPTOR_DRUMSTICK = ITEMS.register("cooked_raptor_drumstick",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB).food(new FoodProperties.Builder().meat().nutrition(10).saturationMod(0.8f).effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1), 1f).build()), "cooked_raptor_drumstick"));

	public static final RegistryObject<Item> SASQUASH = ITEMS.register("sasquash",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).alwaysEat().build()), "sasquash"));

	public static final RegistryObject<Item> COOKED_CRIMSADER_MEAT = ITEMS.register("cooked_crimsader_meat",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB).rarity(Rarity.RARE).food(new FoodProperties.Builder().nutrition(9).meat().saturationMod(0.7f).effect(()-> new MobEffectInstance(MobEffects.ABSORPTION, 100, 1), 1f).effect(()-> new MobEffectInstance(MobEffects.GLOWING, 100, 1), 1f).effect(()-> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1), 1f).build()), "cooked_crimsader_meat"));

	public static final RegistryObject<Item> RAW_CRIMSADER_MEAT = ITEMS.register("raw_crimsader_meat",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB).rarity(Rarity.RARE).food(new FoodProperties.Builder().nutrition(5).meat().saturationMod(0.4f).build()), "raw_crimsader_meat"));

	public static final RegistryObject<Item> CRIMSADER_SCALE_PLATING = ITEMS.register("crimsader_scale_plating",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB).rarity(Rarity.RARE), "crimsader_scale_plating"));

	public static final RegistryObject<Item> SANDY_BLOODBONE = ITEMS.register("sandy_bloodbone",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB), "sandy_bloodbone"));

	public static final RegistryObject<Item> FROSTY_BLOODBONE = ITEMS.register("frosty_bloodbone",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB), "frosty_bloodbone"));

	public static final RegistryObject<Item> BLOODUMBRA_EYE = ITEMS.register("bloodumbra_eye",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB).stacksTo(16).fireResistant(), "bloodumbra_eye"));

	public static final RegistryObject<Item> MALICE_SOULCRYSTAL = ITEMS.register("malice_soulcrystal",
			TooltipItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB).rarity(Rarity.EPIC).stacksTo(16).fireResistant(), "malice_soulcrystal"));


	public static final RegistryObject<ShurikenItem> SHURIKEN = ITEMS.register("shuriken",
			()-> new ShurikenItem(new Item.Properties().tab(BerserksAndBosses.CREATIVETAB)));

	public static final RegistryObject<SpacefractureShurikenItem> SPACEFRACTURE_SHURIKEN = ITEMS.register("spacefracture_shuriken",
			()-> new SpacefractureShurikenItem(new Item.Properties().stacksTo(32).tab(BerserksAndBosses.CREATIVETAB)));

	public static final RegistryObject<TectonicMedaillionItem> TECTONIC_MEDAILLION = ITEMS.register("tectonic_medaillion",
			()-> new TectonicMedaillionItem(new Item.Properties().stacksTo(16).durability(1).tab(BerserksAndBosses.CREATIVETAB)));

	public static Supplier<Item> TooltipItem(Item.Properties properties, String tooltipKey){
		return () -> new Item(properties){
			@Override
			public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
				pTooltipComponents.add(new TranslatableComponent("tooltip.berserksandbosses." + tooltipKey).withStyle(ChatFormatting.GRAY));
			}
		};
	}
}
