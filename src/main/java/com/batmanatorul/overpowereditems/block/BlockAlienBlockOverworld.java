
package com.batmanatorul.overpowereditems.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import java.util.Random;
import java.util.List;

import com.batmanatorul.overpowereditems.creativetab.TabOverpowereditemstab;
import com.batmanatorul.overpowereditems.ElementsOverpoweredItems;

@ElementsOverpoweredItems.ModElement.Tag
public class BlockAlienBlockOverworld extends ElementsOverpoweredItems.ModElement {
	@GameRegistry.ObjectHolder("overpowereditems:alienblockoverworld")
	public static final Block block = null;
	public BlockAlienBlockOverworld(ElementsOverpoweredItems instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("alienblockoverworld"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("overpowereditems:alienblockoverworld", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("alienblockoverworld");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 8);
			setHardness(20F);
			setResistance(100F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabOverpowereditemstab.tab);
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("needs to be breaked with overworld alien pickaxe");
		}

		@Override
		public int quantityDropped(Random random) {
			return 6;
		}
	}
}
