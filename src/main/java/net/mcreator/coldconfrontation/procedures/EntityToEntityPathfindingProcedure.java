package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.coldconfrontation.ColdconfrontationMod;

import java.util.List;
import java.util.Comparator;

public class EntityToEntityPathfindingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null) {
			return;
		}
		final Vec3 _center = new Vec3(x, y, z);
		double detectionRadius = 10.0; // Adjust detection radius as needed
		List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(detectionRadius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
		for (Entity entityiterator : _entfound) {
			// Check if entityiterator is not the same as entity and is a player
			if (entity != entityiterator && entityiterator instanceof Player) {
				// Ensure entity is capable of pathfinding
				if (entity instanceof PathfinderMob) {
					PathfinderMob mob = (PathfinderMob) entity;
					Player player = (Player) entityiterator;
					// Check if the entity can pathfind to the player
					boolean canPathfind = canEntityPathfindTo(mob, player);
					if (canPathfind) {
						ColdconfrontationMod.LOGGER.info("Player Found: " + player.getDisplayName().getString() + " - Can Pathfind: " + canPathfind);
					} else {
						ColdconfrontationMod.LOGGER.info("Player Found: " + player.getDisplayName().getString() + " - Cannot Pathfind");
					}
				}
			}
		}
	}

	// Method to check if a mob can pathfind to a target entity
	public static boolean canEntityPathfindTo(PathfinderMob entity, Player target) {
		BlockPos targetPos = target.blockPosition();
		PathNavigation pathNavigation = entity.getNavigation();
		if (pathNavigation == null || !pathNavigation.isDone()) {
			return false; // Navigation not available or busy
		}
		Path path = pathNavigation.createPath(targetPos, 1);
		return path != null && path.getNodeCount() > 1 && !path.isDone();
	}
}
