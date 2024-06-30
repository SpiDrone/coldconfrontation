package net.mcreator.coldconfrontation.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.coldconfrontation.entity.SpearEntityEntity;

public class SpearTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double modifier = 0;
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
	}
}
