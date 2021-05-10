package com.atarikafa.randomevent.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.atarikafa.randomevent.AtarikafasRandomEventModVariables;
import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class WorldTickUpdateProcedure extends AtarikafasRandomEventModElements.ModElement {
	public WorldTickUpdateProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 1);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency world for procedure WorldTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double event_number = 0;
		AtarikafasRandomEventModVariables.WorldVariables
				.get(world).event_timer = (double) ((AtarikafasRandomEventModVariables.WorldVariables.get(world).event_timer) - 1);
		AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
		AtarikafasRandomEventModVariables.WorldVariables
				.get(world).event_second = (double) (((AtarikafasRandomEventModVariables.WorldVariables.get(world).event_timer) / 20) + 1);
		AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
		if (((AtarikafasRandomEventModVariables.WorldVariables.get(world).event_timer) == (-1))) {
			AtarikafasRandomEventModVariables.WorldVariables
					.get(world).event_timer = (double) (AtarikafasRandomEventModVariables.WorldVariables.get(world).timer_default);
			AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
		} else if (((AtarikafasRandomEventModVariables.WorldVariables.get(world).event_timer) == 2)) {
			event_number = (double) ((new Random()).nextInt((int) 14 + 1));
			if (((event_number) == 0)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "lava_ceiling";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 1)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "zombie_raid";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 2)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "water_suffocate";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 3)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "block_suffocate";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 4)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "kill_all";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 5)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "swap_x_z";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 6)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "go_to_space";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 7)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "anvil_fall";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 8)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "give_diamond";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 9)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "rich_rain";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 10)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "extra_health";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 11)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "protection";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 12)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "fly_but_no_damage";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 13)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "clear_random_slot";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			} else if (((event_number) == 14)) {
				AtarikafasRandomEventModVariables.MapVariables.get(world).event = (String) "thunder";
				AtarikafasRandomEventModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			IWorld world = event.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
