
package com.batmanatorul.overpowereditems.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import com.batmanatorul.overpowereditems.creativetab.TabOverpowereditemstab;
import com.batmanatorul.overpowereditems.ElementsOverpoweredItems;

@ElementsOverpoweredItems.ModElement.Tag
public class ItemCrystalium extends ElementsOverpoweredItems.ModElement {
	@GameRegistry.ObjectHolder("overpowereditems:crystaliumhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("overpowereditems:crystaliumbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("overpowereditems:crystaliumlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("overpowereditems:crystaliumboots")
	public static final Item boots = null;
	public ItemCrystalium(ElementsOverpoweredItems instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("CRYSTALIUM", "overpowereditems:rystalium_armor", 50, new int[]{5, 8, 10, 5}, 5,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("ambient.cave")), 3f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("crystaliumhelmet")
				.setRegistryName("crystaliumhelmet").setCreativeTab(TabOverpowereditemstab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("crystaliumbody")
				.setRegistryName("crystaliumbody").setCreativeTab(TabOverpowereditemstab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("crystaliumlegs")
				.setRegistryName("crystaliumlegs").setCreativeTab(TabOverpowereditemstab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("crystaliumboots")
				.setRegistryName("crystaliumboots").setCreativeTab(TabOverpowereditemstab.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("overpowereditems:crystaliumhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("overpowereditems:crystaliumbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("overpowereditems:crystaliumlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("overpowereditems:crystaliumboots", "inventory"));
	}
}
