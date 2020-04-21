package com.batmanatorul.overpowereditems.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;

import com.batmanatorul.overpowereditems.ElementsOverpoweredItems;

@ElementsOverpoweredItems.ModElement.Tag
public class ProcedureAlienRobotEntityDies extends ElementsOverpoweredItems.ModElement {
	public ProcedureAlienRobotEntityDies(ElementsOverpoweredItems instance) {
		super(instance, 43);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString("-How, How, Howwwwww???! "));
		}
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString(
						"[game] use the pickaxe to mine the obsidian thats on the top of the building and then get your ore with your normal pickaxe"));
		}
	}
}
