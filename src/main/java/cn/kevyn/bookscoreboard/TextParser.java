package cn.kevyn.bookscoreboard;

import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;

public class TextParser {

    public static String parseText(Player player, String text) {
        if (BookScoreBoard.INSTANCE.hasPlaceHolderAPI) {
            return PlaceholderAPI.setPlaceholders(player, text);
        }
        else {
            return text;
        }
    }
    
}
