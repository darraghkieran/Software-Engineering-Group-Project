package artemislite;

import java.util.Comparator;

public class ComparePosition implements Comparator<Square> {
    @Override
    public int compare(Square s1, Square s2) {
        return s1.getPosition() - s2.getPosition();
    }
}
