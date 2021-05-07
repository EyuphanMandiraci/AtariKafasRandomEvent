package com.atarikafa.randomevent.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

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
		File dosya = new File(FMLPaths.GAMEDIR.get().toString(), File.separator + "re.json");
		{
			try {
				BufferedReader dosyaReader = new BufferedReader(new FileReader(dosya));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = dosyaReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				dosyaReader.close();
				JsonObject re = new Gson().fromJson(jsonstringbuilder.toString(), JsonObject.class);
				AtarikafasRandomEventModVariables.timer_default = (double) new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(re.get("timer").getAsString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
				AtarikafasRandomEventModVariables.WorldVariables.get(world).event_second = (double) (AtarikafasRandomEventModVariables.timer_default);
				AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 5);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
