package com.atarikafa.randomevent.procedures;

import net.minecraft.world.IWorld;

import java.util.Map;
import java.util.HashMap;

import com.atarikafa.randomevent.AtarikafasRandomEventModVariables;
import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class EventStartCommandExecutedProcedure extends AtarikafasRandomEventModElements.ModElement {
	public EventStartCommandExecutedProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency cmdparams for procedure EventStartCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency world for procedure EventStartCommandExecuted!");
			return;
		}
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		IWorld world = (IWorld) dependencies.get("world");
		AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) (new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText());
		AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
		AtarikafasRandomEventModVariables.WorldVariables.get(world).event_timer = (double) 2;
		AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
	}
}
