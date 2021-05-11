package com.atarikafa.randomevent.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ITag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class TestCommandExecutedProcedure extends AtarikafasRandomEventModElements.ModElement {
	public TestCommandExecutedProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency entity for procedure TestCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency world for procedure TestCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack((new Object() {
				public Item getRandomItem(String _tagName) {
					ITag<Item> _tag = ItemTags.getCollection().getTagByID(new ResourceLocation(_tagName));
					return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
				}
			}.getRandomItem(("all").toLowerCase(java.util.Locale.ENGLISH))), (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent(("" + ((new Object() {
					public Item getRandomItem(String _tagName) {
						ITag<Item> _tag = ItemTags.getCollection().getTagByID(new ResourceLocation(_tagName));
						return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
					}
				}.getRandomItem(("all").toLowerCase(java.util.Locale.ENGLISH)))))), ChatType.SYSTEM, Util.DUMMY_UUID);
		}
	}
}
