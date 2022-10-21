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
	public static final RegistryObject<EntityType<BarrenBonerott>> BARREN_BONEROTT = registerWithSpawnEgg("barren_bonerott", ()-> EntityType.Builder.of(BarrenBonerott::new, MobCategory.MONSTER).sized(0.8f, 2f).build(BerserksAndBosses.MODID + "barren_bonerott"), 0xC2B280, 0xdbd2b5);
	public static final RegistryObject<EntityType<FrigidBonerott>> FRIGID_BONEROTT = registerWithSpawnEgg("frigid_bonerott", ()-> EntityType.Builder.of(FrigidBonerott::new, MobCategory.MONSTER).sized(0.8f, 2f).build(BerserksAndBosses.MODID + "frigid_bonerott"), 0xDBF1FD, 0xDBE0FD);
	public static final RegistryObject<EntityType<Bloodumbra>> BLOODUMBRA = registerWithSpawnEgg("bloodumbra", ()-> EntityType.Builder.of(Bloodumbra::new, MobCategory.MONSTER).sized(1.1f, 2f).build(BerserksAndBosses.MODID + "bloodumbra"), 0xA62D2D, 0xFF0000);
	public static final RegistryObject<EntityType<Crimpa>> CRIMPA = registerWithSpawnEgg("crimpa", ()-> EntityType.Builder.of(Crimpa::new, MobCategory.MONSTER).sized(0.6f, 1.8f).build(BerserksAndBosses.MODID + "crimpa"), 0x5F7CFF, 0xBF0D0D);
	public static final RegistryObject<EntityType<Warpa>> WARPA = registerWithSpawnEgg("warpa", ()-> EntityType.Builder.of(Warpa::new, MobCategory.MONSTER).sized(0.6f, 1.8f).build(BerserksAndBosses.MODID + "warpa"), 0x6AB4FF, 0x2400D9);
	public static final RegistryObject<EntityType<Normpa>> NORMPA = registerWithSpawnEgg("normpa", ()-> EntityType.Builder.of(Normpa::new, MobCategory.MONSTER).sized(0.6f, 1.8f).build(BerserksAndBosses.MODID + "normpa"), 0x6e4b2b, 0x422d1a);
	public static final RegistryObject<EntityType<Blizzpa>> BLIZZPA = registerWithSpawnEgg("blizzpa", ()-> EntityType.Builder.of(Blizzpa::new, MobCategory.MONSTER).sized(0.6f, 1.8f).build(BerserksAndBosses.MODID + "blizzpa"), 0xc4c4c4, 0xf2f2f2);
	public static final RegistryObject<EntityType<Springlock>> SPRINGLOCK = registerWithSpawnEgg("springlock", ()-> EntityType.Builder.of(Springlock::new, MobCategory.MONSTER).sized(0.6f, 1.8f).build(BerserksAndBosses.MODID + "springlock"), 0x822828, 0x1f0c0c);
	public static final RegistryObject<EntityType<Chainlock>> CHAINLOCK = registerWithSpawnEgg("chainlock", ()-> EntityType.Builder.of(Chainlock::new, MobCategory.MONSTER).sized(0.6f, 1.8f).build(BerserksAndBosses.MODID + "chainlock"), 0xAB1919, 0x4D1111);
	public static final RegistryObject<EntityType<Devolter>> DEVOLTER = registerWithSpawnEgg("devolter", ()-> EntityType.Builder.of(Devolter::new, MobCategory.MONSTER).sized(0.6f, 1.8f).build(BerserksAndBosses.MODID + "devolter"), 0x220505, 0x331818);
	public static final RegistryObject<EntityType<BerserkAxolotl>> BERSERK_AXOLOTL = registerWithSpawnEgg("berserk_axolotl", ()-> EntityType.Builder.of(BerserkAxolotl::new, MobCategory.AXOLOTLS).sized(1.8f, 0.6f).build(BerserksAndBosses.MODID + "berserk_axolotl"), 0xEFB2D6, 0xC43E8D);
	public static final RegistryObject<EntityType<FleshRaptor>> FLESH_RAPTOR = registerWithSpawnEgg("flesh_raptor", ()-> EntityType.Builder.of(FleshRaptor::new, MobCategory.MONSTER).sized(1.8f, 1.8f).build(BerserksAndBosses.MODID + "flesh_raptor"), 0xD16969, 0x7B3737);
	public static final RegistryObject<EntityType<Xenocara>> XENOCARA = registerWithSpawnEgg("xenocara", ()-> EntityType.Builder.of(Xenocara::new, MobCategory.MONSTER).sized(1f, 2.9f).build(BerserksAndBosses.MODID + "xenocara"), 0x651358, 0x2A0C25);
	public static final RegistryObject<EntityType<NetherWidow>> NETHER_WIDOW = registerWithSpawnEgg("nether_widow", ()-> EntityType.Builder.of(NetherWidow::new, MobCategory.MONSTER).sized(2.6f, 1.6f).build(BerserksAndBosses.MODID + "nether_widow"), 0x730808, 0x000000);

	private static <T extends Mob> RegistryObject<EntityType<T>> register(String id, Supplier<? extends EntityType<T>> sup){
		return ENTITIES.register(id, sup);
	}
	private static <T extends Mob> RegistryObject<EntityType<T>> registerWithSpawnEgg(String id, Supplier<? extends EntityType<T>> sup, int color1, int color2){
		var reg = register(id, sup);
		ItemRegistry.ITEMS.register(id + "_spawn_egg", () -> new ForgeSpawnEggItem(reg, color1, color2, new Item.Properties().tab(BerserksAndBosses.CREATIVETAB)));
		return reg;
	}
}
