package cn.kevyn.bookscoreboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.ItemStack;

public class BSBHandler {

    public static BSBHandler INSTANCE = new BSBHandler();
    boolean enabled;
    Map<String, ItemStack> playerBooks = new HashMap<String,ItemStack>();
    private String bookTitle;
    private String bookAuthor;
    private List<String> bookPages = new ArrayList<>();

    public void loadConfig() {
        bookPages.clear();
        BookScoreBoard bsb = BookScoreBoard.INSTANCE;
        enabled = bsb.getConfig().getBoolean("enable");
        bookTitle = bsb.getConfig().getString("book-title");
        bookAuthor = bsb.getConfig().getString("book-author");
        int pageNum = 1;
        while(bsb.getConfig().contains("page-" + pageNum)) {
            List<String> pageContent = bsb.getConfig().getStringList("page-" + pageNum);
            String stringnifiedPageContent = "";
            for (String pageLine : pageContent) {
                stringnifiedPageContent += pageLine;
                stringnifiedPageContent += "\n";
            }
            bookPages.add(stringnifiedPageContent);
            pageNum ++;
        }
    }

    public void openBook(Player player) {
        ItemStack book = playerBooks.get(player.getName());
        BookMeta bookMeta = (BookMeta)book.getItemMeta();
        bookMeta.setTitle(TextParser.parseText(player, bookTitle));
        bookMeta.setAuthor(TextParser.parseText(player, bookAuthor));
        List<String> playerPages = new ArrayList<>();
        for(String page : bookPages) {
            playerPages.add(TextParser.parseText(player, page));
        }

        bookMeta.setPages(playerPages);
        book.setItemMeta(bookMeta);
        player.openBook(book);

    }

}
