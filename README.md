# Bungee Addon for LuaLink

The Bungee addon provides functionality to send players from one server to another using LuaLink. This functionality is particularly useful for networked Minecraft servers running on platforms like Bungeecord, Waterfall, or Velocity.

## Usage

1. **Importing the Addon:**

    To use the Bungee addon, first obtain the addon instance:
    
    ```lua
    local Bungee = addons.get("Bungee")
    ```

2. **Sending a Player to Another Server:**

    Use the `sendPlayer` function to teleport a player to another server:
    
    ```lua
    Bungee.sendPlayer(playerObject, "SERVER_NAME")
    ```

    Replace `"SERVER_NAME"` with the target server's name where you want to send the player.

## Compatibility

- **Velocity:**
  For Velocity support, ensure that Bungee messaging channels are enabled in the Velocity configuration.

## Example

Here's a simple example demonstrating how to send a player to another server:

```lua
-- Import the Bungee addon
local Bungee = addons.get("Bungee")

script.registerSimpleCommand(function(sender, args)
    if not utils.instanceOf(sender, "org.bukkit.entity.Player") then
      sender:sendRichMessage("<red>This command can only be ran by a player!")
    end
    Bungee.sendPlayer(sender, "Hub") -- Sends the sender to a server with the name "Hub"
end, {
    name = "hub"
})
