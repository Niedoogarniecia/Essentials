package me.niedoogarniecia.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffectType;

import static java.lang.Math.round;

public class HealCommand implements Listener, CommandExecutor {
//      /heal
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                healPlayer(sender, (Player) sender);
            } else {
                sender.sendMessage("§cConsole can't heal itself LOL");
            }
            return true;
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                healPlayer(sender, target);
            } else {
                sender.sendMessage("§cCouldn't find a player");
            }
            return true;
        } else return false;
    }

    private void healPlayer(CommandSender sender, Player target) {
        double targetsHealth = target.getHealth();
        double targetsHunger = target.getFoodLevel();
        final int MAX_HEALTH = 20;
        final int MAX_HUNGER = 20;
        if (targetsHealth != MAX_HEALTH || targetsHunger != MAX_HUNGER || target.getFireTicks() > 0 || target.hasPotionEffect(PotionEffectType.POISON)) {
            double healedFor = (MAX_HEALTH - round(targetsHealth)) / 2D;
            double fedFor = (MAX_HUNGER - round(targetsHunger)) / 2D;
            target.removePotionEffect(PotionEffectType.POISON);
            target.setHealth(MAX_HEALTH);
            target.setFoodLevel(MAX_HUNGER);
            target.setFireTicks(0);
            if (!sender.equals(target)) {
                target.sendMessage("§7You have been §dhealed §7for §d" + healedFor + " ❤ §7and fed for §e" + fedFor + "♦ §7by §6" + sender.getName());
                sender.sendMessage("§7You succesfully §ahealed §7 §a" + target.getName());
            } else {
                target.sendMessage("§7You §dhealed §7yourself for §d" + healedFor + " ❤ §7and fed for §e" + fedFor + "♦");
            }
        } else {
            if (sender.equals(target)) {
                sender.sendMessage("§7You are already §chealed");
            } else {
                sender.sendMessage("§7" + target.getName() + "is already §chealed");
            }
        }
    }
}