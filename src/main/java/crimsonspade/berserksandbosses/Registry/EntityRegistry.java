package crimsonspade.berserksandbosses.Registry;

import crimsonspade.berserksandbosses.BerserksAndBosses;
import crimsonspade.berserksandbosses.Entity.ShurikenProjectile;
import crimsonspade.berserksandbosses.Entity.SpacefractureShurikenProjectile;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, BerserksAndBosses.MODID);

	public static final RegistryObject<EntityType<ShurikenProjectile>> SHURIKEN_PROJECTILE = ENTITIES.register("shuriken_projectile", ()-> EntityType.Builder.<ShurikenProjectile>of(ShurikenProjectile::new, MobCategory.MISC).sized(0.1f, 0.1f).build(BerserksAndBosses.MODID + "shuriken_projectile"));
	public static final RegistryObject<EntityType<SpacefractureShurikenProjectile>> SPACEFRACTURE_SHURIKEN_PROJECTILE = ENTITIES.register("spacefracture_shuriken_projectile", ()-> EntityType.Builder.<SpacefractureShurikenProjectile>of(SpacefractureShurikenProjectile::new, MobCategory.MISC).sized(0.1f, 0.1f).build(BerserksAndBosses.MODID + "spacefracture_shuriken_projectile"));
}
