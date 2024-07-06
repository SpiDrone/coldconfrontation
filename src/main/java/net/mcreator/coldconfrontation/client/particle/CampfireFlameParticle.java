
package net.mcreator.coldconfrontation.client.particle;

@OnlyIn(Dist.CLIENT)
public class CampfireFlameParticle extends TextureSheetParticle {
	public static CampfireFlameParticleProvider provider(SpriteSet spriteSet) {
		return new CampfireFlameParticleProvider(spriteSet);
	}

	public static class CampfireFlameParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public CampfireFlameParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new CampfireFlameParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;
	private float angularVelocity;
	private float angularAcceleration;

	protected CampfireFlameParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.lifetime = 7;
		this.gravity = -0.2f;
		this.hasPhysics = true;
		this.xd = vx * 1.2;
		this.yd = vy * 1.2;
		this.zd = vz * 1.2;
		this.angularVelocity = 0f;
		this.angularAcceleration = 0.1f;
		this.setSpriteFromAge(spriteSet);
	}

	@Override
	public int getLightColor(float partialTick) {
		return 15728880;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_LIT;
	}

	@Override
	public void tick() {
		super.tick();
		this.oRoll = this.roll;
		this.roll += this.angularVelocity;
		this.angularVelocity += this.angularAcceleration;
		if (!this.removed) {
			this.setSprite(this.spriteSet.get((this.age / 2) % 8 + 1, 8));
		}
	}
}