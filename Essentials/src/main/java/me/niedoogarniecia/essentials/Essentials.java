package me.niedoogarniecia.essentials;

import me.niedoogarniecia.essentials.commands.GamemodeCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Essentials extends JavaPlugin {

    private GamemodeCommand gamemodeCommand = new GamemodeCommand();
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("\n\n§eEssentials §7has been §aenabled§7!\n\n");
        getCommand(gamemodeCommand.gamemode).setExecutor(gamemodeCommand);

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("\n\n§eEssentials §7has been §cdisabled§7!\n\n");
    }
}
