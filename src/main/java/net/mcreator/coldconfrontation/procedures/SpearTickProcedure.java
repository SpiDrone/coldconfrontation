package net.mcreator.coldconfrontation.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;

import net.mcreator.coldconfrontation.entity.SpearEntityEntity;
import net.mcreator.coldconfrontation.ColdconfrontationMod;

import java.util.List;
import java.util.Comparator;

import com.mojang.util.UUIDTypeAdapter;

public class SpearTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double modifier = 0;
		if (!world.isClientSide()) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_yaw) : ""));
				_ent.setXRot((float) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_pitch) : ""));
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			modifier = 1.2;
			if (!(entity.horizontalCollision || entity.verticalCollision || entity.onGround())) {
				if ((entity instanceof SpearEntityEntity _datEntI ? _datEntI.getEntityData().get(SpearEntityEntity.DATA_spearstate) : 0) == 0) {
					entity.setDeltaMovement(new Vec3((new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_x) : "") * modifier), (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_y) : "") * modifier), (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_z) : "") * modifier)));
				} else if ((entity instanceof SpearEntityEntity _datEntI ? _datEntI.getEntityData().get(SpearEntityEntity.DATA_spearstate) : 0) > 0) {
					if (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_pitch) : "") != 90) {
						if (new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_pitch) : "") > 90) {
							if (entity instanceof SpearEntityEntity _datEntSetS)
								_datEntSetS.getEntityData().set(SpearEntityEntity.DATA_pitch, ("" + Math.max(new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_pitch) : "") - 3, 90)));
						} else {
							if (entity instanceof SpearEntityEntity _datEntSetS)
								_datEntSetS.getEntityData().set(SpearEntityEntity.DATA_pitch, ("" + Math.min(new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_pitch) : "") + 3, 90)));
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!((entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_damageduuids) : "").contains(entityiterator.getStringUUID()) || entityiterator == entity
								|| (entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_owner) : "").equals(entityiterator.getStringUUID()))) {
							if (entity instanceof SpearEntityEntity _datEntSetS)
								_datEntSetS.getEntityData().set(SpearEntityEntity.DATA_damageduuids,
										((entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_damageduuids) : "") + "$$" + entityiterator.getStringUUID()));
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.TRIDENT), entity, ((new Object() {
								public Entity get(LevelAccessor _world, String _uuid) {
									try {
										if (_world instanceof ServerLevel _serverLevel) {
											return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
										}
									} catch (Exception _e) {
									}
									return null;
								}
							}).get(world, (entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_owner) : "")))), 6);
							entity.setNoGravity(false);
							if (entity instanceof SpearEntityEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SpearEntityEntity.DATA_spearstate, 2);
							ColdconfrontationMod.queueServerWork(100, () -> {
								if (entity instanceof SpearEntityEntity _datEntSetS)
									_datEntSetS.getEntityData().set(SpearEntityEntity.DATA_damageduuids,
											(((entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_damageduuids) : "") + "$$" + entityiterator.getStringUUID()).replace(entityiterator.getStringUUID(),
													"")));
							});
						}
					}
				}
			} else {
				entity.setNoGravity(false);
				if (entity instanceof SpearEntityEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SpearEntityEntity.DATA_spearstate, 1);
			}
		}
	}
}
