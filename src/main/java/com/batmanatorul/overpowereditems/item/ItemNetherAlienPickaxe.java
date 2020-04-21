
package com.batmanatorul.overpowereditems.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Set;
import java.util.HashMap;

import com.batmanatorul.overpowereditems.creativetab.TabOverpowereditemstab;
import com.batmanatorul.overpowereditems.ElementsOverpoweredItems;

@ElementsOverpoweredItems.ModElement.Tag
public class ItemNetherAlienPickaxe extends ElementsOverpoweredItems.ModElement {
	@GameRegistry.ObjectHolder("overpowereditems:netheralienpickaxe")
	public static final Item block = null;
	public ItemNetherAlienPickaxe(ElementsOverpoweredItems instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("NETHERALIENPICKAXE", 10, 8, 30f, -4f, 0)) {
			{
				this.attackSpeed = -4f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 10);
				return ret.keySet();
			}
		}.setUnlocalizedName("netheralienpickaxe").setRegistryName("netheralienpickaxe").setCreativeTab(TabOverpowereditemstab.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("overpowereditems:netheralienpickaxe", "inventory"));
	}
}
