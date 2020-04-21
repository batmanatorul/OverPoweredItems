package com.batmanatorul.overpowereditems.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.Entity;

import com.batmanatorul.overpowereditems.ElementsOverpoweredItems;

@ElementsOverpoweredItems.ModElement.Tag
public class ProcedureNetheralienPlayerCollidesWithThisEntity extends ElementsOverpoweredItems.ModElement {
	public ProcedureNetheralienPlayerCollidesWithThisEntity(ElementsOverpoweredItems instance) {
		super(instance, 45);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NetheralienPlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NetheralienPlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NetheralienPlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NetheralienPlayerCollidesWithThisEntity!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() >= Math.max(0, 0.48))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityBlaze(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		} else if ((Math.random() >= Math.max(0.48, 0.79))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityGhast(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
	}
}
