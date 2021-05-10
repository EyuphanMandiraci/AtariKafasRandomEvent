package com.atarikafa.randomevent.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.atarikafa.randomevent.potion.FallDamagePotion;
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
		entity.setMotion(0, 10, 0);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(FallDamagePotion.potion, (int) 10000000, (int) 1, (false), (false)));
	}
}
