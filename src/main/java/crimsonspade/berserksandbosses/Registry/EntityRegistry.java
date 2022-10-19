package crimsonspade.berserksandbosses.Registry;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EntityRegistry {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, BerserksAndBosses.MODID);

	public static final RegistryObject<EntityType<ShurikenProjectile>> SHURIKEN_PROJECTILE = ENTITIES.register("shuriken_projectile", ()-> EntityType.Builder.<ShurikenProjectile>of(ShurikenProjectile::new, MobCategory.MISC).sized(0.1f, 0.1f).build(BerserksAndBosses.MODID + "shuriken_projectile"));
	public static final RegistryObject<EntityType<SpacefractureShurikenProjectile>> SPACEFRACTURE_SHURIKEN_PROJECTILE = ENTITIES.register("spacefracture_shuriken_projectile", ()-> EntityType.Builder.<SpacefractureShurikenProjectile>of(SpacefractureShurikenProjectile::new, MobCategory.MISC).sized(0.1f, 0.1f).build(BerserksAndBosses.MODID + "spacefracture_shuriken_projectile"));
	public static final RegistryObject<EntityType<BarrenBonerott>> BARREN_BONEROTT = registerWithSpawnEgg("barren_bonerott", ()-> EntityType.Builder.of(BarrenBonerott::new, MobCategory.MONSTER).sized(0.8f, 1.95f).build(BerserksAndBosses.MODID + "barren_bonerott"), 0xC2B280, 0xdbd2b5);
	public static final RegistryObject<EntityType<FrigidBonerott>> FRIGID_BONEROTT = registerWithSpawnEgg("frigid_bonerott", ()-> EntityType.Builder.of(FrigidBonerott::new, MobCategory.MONSTER).sized(0.8f, 1.95f).build(BerserksAndBosses.MODID + "frigid_bonerott"), 0xDBF1FD, 0xDBE0FD);
	public static final RegistryObject<EntityType<Bloodumbra>> BLOODUMBRA = registerWithSpawnEgg("bloodumbra", ()-> EntityType.Builder.of(Bloodumbra::new, MobCategory.MONSTER).sized(0.8f, 1.95f).build(BerserksAndBosses.MODID + "bloodumbra"), 0xA62D2D, 0xFF0000);
	public static final RegistryObject<EntityType<Crimpa>> CRIMPA = registerWithSpawnEgg("crimpa", ()-> EntityType.Builder.of(Crimpa::new, MobCategory.MONSTER).sized(0.8f, 1.95f).build(BerserksAndBosses.MODID + "crimpa"), 0x5F7CFF, 0xBF0D0D);
	public static final RegistryObject<EntityType<Warpa>> WARPA = registerWithSpawnEgg("warpa", ()-> EntityType.Builder.of(Warpa::new, MobCategory.MONSTER).sized(0.8f, 1.95f).build(BerserksAndBosses.MODID + "warpa"), 0x6AB4FF, 0x2400D9);

	private static <T extends Mob> RegistryObject<EntityType<T>> register(String id, Supplier<? extends EntityType<T>> sup, int color1, int color2){
		return ENTITIES.register(id, sup);
	}
	private static <T extends Mob> RegistryObject<EntityType<T>> registerWithSpawnEgg(String id, Supplier<? extends EntityType<T>> sup, int color1, int color2){
		var reg = register(id, sup, color1, color2);
		ItemRegistry.ITEMS.register(id + "_spawn_egg", () -> new ForgeSpawnEggItem(reg, color1, color2, new Item.Properties().tab(BerserksAndBosses.CREATIVETAB)));
		return reg;
	}
}
