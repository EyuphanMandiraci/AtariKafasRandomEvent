package com.atarikafa.randomevent.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class AnvilFallProcedure extends AtarikafasRandomEventModElements.ModElement {
	public AnvilFallProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency x for procedure AnvilFall!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency y for procedure AnvilFall!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency z for procedure AnvilFall!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency world for procedure AnvilFall!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) (y + 25), (int) z), Blocks.ANVIL.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 25), (int) z), Blocks.ANVIL.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) (y + 25), (int) (z + 1)), Blocks.ANVIL.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 25), (int) z), Blocks.ANVIL.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) (y + 25), (int) (z - 1)), Blocks.ANVIL.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 25), (int) (z + 1)), Blocks.ANVIL.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 25), (int) (z - 1)), Blocks.ANVIL.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 25), (int) (z - 1)), Blocks.ANVIL.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 25), (int) (z + 1)), Blocks.ANVIL.getDefaultState(), 3);
	}
}
