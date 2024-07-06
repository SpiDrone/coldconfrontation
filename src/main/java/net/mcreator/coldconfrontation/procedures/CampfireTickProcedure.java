package net.mcreator.coldconfrontation.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.coldconfrontation.network.ColdconfrontationModVariables;
import net.mcreator.coldconfrontation.init.ColdconfrontationModParticleTypes;
import net.mcreator.coldconfrontation.init.ColdconfrontationModMobEffects;

import java.util.List;
import java.util.Comparator;

public class CampfireTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double modifier = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(ColdconfrontationModMobEffects.WARM.get(), 100, 0, false, false));
					if (entityiterator instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(ColdconfrontationModMobEffects.WET.get())) {
						modifier = 2;
						if (!entityiterator.isInWaterRainOrBubble()) {
							if (Math.random() < 0.03) {
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(ColdconfrontationModMobEffects.WET.get());
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.blastfurnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.blastfurnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
					}
					{
						double _setval = Math.min((entityiterator.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).PlayerHeat + 5 - modifier, 10000);
						entityiterator.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerHeat = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ColdconfrontationModParticleTypes.CAMPFIRE_FLAME.get()), (x + Mth.nextDouble(RandomSource.create(), 0.46, 0.54)), (y + Mth.nextDouble(RandomSource.create(), 0.38, 0.44)),
					(z + Mth.nextDouble(RandomSource.create(), 0.46, 0.54)), 2, 0, 0, 0, 0.025);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMALL_FLAME, (x + Mth.nextDouble(RandomSource.create(), 0.46, 0.54)), (y + Mth.nextDouble(RandomSource.create(), 0.38, 0.44)), (z + Mth.nextDouble(RandomSource.create(), 0.46, 0.54)), 1, 0, 0, 0, 0.025);
		if (Math.random() < 0.1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + 0.5), (y + 0.7), (z + 0.5), 1, 0, 0.3, 0, 0.04);
		}
		if (Math.random() < 0.02) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.campfire.crackle")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.campfire.crackle")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
