package com.atarikafa.randomevent.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Random;
import java.util.Map;

import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class TestCommandExecutedProcedure extends AtarikafasRandomEventModElements.ModElement {
	public TestCommandExecutedProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 23);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency entity for procedure TestCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
			final int _sltid = (int) (((new Random()).nextInt((int) 35 + 1)));
			_setstack.setCount((int) 1);
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
	}
}
