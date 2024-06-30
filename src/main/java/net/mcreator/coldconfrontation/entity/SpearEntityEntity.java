
package net.mcreator.coldconfrontation.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.coldconfrontation.procedures.SpearTickProcedure;
import net.mcreator.coldconfrontation.procedures.SpearSpawnProcedure;
import net.mcreator.coldconfrontation.init.ColdconfrontationModEntities;

import javax.annotation.Nullable;

public class SpearEntityEntity extends PathfinderMob {
	public static final EntityDataAccessor<String> DATA_owner = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_pierce = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_loyalty = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_explosive = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_weight = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<String> DATA_yaw = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> DATA_pitch = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Boolean> DATA_forceRotat = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> DATA_z = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> DATA_x = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> DATA_y = SynchedEntityData.defineId(SpearEntityEntity.class, EntityDataSerializers.STRING);

	public SpearEntityEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(ColdconfrontationModEntities.SPEAR_ENTITY.get(), world);
	}

	public SpearEntityEntity(EntityType<SpearEntityEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0f);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_owner, "");
		this.entityData.define(DATA_pierce, 0);
		this.entityData.define(DATA_loyalty, 0);
		this.entityData.define(DATA_explosive, 0);
		this.entityData.define(DATA_weight, 0);
		this.entityData.define(DATA_yaw, "0");
		this.entityData.define(DATA_pitch, "0");
		this.entityData.define(DATA_forceRotat, true);
		this.entityData.define(DATA_z, "0");
		this.entityData.define(DATA_x, "0");
		this.entityData.define(DATA_y, "0");
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.getDirectEntity() instanceof Player)
			return false;
		if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.CACTUS))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		if (damagesource.is(DamageTypes.LIGHTNING_BOLT))
			return false;
		if (damagesource.is(DamageTypes.EXPLOSION))
			return false;
		if (damagesource.is(DamageTypes.TRIDENT))
			return false;
		if (damagesource.is(DamageTypes.FALLING_ANVIL))
			return false;
		if (damagesource.is(DamageTypes.DRAGON_BREATH))
			return false;
		if (damagesource.is(DamageTypes.WITHER))
			return false;
		if (damagesource.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		SpearSpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Dataowner", this.entityData.get(DATA_owner));
		compound.putInt("Datapierce", this.entityData.get(DATA_pierce));
		compound.putInt("Dataloyalty", this.entityData.get(DATA_loyalty));
		compound.putInt("Dataexplosive", this.entityData.get(DATA_explosive));
		compound.putInt("Dataweight", this.entityData.get(DATA_weight));
		compound.putString("Datayaw", this.entityData.get(DATA_yaw));
		compound.putString("Datapitch", this.entityData.get(DATA_pitch));
		compound.putBoolean("DataforceRotat", this.entityData.get(DATA_forceRotat));
		compound.putString("Dataz", this.entityData.get(DATA_z));
		compound.putString("Datax", this.entityData.get(DATA_x));
		compound.putString("Datay", this.entityData.get(DATA_y));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Dataowner"))
			this.entityData.set(DATA_owner, compound.getString("Dataowner"));
		if (compound.contains("Datapierce"))
			this.entityData.set(DATA_pierce, compound.getInt("Datapierce"));
		if (compound.contains("Dataloyalty"))
			this.entityData.set(DATA_loyalty, compound.getInt("Dataloyalty"));
		if (compound.contains("Dataexplosive"))
			this.entityData.set(DATA_explosive, compound.getInt("Dataexplosive"));
		if (compound.contains("Dataweight"))
			this.entityData.set(DATA_weight, compound.getInt("Dataweight"));
		if (compound.contains("Datayaw"))
			this.entityData.set(DATA_yaw, compound.getString("Datayaw"));
		if (compound.contains("Datapitch"))
			this.entityData.set(DATA_pitch, compound.getString("Datapitch"));
		if (compound.contains("DataforceRotat"))
			this.entityData.set(DATA_forceRotat, compound.getBoolean("DataforceRotat"));
		if (compound.contains("Dataz"))
			this.entityData.set(DATA_z, compound.getString("Dataz"));
		if (compound.contains("Datax"))
			this.entityData.set(DATA_x, compound.getString("Datax"));
		if (compound.contains("Datay"))
			this.entityData.set(DATA_y, compound.getString("Datay"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		SpearTickProcedure.execute(this);
	}

	@Override
	public boolean isPushedByFluid() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	@Override
	protected void pushEntities() {
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 1000);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 0);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1000);
		builder = builder.add(Attributes.FLYING_SPEED, 0);
		return builder;
	}
}
