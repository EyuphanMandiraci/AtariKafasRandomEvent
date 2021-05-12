package com.atarikafa.randomevent.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Random;
import java.util.Map;

import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class MidasTouchOnPotionActiveTickProcedure extends AtarikafasRandomEventModElements.ModElement {
	public MidasTouchOnPotionActiveTickProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 36);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency x for procedure MidasTouchOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency y for procedure MidasTouchOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency z for procedure MidasTouchOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency world for procedure MidasTouchOnPotionActiveTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double block = 0;
		block = (double) ((new Random()).nextInt((int) 1 + 1));
		if (((block) == 0)) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.DIAMOND_BLOCK.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.GOLD_BLOCK.getDefaultState(), 3);
		}
	}
}
