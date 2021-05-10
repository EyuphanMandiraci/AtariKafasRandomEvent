package com.atarikafa.randomevent.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.entity.Entity;

import java.util.Map;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class FlyButNoDamageProcedure extends AtarikafasRandomEventModElements.ModElement {
	public FlyButNoDamageProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency entity for procedure FlyButNoDamage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(0, 1, 0);
		File dosya = new File(FMLPaths.GAMEDIR.get().toString(), File.separator + (((entity.getDisplayName().getString())) + "" + (".json")));
		if (!dosya.exists()) {
			try {
				dosya.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
			JsonObject gson = new JsonObject();
			gson.addProperty("fall_damage", (false));
			try {
				FileWriter dosyafw = new FileWriter(dosya);
				dosyafw.write(mainGSONBuilderVariable.toJson(gson));
				dosyafw.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
