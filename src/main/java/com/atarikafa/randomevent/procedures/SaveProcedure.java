package com.atarikafa.randomevent.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.Map;
import java.util.HashMap;

import com.atarikafa.randomevent.AtarikafasRandomEventModVariables;
import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class SaveProcedure extends AtarikafasRandomEventModElements.ModElement {
	public SaveProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency entity for procedure Save!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency guistate for procedure Save!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency world for procedure Save!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		IWorld world = (IWorld) dependencies.get("world");
		AtarikafasRandomEventModVariables.WorldVariables.get(world).timer_default = (double) (new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:timer");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())) * 20);
		AtarikafasRandomEventModVariables.WorldVariables.get(world).syncData(world);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
