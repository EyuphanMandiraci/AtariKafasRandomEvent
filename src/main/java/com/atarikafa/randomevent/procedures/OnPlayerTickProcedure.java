package com.atarikafa.randomevent.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.Map;
import java.util.HashMap;

import com.atarikafa.randomevent.AtarikafasRandomEventModVariables;
import com.atarikafa.randomevent.AtarikafasRandomEventModElements;
import com.atarikafa.randomevent.AtarikafasRandomEventMod;

@AtarikafasRandomEventModElements.ModElement.Tag
public class OnPlayerTickProcedure extends AtarikafasRandomEventModElements.ModElement {
	public OnPlayerTickProcedure(AtarikafasRandomEventModElements instance) {
		super(instance, 5);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency entity for procedure OnPlayerTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency x for procedure OnPlayerTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency y for procedure OnPlayerTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency z for procedure OnPlayerTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtarikafasRandomEventMod.LOGGER.warn("Failed to load dependency world for procedure OnPlayerTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((AtarikafasRandomEventModVariables.WorldVariables.get(world).event_timer) == 1)) {
			if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("lava_ceiling"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					LavaCeilingProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nLava Suffocate"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("zombie_raid"))) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager()
							.handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"difficulty normal");
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					ZombieRaidProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nZombie Raid"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("water_suffocate"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					WaterSuffocateProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nWater Suffocate"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("block_suffocate"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					BlockSuffocateProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nBlock Suffocate"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("kill_all"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					KillAllProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nKill ALL!"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("swap_x_z"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					SwapXZProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nSwap X and Z"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("go_to_space"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					GoToSpaceProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nY + 250"), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("anvil_fall"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					AnvilFallProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nAnvils Are Coming"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("give_diamond"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					GiveDiamondProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nDiamonds To You!"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("rich_rain"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					RichRainProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nRichie Rich's Rain"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("extra_health"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					ExtraHealthProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nNot at all!"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("protection"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					ProtectionEffectProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nPROTEGO MAXIMA!"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			} else if ((((AtarikafasRandomEventModVariables.MapVariables.get(world).event)).equals("fly_but_no_damage"))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					FlyButNoDamageProcedure.executeProcedure($_dependencies);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76Started Event: \u00A70\u00A7nI believe you can fly!"),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
