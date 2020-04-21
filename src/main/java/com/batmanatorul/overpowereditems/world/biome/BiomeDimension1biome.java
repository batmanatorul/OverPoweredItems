
package com.batmanatorul.overpowereditems.world.biome;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;

import java.util.Random;

import com.batmanatorul.overpowereditems.block.BlockBiome1undergroundblock;
import com.batmanatorul.overpowereditems.block.BlockBiome1groundblock;
import com.batmanatorul.overpowereditems.ElementsOverpoweredItems;

@ElementsOverpoweredItems.ModElement.Tag
public class BiomeDimension1biome extends ElementsOverpoweredItems.ModElement {
	@GameRegistry.ObjectHolder("overpowereditems:dimension1biome")
	public static final BiomeGenCustom biome = null;
	public BiomeDimension1biome(ElementsOverpoweredItems instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Blue biome").setRainfall(0F).setBaseHeight(0.1F).setHeightVariation(0.2F).setTemperature(0.5F));
			setRegistryName("dimension1biome");
			topBlock = BlockBiome1groundblock.block.getDefaultState();
			fillerBlock = BlockBiome1undergroundblock.block.getDefaultState();
			decorator.generateFalls = false;
			decorator.treesPerChunk = 1;
			decorator.flowersPerChunk = 2;
			decorator.grassPerChunk = 4;
			decorator.deadBushPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
