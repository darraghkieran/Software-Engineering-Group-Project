package artemislite;

import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    SystemName systemName1 = SystemName.EXPLORATION_GROUND_SYSTEM;
    SystemName systemName2 = SystemName.ORION_SPACECRAFT;
    SystemName systemName3 = SystemName.GATEWAY_OUTPOST;
    SystemName systemName4 = SystemName.LUNAR_LANDER;
    int[] devCost = new int[]{0,0,0,0,0};
    int baseCost = 0;
    int costPerDev = 0;
    int difficulty = 0;

    SystemSquare ss1 = new SystemSquare("Square 1",
            1,
            systemName1,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SystemSquare ss2 = new SystemSquare("Square 2",
            2,
            systemName1,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SystemSquare ss3 = new SystemSquare("Square 3",
            3,
            systemName2,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SystemSquare ss4 = new SystemSquare("Square 4",
            4,
            systemName2,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SystemSquare ss5 = new SystemSquare("Square 5",
            5,
            systemName2,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SystemSquare ss6 = new SystemSquare("Square 6",
            7,
            systemName3,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SystemSquare ss7 = new SystemSquare("Square 7",
            8,
            systemName3,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SystemSquare ss8 = new SystemSquare("Square 8",
            9,
            systemName3,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SystemSquare ss9 = new SystemSquare("Square 9",
            10,
            systemName4,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SystemSquare ss10 = new SystemSquare("Square 10",
            11,
            systemName4,
            difficulty,
            baseCost,
            costPerDev,
            devCost);

    SortedSet<SystemSquare> squares = new TreeSet<>(new ComparePosition());

    Player player;

    @Test
    void testGetDevelopableSystemValid() throws InvalidNameException, BankruptcyException {
        player = new Player("Test Player");

        Collections.addAll(squares, ss1, ss2, ss3, ss4, ss5, ss6, ss7, ss8, ss9, ss10);

        for (SystemSquare ss : squares) {
            player.purchaseSquare(ss);
        }

        assertTrue(player.getDevelopableSystems().contains(systemName1));
        assertTrue(player.getDevelopableSystems().contains(systemName2));
        assertTrue(player.getDevelopableSystems().contains(systemName3));
        assertTrue(player.getDevelopableSystems().contains(systemName4));
        squares.clear();
    }

    @Test
    void testGetDevelopableSystemInvalid() throws InvalidNameException, BankruptcyException {
        player = new Player("Test Player");
        Collections.addAll(squares, ss1, ss3, ss4, ss6, ss7, ss9);

        assertNull(player.getDevelopableSystems());

        for (SystemSquare ss : squares) {
            player.purchaseSquare(ss);
            assertNull(player.getDevelopableSystems());
        }

        ArrayList<SystemSquare> finalSystemSquare = new ArrayList<>();
        Collections.addAll(finalSystemSquare, ss2, ss5, ss8, ss10);
        squares.addAll(finalSystemSquare);

        Player player2 = null;
        for (SystemSquare ss : finalSystemSquare) {
            player2 = new Player("Player2");
            player2.purchaseSquare(ss);
            assertNull(player2.getDevelopableSystems());
            for (SystemSquare s : squares) {
                player2.purchaseSquare(s);
                s.setMortgaged(true);
                //set the finalSystemSquare to mortgaged if it matches the square name in squares (ie system completed)
                ss.setMortgaged(finalSystemSquare.stream().noneMatch(e -> e.getSquareName().equals(s.getSquareName())));
                assertNull(player2.getDevelopableSystems());
            }
        }

        player2 = new Player("Player 2");
        for (SystemSquare s : squares) {
            player2.purchaseSquare(s);
            s.setDevelopment(4);
        }
        assertNull(player2.getDevelopableSystems());
    }
}