package com.teamabnormals.autumnity.core.other;

import com.teamabnormals.autumnity.core.Autumnity;
import com.teamabnormals.autumnity.core.AutumnityConfig;
import com.teamabnormals.autumnity.core.registry.AutumnityBiomes;
import com.teamabnormals.autumnity.core.registry.AutumnityEntityTypes;
import com.teamabnormals.autumnity.core.registry.AutumnityFeatures;
import com.teamabnormals.autumnity.core.registry.AutumnityFeatures.AutumnityConfiguredFeatures;
import com.teamabnormals.autumnity.core.registry.AutumnityFeatures.AutumnityPlacedFeatures;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = Autumnity.MOD_ID)
public class AutumnityGeneration {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onEarlyBiomeLoad(BiomeLoadingEvent event) {
		ResourceLocation biome = event.getName();
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		MobSpawnSettingsBuilder spawns = event.getSpawns();

		if (biome == null) return;

		if (DataUtil.matchesKeys(biome, AutumnityBiomes.MAPLE_FOREST.getKey(), AutumnityBiomes.PUMPKIN_FIELDS.getKey())) {
			BiomeDefaultFeatures.commonSpawns(spawns);
			spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
			spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
			spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AutumnityEntityTypes.TURKEY.get(), 10, 4, 4));
			spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
			spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AutumnityEntityTypes.SNAIL.get(), 16, 2, 2));

			OverworldBiomes.globalOverworldGeneration(generation);
			BiomeDefaultFeatures.addDefaultOres(generation);
			BiomeDefaultFeatures.addDefaultSoftDisks(generation);
			BiomeDefaultFeatures.addDefaultMushrooms(generation);
			BiomeDefaultFeatures.addDefaultExtraVegetation(generation);

			if (DataUtil.matchesKeys(biome, AutumnityBiomes.MAPLE_FOREST.getKey())) {
				BiomeDefaultFeatures.addDefaultFlowers(generation);
				BiomeDefaultFeatures.addForestGrass(generation);
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.MAPLE_FOREST_VEGETATION.getHolder().get());
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.FLOWER_MAPLE_FOREST.getHolder().get());
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.PATCH_TALL_GRASS_MAPLE_FOREST);
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.FALLEN_LEAVES.getHolder().get());
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.PATCH_FOUL_BERRY_BUSH.getHolder().get());
			}

			if (DataUtil.matchesKeys(biome, AutumnityBiomes.PUMPKIN_FIELDS.getKey())) {
				BiomeDefaultFeatures.addPlainGrass(generation);
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.PUMPKIN_FIELDS_VEGETATION.getHolder().get());
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.FLOWER_PUMPKIN_FIELDS.getHolder().get());
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.PATCH_TALL_GRASS_PUMPKIN_FIELDS);
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.PATCH_PUMPKIN_PUMPKIN_FIELDS.getHolder().get());
			}
		} else {
			if (DataUtil.matchesKeys(biome, AutumnityBiomes.SPOTTED_FOREST.getKey())) {
				BiomeDefaultFeatures.farmAnimals(spawns);
				BiomeDefaultFeatures.commonSpawns(spawns);
				spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

				OverworldBiomes.globalOverworldGeneration(generation);
				BiomeDefaultFeatures.addForestFlowers(generation);
				BiomeDefaultFeatures.addDefaultOres(generation);
				BiomeDefaultFeatures.addDefaultSoftDisks(generation);
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.TREES_SPOTTED_FOREST.getHolder().get());
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.TREES_MAPLE_YELLOW.getHolder().get());
				BiomeDefaultFeatures.addDefaultFlowers(generation);
				BiomeDefaultFeatures.addForestGrass(generation);
				BiomeDefaultFeatures.addDefaultMushrooms(generation);
				BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
			}

			if (DataUtil.matchesKeys(biome, AutumnityBiomes.SPOTTED_DARK_FOREST.getKey())) {
				BiomeDefaultFeatures.farmAnimals(spawns);
				BiomeDefaultFeatures.commonSpawns(spawns);

				OverworldBiomes.globalOverworldGeneration(generation);
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.SPOTTED_DARK_FOREST_VEGETATION.getHolder().get());
				BiomeDefaultFeatures.addForestFlowers(generation);
				BiomeDefaultFeatures.addDefaultOres(generation);
				BiomeDefaultFeatures.addDefaultSoftDisks(generation);
				BiomeDefaultFeatures.addDefaultFlowers(generation);
				BiomeDefaultFeatures.addForestGrass(generation);
				BiomeDefaultFeatures.addDefaultMushrooms(generation);
				BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
			}

			if (DataUtil.matchesKeys(biome, AutumnityBiomes.SPOTTED_TAIGA.getKey())) {
				BiomeDefaultFeatures.farmAnimals(spawns);
				spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
				BiomeDefaultFeatures.commonSpawns(spawns);

				OverworldBiomes.globalOverworldGeneration(generation);
				BiomeDefaultFeatures.addFerns(generation);
				BiomeDefaultFeatures.addDefaultOres(generation);
				BiomeDefaultFeatures.addDefaultSoftDisks(generation);
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.TREES_SPOTTED_TAIGA.getHolder().get());
				BiomeDefaultFeatures.addDefaultFlowers(generation);
				BiomeDefaultFeatures.addTaigaGrass(generation);
				BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
				BiomeDefaultFeatures.addCommonBerryBushes(generation);
			}
		}
	}

	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		ResourceLocation biome = event.getName();
		MobSpawnSettingsBuilder spawns = event.getSpawns();
		BiomeGenerationSettingsBuilder generation = event.getGeneration();

		if (biome == null) return;

		if (!DataUtil.matchesKeys(biome, AutumnityBiomes.MAPLE_FOREST.getKey(), AutumnityBiomes.PUMPKIN_FIELDS.getKey())) {
			if (AutumnityConfig.COMMON.snailSpawnBiomes.get().contains(biome.toString())) {
				spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AutumnityEntityTypes.SNAIL.get(), 10, 2, 2));
			}

			if (AutumnityConfig.COMMON.turkeySpawnBiomes.get().contains(biome.toString())) {
				spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AutumnityEntityTypes.TURKEY.get(), 10, 4, 4));
			}

			if (AutumnityConfig.COMMON.mapleTreeBiomes.get().contains(biome.toString())) {
				generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AutumnityPlacedFeatures.TREES_MAPLE.getHolder().get());
			}
		}

		removeSpawns(event);
	}

	private static void removeSpawns(BiomeLoadingEvent event) {
		MobSpawnSettingsBuilder spawns = event.getSpawns();
		List<MobSpawnSettings.SpawnerData> entrysToRemove = new ArrayList<>();
		for (MobSpawnSettings.SpawnerData entry : spawns.getSpawner(MobCategory.CREATURE)) {
			if (AutumnityConfig.COMMON.turkeySpawnBiomes.get().contains(event.getName().toString())) {
				if (entry.type == EntityType.CHICKEN) {
					entrysToRemove.add(entry);
				}
			}
		}
		spawns.getSpawner(MobCategory.CREATURE).removeAll(entrysToRemove);
	}
}