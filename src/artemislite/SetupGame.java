package artemislite;

import javax.naming.InvalidNameException;
import java.util.*;

/**
 * @author mark
 *
 */
public class SetupGame {
	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 4;

	public static List<Player> playerCreation(Scanner scanner) {
		System.out.println("How many crew members would like to play?\nEnter a number between " + MIN_PLAYERS + " and " + MAX_PLAYERS + ".");
		int numPlayers = Game.scanIntInput(scanner, MIN_PLAYERS, MAX_PLAYERS, false);

		Game.clearScreen();
		System.out.println(" ");
		System.out.println("Enter the names of the " + numPlayers + " crew members.\nPress return after entering a name.");

		ArrayList<Player> players = new ArrayList<>();
		boolean validPlayerName = false;
		int count = 1;

		do {
			do {
				String name = null;
				try {
					System.out.printf("%d. ", count);
					name = scanner.nextLine();
					// add new player to players if the name is unique
					String finalName = name.substring(0, 1).toUpperCase() + name.substring(1);
					if (players.stream().noneMatch(p -> p.getName().equals(finalName))) {
						players.add(new Player(finalName));
						validPlayerName = true;
						count++;
					} else {
						throw new InvalidNameException();
					}
				} catch (InvalidNameException e) {
					System.out.printf("%s is not a valid name. Try again.\n", name);
				}
			} while (!validPlayerName);
		} while (players.size() < numPlayers);
		return players;
	}

	public static ArrayList<Square> setupBoard() {
		ArrayList<Square> squares = new ArrayList<>();
		Square sq1 = new Square("Mission Control", 0, "Pass Go, Collect 200! or something ...");

		SystemSquare ss1 = new SystemSquare("Astronaut Training",
				1,
				SystemName.EXPLORATION_GROUND_SYSTEM,
				1,
				80,
				50,
				//		  0dev, 1dev,  2dev,  3dev, MjDev
				new int[] { 20, 60, 180, 320, 450 });

		SystemSquare ss2 = new SystemSquare("Launch Facilities",
				2,
				SystemName.EXPLORATION_GROUND_SYSTEM,
				1,
				100,
				200,
				new int[] { 30, 90, 270, 400, 550 });

		SystemSquare ss3 = new SystemSquare("SLS Booster Testing",
				3,
				SystemName.ORION_SPACECRAFT,
				2,
				150,
				200,
				new int[] { 40, 100, 300, 450, 600 });

		SystemSquare ss4 = new SystemSquare("Lunar Payload Services",
				4,
				SystemName.ORION_SPACECRAFT,
				2,
				120,
				150,
				new int[]  { 40, 100, 300, 450, 600 });

		SystemSquare ss5 = new SystemSquare("Navigation Control",
				5,
				SystemName.ORION_SPACECRAFT,
				2,
				140,
				150,
				new int[] { 50, 150, 450, 625, 750 });

		Square sq2 = new Square("Nothing", 6, "Missed launch window");

		SystemSquare ss6 = new SystemSquare("Core Stage",
				7,
				SystemName.GATEWAY_OUTPOST,
				3,
				160,
				200,
				new int[] { 60, 180, 500, 700, 900 });

		SystemSquare ss7 = new SystemSquare("Solid Rocket Boosters",
				8,
				SystemName.GATEWAY_OUTPOST,
				3,
				160,
				200,
				new int[] { 60, 180, 500, 700, 900 });

		SystemSquare ss8 = new SystemSquare("Spun Stage",
				9,
				SystemName.GATEWAY_OUTPOST,
				3,
				180,
				200,
				new int[] { 70, 200, 550, 750, 950 });

		SystemSquare ss9 = new SystemSquare("Moon Gateway Station",
				10,
				SystemName.LUNAR_LANDER,
				4,
				200,
				200,
				new int[] { 80, 220, 600, 800, 1000 });

		SystemSquare ss10 = new SystemSquare("Tranquility Base",
				11,
				SystemName.LUNAR_LANDER,
				4,
				220,
				200,
				new int[] { 90, 250, 700, 875, 1050 });

		Collections.addAll(squares, sq1, ss1, ss2, ss3, ss4, ss5, sq2, ss6, ss7, ss8, ss9, ss10);
		squares.sort(new ComparePosition());
		return squares;
	}
}
