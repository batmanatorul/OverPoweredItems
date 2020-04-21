
package com.batmanatorul.overpowereditems.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

import com.batmanatorul.overpowereditems.item.ItemAlienpickoverworld;
import com.batmanatorul.overpowereditems.ElementsOverpoweredItems;

@ElementsOverpoweredItems.ModElement.Tag
public class EntityAlienRobot extends ElementsOverpoweredItems.ModElement {
	public static final int ENTITYID = 1;
	public static final int ENTITYID_RANGED = 2;
	public EntityAlienRobot(ElementsOverpoweredItems instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("overpowereditems", "alienrobot"), ENTITYID)
						.name("alienrobot").tracker(64, 3, true).egg(-13312, -1).build());
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelOverpower_Boss_model(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("overpowereditems:textures/1.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 1500;
			this.isImmuneToFire = true;
			setNoAI(!true);
			setCustomNameTag("Overworld Alien");
			setAlwaysRenderNameTag(true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, true));
			this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(3, new EntityAIAttackMelee(this, 0.5, false));
			this.tasks.addTask(4, new EntityAIWander(this, 0.5));
			this.tasks.addTask(5, new EntityAILookIdle(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemAlienpickoverworld.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("ambient.cave"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.creeper.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.endermen.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityArrow)
				return false;
			if (source.getImmediateSource() instanceof EntityPotion)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12D);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 4; ++l) {
					double d0 = (i + random.nextFloat());
					double d1 = (j + random.nextFloat());
					double d2 = (k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.5D;
					double d4 = (random.nextFloat() - 0.5D) * 0.5D;
					double d5 = (random.nextFloat() - 0.5D) * 0.5D;
					world.spawnParticle(EnumParticleTypes.SPIT, d0, d1, d2, d3, d4, d5);
				}
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class ModelOverpower_Boss_model extends ModelBase {
		private final ModelRenderer bone;
		public ModelOverpower_Boss_model() {
			textureWidth = 32;
			textureHeight = 32;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(8.0F, 24.0F, -8.0F);
			bone.cubeList.add(new ModelBox(bone, 0, 2, -6.0F, -2.0F, 6.0F, 2, 2, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -12.0F, -2.0F, 6.0F, 2, 2, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -5.0F, -1.0F, 5.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -6.0F, -1.0F, 5.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -11.0F, -1.0F, 5.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -12.0F, -1.0F, 5.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -6.0F, -7.0F, 6.0F, 2, 5, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -12.0F, -7.0F, 6.0F, 2, 5, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -12.0F, -8.0F, 6.0F, 3, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -7.0F, -8.0F, 6.0F, 3, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -8.0F, -9.0F, 6.0F, 4, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -12.0F, -9.0F, 6.0F, 4, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -12.0F, -20.0F, 6.0F, 8, 11, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -5.0F, -18.0F, 6.0F, 5, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -16.0F, -18.0F, 6.0F, 5, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 6, -1.0F, -17.0F, 1.0F, 1, 1, 6, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 6, -16.0F, -17.0F, 1.0F, 1, 1, 6, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -1.0F, -17.0F, 0.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -16.0F, -17.0F, 0.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -9.0F, -23.0F, 6.0F, 2, 3, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -10.0F, -32.0F, 6.0F, 4, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -11.0F, -24.0F, 6.0F, 6, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -11.0F, -31.0F, 6.0F, 6, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -11.0F, -29.0F, 6.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -6.0F, -29.0F, 6.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -10.0F, -26.0F, 6.0F, 4, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 1, -9.0F, -29.0F, 6.0F, 2, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -12.0F, -25.0F, 6.0F, 8, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 2, -12.0F, -30.0F, 6.0F, 8, 5, 2, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bone.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
