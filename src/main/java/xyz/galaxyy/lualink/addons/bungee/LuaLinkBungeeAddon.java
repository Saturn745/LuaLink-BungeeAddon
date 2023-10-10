package xyz.galaxyy.lualink.addons.bungee;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.galaxyy.lualink.addons.bungee.functions.SendPlayerFunction;
import xyz.galaxyy.lualink.api.LuaLinkAPI;
import xyz.galaxyy.lualink.api.addons.LuaAddon;

public class LuaLinkBungeeAddon extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        LuaAddon addon = new LuaAddon();

        addon.addFunction("sendPlayer", new SendPlayerFunction(this));

        LuaLinkAPI.Companion.registerAddon("Bungee", addon);
    }
}