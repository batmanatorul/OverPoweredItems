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