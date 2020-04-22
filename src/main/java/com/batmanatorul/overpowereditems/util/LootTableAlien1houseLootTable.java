
package com.batmanatorul.overpowereditems.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import com.batmanatorul.overpowereditems.ElementsOverpoweredItems;

@ElementsOverpoweredItems.ModElement.Tag
public class LootTableAlien1houseLootTable extends ElementsOverpoweredItems.ModElement {
	public LootTableAlien1houseLootTable(ElementsOverpoweredItems instance) {
		super(instance, 48);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("overpowereditems", "chests/alien_house"));
	}
}
