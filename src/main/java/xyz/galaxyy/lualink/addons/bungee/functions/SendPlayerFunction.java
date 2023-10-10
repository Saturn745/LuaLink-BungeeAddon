package xyz.galaxyy.lualink.addons.bungee.functions;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;
import xyz.galaxyy.lualink.addons.bungee.LuaLinkBungeeAddon;

public final class SendPlayerFunction extends TwoArgFunction {
    private final LuaLinkBungeeAddon plugin;

    public SendPlayerFunction(LuaLinkBungeeAddon plugin) {
        this.plugin = plugin;
    }
    @Override
    public LuaValue call(LuaValue lplayer, LuaValue serverName) {
        Player player = (Player) lplayer.touserdata(Player.class);
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName.tojstring());
        player.sendPluginMessage(this.plugin, "BungeeCord", out.toByteArray());
        return LuaValue.NIL;
    }
}
