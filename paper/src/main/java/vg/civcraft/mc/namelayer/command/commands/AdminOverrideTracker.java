package vg.civcraft.mc.namelayer.command.commands;

import co.aikar.commands.annotation.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import vg.civcraft.mc.namelayer.GroupManager;
import vg.civcraft.mc.namelayer.NameAPI;
import vg.civcraft.mc.namelayer.NameLayerPlugin;
import vg.civcraft.mc.namelayer.command.BaseCommandMiddle;
import vg.civcraft.mc.namelayer.database.GroupManagerDao;
import vg.civcraft.mc.namelayer.group.Group;
import vg.civcraft.mc.namelayer.permission.GroupPermission;
import vg.civcraft.mc.namelayer.permission.PermissionType;

import java.util.List;
import java.util.UUID;

public class AdminOverrideTracker extends BaseCommandMiddle{

	@CommandAlias("nlptsn")
	@CommandPermission("namelayer.admin")
	@Syntax("[player name] [new #]")
	@Description("This command forcibly alters the playertracker table, changing the uuid-# pair.")
	public void execute(Player sender, String playerName, String number) {
		int num = Integer.parseInt(number);

		if(!sender.isOp()){
			sender.sendMessage("You must be an operator");
			return;
		}

		GroupManagerDao groupManagerDao = NameLayerPlugin.getGroupManagerDao();
		groupManagerDao.trackforce(Bukkit.getPlayer(playerName).getUniqueId(),num);

	}

}
