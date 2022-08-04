package cn.kevyn.bookscoreboard;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BSBCommand implements CommandExecutor {

    public static BSBCommand INSTANCE = new BSBCommand();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if (command.getName().equals("bsb-reload")) {
            BookScoreBoard.INSTANCE.reloadPlugin();
            return true;
        }

        else if (command.getName().equals("bsb-open")) {
            if ((sender instanceof Player)) {
                BSBHandler.INSTANCE.openBook((Player)sender);
                return true;
            }
        }

        return false;
    }
    
}
