package com.atarikafa.randomevent.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;

import java.util.Map;
import java.util.HashMap;

import com.atarikafa.randomevent.AtarikafasRandomEventModVariables;
import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class WorldLoadedProcedure extends AtarikafasRandomEventModElements.ModElement {
	public WorldLoadedProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency world for procedure WorldLoaded!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		AtarikafasRandomEventModVariables.WorldVariables
				.get(world).event_timer = (double) (AtarikafasRandomEventModVariables.WorldVariables.get(world).timer_default);
		AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
	}

	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("world", world);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
