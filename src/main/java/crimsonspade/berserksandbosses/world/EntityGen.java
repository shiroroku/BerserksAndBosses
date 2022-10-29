package crimsonspade.berserksandbosses.world;

import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.StructureSpawnListGatherEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EntityGen {
    public static void structureSpawn(final StructureSpawnListGatherEvent event){
        if (event.getStructure() == StructureFeature.STRONGHOLD) {
            event.addEntitySpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.CHAINLOCK.get(), 50, 1, 1));
            event.addEntitySpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityRegistry.SPRINGLOCK.get(), 30, 1, 1));
        }
    }

    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        addEntityToSpecificBiomes(event, EntityRegistry.CRIMPA.get(),
                5, 1, 1, Biomes.CRIMSON_FOREST);

        addEntityToSpecificBiomes(event, EntityRegistry.WARPA.get(),
                5, 1, 1, Biomes.WARPED_FOREST);

        addEntityToAllOverworldBiomes(event, EntityRegistry.NORMPA.get(),
                5, 1, 1);

        addEntityToCategory(event, EntityRegistry.BLIZZPA.get(),
                5, 1, 1, Biome.BiomeCategory.ICY);

        addEntityToCategory(event, EntityRegistry.BARREN_BONEROTT.get(),
                50, 1, 1, Biome.BiomeCategory.SAVANNA, Biome.BiomeCategory.DESERT, Biome.BiomeCategory.MESA);

        addEntityToCategory(event, EntityRegistry.FRIGID_BONEROTT.get(),
                50, 1, 1, Biome.BiomeCategory.ICY);

        addEntityToAllOverworldBiomes(event, EntityRegistry.BLOODUMBRA.get(),
                50, 1, 1);

        addEntityToCategory(event, EntityRegistry.DEVOLTER.get(),
                20, 1, 1, Biome.BiomeCategory.NETHER);

        addEntityToCategory(event, EntityRegistry.FLESH_RAPTOR.get(),
                20, 1, 1, Biome.BiomeCategory.NETHER);

        addEntityToCategory(event, EntityRegistry.ASHURA_ENDERMAN.get(),
                5, 1, 1, Biome.BiomeCategory.NETHER);

        addEntityToCategory(event, EntityRegistry.NETHER_WIDOW.get(),
                60, 1, 1, Biome.BiomeCategory.NETHER);

        addEntityToAllBiomes(event, EntityRegistry.MALICE_SOULFLAME.get(),
                40, 1, 1);

        addEntityToAllBiomes(event, EntityRegistry.XENOCARA.get(),
                1, 1, 1);

        addEntityToAllBiomes(event, EntityRegistry.CRIMSADER.get(),
                2, 1, 1);

        addEntityToCategory(event, EntityRegistry.PITCHFUL.get(),
                10, 1, 1, Biome.BiomeCategory.UNDERGROUND);

        addEntityToAllOverworldBiomes(event, EntityRegistry.BERSERK_PHANTOM.get(),
                10, 1, 1);

        addEntityToCategory(event, EntityRegistry.BERSERK_PHANTOM.get(),
                3, 1, 1);

        addEntityToCategory(event, EntityRegistry.PITCHFUL.get(),
                3, 1, 1, Biome.BiomeCategory.RIVER);

        addEntityToCategory(event, EntityRegistry.PITCHFUL.get(),
                3, 1, 1, Biome.BiomeCategory.NETHER);
    }


    @SafeVarargs
    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type,
                                                        int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(!isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    @SafeVarargs
    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToCategory(BiomeLoadingEvent event, EntityType<?> type,
                                            int weight, int minCount, int maxCount, Biome.BiomeCategory... category) {
        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
        boolean isBiomeSelected = Arrays.asList(category).contains(event.getCategory());

        if(isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                      int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type,
                                                     int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                             int weight, int minCount, int maxCount) {
        List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
        base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
    }
}
