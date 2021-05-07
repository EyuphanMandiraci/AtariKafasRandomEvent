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
		AtarikafasRandomEventModVariables.WorldVariables
				.get(world).event_timer = (double) ((AtarikafasRandomEventModVariables.WorldVariables.get(world).event_timer) - 1);
		AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
		AtarikafasRandomEventModVariables.WorldVariables
				.get(world).event_second = (double) ((AtarikafasRandomEventModVariables.WorldVariables.get(world).event_timer) / 20);
		AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
		if (((AtarikafasRandomEventModVariables.WorldVariables.get(world).event_timer) <= 0)) {
			AtarikafasRandomEventModVariables.WorldVariables
					.get(world).event_timer = (double) (AtarikafasRandomEventModVariables.WorldVariables.get(world).timer_default);
			AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
			AtarikafasRandomEventModVariables.WorldVariables.get(world).event_bad = (boolean) ((new Random()).nextBoolean());
			AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if ((AtarikafasRandomEventModVariables.WorldVariables.get(world).event_bad)) {
						System.out.println("Bad!");
					} else if ((!(AtarikafasRandomEventModVariables.WorldVariables.get(world).event_bad))) {
						System.out.println("Good!");
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 5);
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