
package com.atarikafa.randomevent.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;

import com.atarikafa.randomevent.AtarikafasRandomEventModElements;

@AtarikafasRandomEventModElements.ModElement.Tag
public class FallDamagePotion extends AtarikafasRandomEventModElements.ModElement {
	@ObjectHolder("atarikafas_random_event:fall_damage")
	public static final Effect potion = null;
	public FallDamagePotion(AtarikafasRandomEventModElements instance) {
		super(instance, 22);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}
	public static class EffectCustom extends Effect {
		private final ResourceLocation potionIcon;
		public EffectCustom() {
			super(EffectType.NEUTRAL, -1);
			setRegistryName("fall_damage");
			potionIcon = new ResourceLocation("atarikafas_random_event:textures/resistance_je2_be2.png");
		}

		@Override
		public String getName() {
			return "effect.fall_damage";
		}

		@Override
		public boolean isBeneficial() {
			return false;
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
