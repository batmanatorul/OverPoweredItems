
package com.batmanatorul.overpowereditems.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import com.batmanatorul.overpowereditems.procedure.ProcedureEnhancedcrystaliumappleFoodEaten;
import com.batmanatorul.overpowereditems.creativetab.TabOverpowereditemstab;
import com.batmanatorul.overpowereditems.ElementsOverpoweredItems;

@ElementsOverpoweredItems.ModElement.Tag
public class ItemEnhancedcrystaliumapple extends ElementsOverpoweredItems.ModElement {
	@GameRegistry.ObjectHolder("overpowereditems:enhancedcrystaliumapple")
	public static final Item block = null;
	public ItemEnhancedcrystaliumapple(ElementsOverpoweredItems instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("overpowereditems:enhancedcrystaliumapple", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(8, 5f, false);
			setUnlocalizedName("enhancedcrystaliumapple");
			setRegistryName("enhancedcrystaliumapple");
			setAlwaysEdible();
			setCreativeTab(TabOverpowereditemstab.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureEnhancedcrystaliumappleFoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}
