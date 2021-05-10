package com.atarikafa.randomevent.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class WhenEntityFallsProcedure extends AtarikafasRandomEventModElements.ModElement {
	public WhenEntityFallsProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 21);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency entity for procedure WhenEntityFalls!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		File dosya = new File(FMLPaths.GAMEDIR.get().toString(), File.separator + (((entity.getDisplayName().getString())) + "" + (".json")));
		{
			try {
				BufferedReader dosyaReader = new BufferedReader(new FileReader(dosya));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = dosyaReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				dosyaReader.close();
				JsonObject gson = new Gson().fromJson(jsonstringbuilder.toString(), JsonObject.class);
				if ((!gson.get("fall_damage").getAsBoolean())) {
					if (dependencies.get("event") != null) {
						Object _obj = dependencies.get("event");
						if (_obj instanceof Event) {
							Event _evt = (Event) _obj;
							if (_evt.isCancelable())
								_evt.setCanceled(true);
						}
					}
					{
						Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
						JsonObject gson = new JsonObject();
						gson.addProperty("fall_damage", (true));
						try {
							FileWriter dosyafw = new FileWriter(dosya);
							dosyafw.write(mainGSONBuilderVariable.toJson(gson));
							dosyafw.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SubscribeEvent
	public void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double damagemultiplier = event.getDamageMultiplier();
			double distance = event.getDistance();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("damagemultiplier", damagemultiplier);
			dependencies.put("distance", distance);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
