// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelcustom_model extends ModelBase {
	private final ModelRenderer arm0;
	private final ModelRenderer head;
	private final ModelRenderer head1;
	private final ModelRenderer body;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer arm1;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		arm0 = new ModelRenderer(this);
		arm0.setRotationPoint(0.0F, 24.0F, 0.0F);
		arm0.cubeList.add(new ModelBox(arm0, 28, 33, 1.0F, -27.0F, -8.0F, 3, 5, 3, 0.0F, false));
		arm0.cubeList.add(new ModelBox(arm0, 32, 18, -5.0F, -27.0F, -8.0F, 6, 5, 2, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 37, 29, 1.0F, -31.0F, -2.0F, 3, 1, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 32, 11, 1.0F, -32.0F, -3.0F, 3, 1, 6, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 18, 18, 1.0F, -39.0F, -4.0F, 3, 7, 8, 0.0F, false));

		head1 = new ModelRenderer(this);
		head1.setRotationPoint(0.0F, 24.0F, 0.0F);
		head1.cubeList.add(new ModelBox(head1, 0, 0, 1.0F, -30.0F, -1.0F, 3, 3, 2, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, 1.0F, -27.0F, -5.0F, 3, 13, 10, 0.0F, false));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg0.cubeList.add(new ModelBox(leg0, 0, 23, 1.0F, -14.0F, -5.0F, 3, 14, 3, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg1.cubeList.add(new ModelBox(leg1, 26, 0, 1.0F, -14.0F, 2.0F, 3, 14, 3, 0.0F, false));

		arm1 = new ModelRenderer(this);
		arm1.setRotationPoint(0.0F, 24.0F, 0.0F);
		arm1.cubeList.add(new ModelBox(arm1, 37, 38, 1.0F, -27.0F, 5.0F, 3, 5, 3, 0.0F, false));
		arm1.cubeList.add(new ModelBox(arm1, 12, 33, -5.0F, -27.0F, 6.0F, 6, 5, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		arm0.render(f5);
		head.render(f5);
		head1.render(f5);
		body.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		arm1.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}