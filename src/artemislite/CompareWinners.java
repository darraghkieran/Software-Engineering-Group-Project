package artemislite;

import java.util.Comparator;

public class CompareWinners implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        int p1worth = Game.calculateNetWorth(p1);
        int p2worth = Game.calculateNetWorth(p2);
        // sort by cash and property value
        if (p1worth - p2worth != 0) {
            return Game.calculateNetWorth(p1) - Game.calculateNetWorth(p2);
        } else {
            // if tied, sort by property value
            return (p1worth - p1.getPlayerResources()) - (p2worth - p2.getPlayerResources());
        }
    }
}
