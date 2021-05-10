package com.atarikafa.randomevent.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.atarikafa.randomevent.potion.ProtectionPotion;
import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class ProtectionEffectProcedure extends AtarikafasRandomEventModElements.ModElement {
	public ProtectionEffectProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency entity for procedure ProtectionEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(ProtectionPotion.potion, (int) 1200, (int) 1, (false), (false)));
	}
}
