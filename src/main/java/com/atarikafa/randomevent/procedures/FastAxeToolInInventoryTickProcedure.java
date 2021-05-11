package com.atarikafa.randomevent.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class FastAxeToolInInventoryTickProcedure extends AtarikafasRandomEventModElements.ModElement {
	public FastAxeToolInInventoryTickProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency entity for procedure FastAxeToolInInventoryTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency itemstack for procedure FastAxeToolInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		(itemstack).getOrCreateTag().putDouble("timer", (((itemstack).getOrCreateTag().getDouble("timer")) + 1));
		if ((((itemstack).getOrCreateTag().getDouble("timer")) == 600)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = (itemstack);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		}
	}
}
