package me.niedoogarniecia.essentials.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GamemodeCommand implements Listener, CommandExecutor {
    public String gamemode = "gamemode";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase(gamemode)) {
                GameMode playerGamemode = ((Player) sender).getGameMode();
                if (args.length == 0) {
                    if (!playerGamemode.equals(GameMode.CREATIVE)) {
                        ((Player) sender).setGameMode(GameMode.CREATIVE);
                        sender.sendMessage("§7Your §agamemode §7has been set to §acreative!");
                        return true;
                    } else {
                        sender.sendMessage("§7You are already in §ccreative §7mode.");
                        return true;
                    }
                } else if (args.length == 1) {
                    String firstArg = args[0].toLowerCase();
                    if (firstArg.equals("0") || firstArg.equals("survival")) {
                        if (!playerGamemode.equals(GameMode.SURVIVAL)) {
                            ((Player) sender).setGameMode(GameMode.SURVIVAL);
                            sender.sendMessage("§7Your §agamemode §7has been set to §asurvival!");
                            return true;
                        } else {
                            sender.sendMessage("§7You are already in §csurvival §7mode.");
                            return true;
                        }
                    } else if (firstArg.equals("1") || firstArg.equals("creative")) {
                        if (!playerGamemode.equals(GameMode.CREATIVE)) {
                            ((Player) sender).setGameMode(GameMode.CREATIVE);
                            sender.sendMessage("§7Your §agamemode §7has been set to §acreative!");
                            return true;
                        } else {
                            sender.sendMessage("§7You are already in §ccreative §7mode.");
                            return true;
                        }
                    } else if (firstArg.equals("2") || firstArg.equals("adventure")) {
                        if (!playerGamemode.equals(GameMode.ADVENTURE)) {
                            ((Player) sender).setGameMode(GameMode.ADVENTURE);
                            sender.sendMessage("§7Your §agamemode §7has been set to §aadventure!");
                            return true;
                        } else {
                            sender.sendMessage("§7You are already in §cadventure §7mode.");
                            return true;
                        }
                    } else if (firstArg.equals("3") || firstArg.equals("spectator")) {
                        if (!playerGamemode.equals(GameMode.SPECTATOR)) {
                            ((Player) sender).setGameMode(GameMode.SPECTATOR);
                            sender.sendMessage("§7Your §agamemode §7has been set to §aspectator!");
                            return true;
                        } else {
                            sender.sendMessage("§7You are already in §cspectator §7mode.");
                            return true;
                        }
                    } else if (firstArg.equals("help")) {
                        return false;
                    } else {
                        sender.sendMessage("§7Sorry, §c" + args[0] + " §7isn't a type of §cgamemode.");
                        return true;
                    }
                } else return false;
            } else return false;
        } else {
            sender.sendMessage("§cOnly player can use this command!");
            return true;
        }
    }
}




