package xyz.unix.tpa;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.command.*;
public class App extends JavaPlugin {
    Map<String, String> map = new HashMap<>();
    @Override
    public void onEnable() {
        getLogger().info("im doing meth");
        
    }
    @Override
    public void onDisable() {
        getLogger().info("brb gotta go get more meth");
    }
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            // Here we need to give items to our player
            if(label.equals("tpa")) {
                String tpaTarget = args[0];
                Player target = Bukkit.getPlayer(tpaTarget);
                target.sendMessage("[unix tpa] "+player.getDisplayName()+" wants to tp to you. /tpy to acept, /tpn to deny.");
                player.sendMessage("[unix tpa] ok tpa request sent to "+target.getDisplayName());
                map.put(target.getDisplayName(),player.getDisplayName());
            }
            if(label.equals("unixtpa")) {
                player.sendMessage("version 1.2\nmade by @UnixSynth on twitter (Unix™#0001 on discord)\nthe most average tpa plugin ever lol\nthis took too long but tbh this is my 1st plugin ever");
            }
            if(label.equals("tpy")){
                String sussy = map.get(player.getDisplayName());
                Player sus = Bukkit.getPlayer(sussy);
                //@EventHandler
                //public void onPlayerJoin(PlayerJoinEvent event) {
                    //sus.getWorld(), -16.5, 67, -22.5, 0, 0
                //Location loc = new Location(sus.getLocation());
                sus.teleport(player.getLocation());
                sus.sendMessage("[unix tpa] ok teleported yuo :)");
                player.sendMessage("[unix tpa] ok theyre here now");
                //}
                //
                //FORMAT
                //Code (Text):
                //Location loc = new Location(Bukkit.getWorld("WORLDNAME"), x, y, z, y, p);
                //WORLDNAME = Name of world you want to teleport the player to
                //X = X coordinate
                //Y = Y coordinate
                //Z = Z coordinate
                //Y = Yaw
            }
            if(label.equals("tpn")){
                String sussy = map.get(player.getDisplayName());
                Player sus = Bukkit.getPlayer(sussy);
                player.sendMessage("[unix tpa] ok, teleport denied.");
                sus.sendMessage("[unix tpa] they said no");
            }
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
        
    }
    
}