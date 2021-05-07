
package com.atarikafa.randomevent.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import com.atarikafa.randomevent.AtarikafasRandomEventModVariables;
import com.atarikafa.randomevent.AtarikafasRandomEventModElements;

@AtarikafasRandomEventModElements.ModElement.Tag
public class TimerOverlayOverlay extends AtarikafasRandomEventModElements.ModElement {
	public TimerOverlayOverlay(AtarikafasRandomEventModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (true) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + (int) (AtarikafasRandomEventModVariables.WorldVariables.get(world).event_second) + "", posX + 27, posY + -22, -12829636);
			}
		}
	}
}
