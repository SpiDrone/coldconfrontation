package net.mcreator.coldconfrontation.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.coldconfrontation.network.ColdconfrontationModVariables;
import net.mcreator.coldconfrontation.init.ColdconfrontationModBlocks;
import net.mcreator.coldconfrontation.ColdconfrontationMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerRespawnsProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean reset = false;
		if (!((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("coldconfrontation:frosted_overworld"))))) {
			if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
				ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("coldconfrontation:frosted_overworld"));
				if (_player.level().dimension() == destinationType)
					return;
				ServerLevel nextLevel = _player.server.getLevel(destinationType);
				if (nextLevel != null) {
					_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
					_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
					_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
					for (MobEffectInstance _effectinstance : _player.getActiveEffects())
						_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
					_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
			if (!((world.getBlockState(BlockPos.containing((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireX,
					(entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireY,
					(entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireZ))).getBlock() == ColdconfrontationModBlocks.CAMPFIRE.get())) {
				reset = true;
			}
		}
		if ((world.getBlockState(BlockPos.containing((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireX,
				(entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireY,
				(entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireZ))).getBlock() == ColdconfrontationModBlocks.CAMPFIRE.get()) {
			ColdconfrontationMod.queueServerWork(1, () -> {
				{
					Entity _ent = entity;
					_ent.teleportTo(((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireX + (Math.random() < 0.5 ? -0.5 : 1.5)),
							((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireY + 0.5),
							((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireZ + (Math.random() < 0.5 ? -0.5 : 1.5)));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(
								((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireX + (Math.random() < 0.5 ? -0.5 : 1.5)),
								((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireY + 0.5),
								((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireZ + (Math.random() < 0.5 ? -0.5 : 1.5)), _ent.getYRot(),
								_ent.getXRot());
				}
			});
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(),
						BlockPos.containing((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireX + (Math.random() < 0.5 ? -0.5 : 1.5),
								(entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireY + 0.5,
								(entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireZ + (Math.random() < 0.5 ? -0.5 : 1.5)),
						_serverPlayer.getYRot(), true, false);
		} else {
			if (!((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireX == (entity
					.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireY
					&& (entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireZ == (entity
							.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireY
					&& (entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).campfireZ == 0)) {
				{
					double _setval = 0;
					entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.campfireX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.campfireY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.campfireZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				reset = true;
			}
		}
	}
}
