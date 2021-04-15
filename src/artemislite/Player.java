package artemislite;

import javax.naming.InvalidNameException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * represents a player in the system
 */
public class Player extends Actor {
    private static final int MIN_PLAYER_ID = 1;
    private static final int MAX_PLAYER_ID = 4;
    private static final String INVALID_PLAYER_ID = "Invalid player ID";
    private static final String[] INVALID_NAMES = new String[]{"", "quit"};
    private static int playerID = 0;
    private final String name;
    private final SortedSet<SystemSquare> ownedElements = new TreeSet<>(new ComparePosition());
    private int playerResources;

    /**
     * constructor with arguments
     * @param name the player's name
     */
    public Player(String name) throws InvalidNameException {
        super(0);
        if (Arrays.asList(INVALID_NAMES).contains(name)) {
            throw new InvalidNameException();
        } else {
            Player.playerID += 1;
            this.name = name;
            this.playerResources = 500;
        }
    }

    /**
	 * @return the playerID
	 */
	public int getPlayerID() {
		return playerID;
	}

	/**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the playerResources
     */
    public int getPlayerResources() {
        return playerResources;
    }

    /**
     * @return the ownedElements
     */
    public ArrayList<SystemSquare> getOwnedElements() {
        return new ArrayList<>(ownedElements);
    }

    /**
     * gets the player role based on playerID
     * @return the player role
     * @throws IllegalArgumentException if playerID outside bounds
     */
    public String getPlayerRole() throws IllegalArgumentException {
        if (playerID >= MIN_PLAYER_ID && playerID <= MAX_PLAYER_ID) {
            switch(playerID) {
                case 1:
                    return "Commander";
                case 2:
                    return "Command Module Pilot";
                case 3:
                    return "Lunar Module Pilot";
                case 4:
                    return "Docking Module Pilot";
            }
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_ID);
        }
        return null;
    }

    /**
     * updates a player's resources
     * @param delta the change in resources
     */
    public void addResources(int delta) throws BankruptcyException {
        int res = this.playerResources + delta;
        if (res >= 0) {
            this.playerResources += delta;
        } else {
            throw new BankruptcyException("You've gone bankrupt");
        }
    }

    /**
     * develops a square
     * @param square the square to be developed
     */
    public void developElement(SystemSquare square, int devDelta) throws IllegalArgumentException, BankruptcyException {
        try {
            this.addResources(devDelta * square.getCostPerDevelopment() * -1 * (int) (devDelta > 0 ? 1 : 0.5));
            square.setDevelopment(devDelta+square.getDevelopment());
        } catch (IllegalArgumentException e) {
            //undo payment
            this.addResources(devDelta * square.getCostPerDevelopment());
            throw new IllegalArgumentException();
        }
    }

    /**
     * purchases a square
     * @param square the square to be purchased
     */
    public void purchaseSquare(SystemSquare square) throws BankruptcyException {
        this.ownedElements.add(square);
        square.setOwned(true);
        this.addResources(-1 * square.getBaseCost());
    }

    /**
     * purchases a square
     * @param square the square to be purchased
     */
    public void purchaseSquare(SystemSquare square, int cost) throws BankruptcyException {
        this.ownedElements.add(square);
        //this.setPlayerResources(this.playerResources - square.getBaseCost());
        this.addResources(-1 * cost);
    }

    /**
     * removes a square from a players collection
     * @param square the square to remove
     */
    public void removeSquare(SystemSquare square) {
        this.ownedElements.remove(square);
        square.setOwned(false);
    }

    /**
     * get the cost of the cheapest development
     * @return the cost of the cheapest development
     */
    public int getMinimumOwnedDevCost() {
        //the first square will always have the lowest development cost
        return this.ownedElements.first().getCostPerDevelopment();
    }

    /**
     * checks if a player has at least one entire system that isn't completely developed
     * @return the systems or null
     */
    public ArrayList<SystemName> getDevelopableSystems() {
        Map<SystemName, List<SystemSquare>> systems = this.ownedElements.stream()
                .filter(s -> !s.isMortgaged())
                .collect(Collectors.groupingBy(SystemSquare::getSystemNameEnum, Collectors.toList()));
        //remove if incomplete system
        systems.entrySet().removeIf(s -> s.getValue().size() != s.getValue().get(0).getSystemType());
        //remove if fully developed system
        systems.entrySet().removeIf(s -> s.getValue().stream().allMatch(t -> t.getDevelopment() == 4));
        return systems.size() == 0 ? null : new ArrayList<>(systems.keySet());
    }

    /**
     * find out whether the user has any mortgagable elements
     * @return whether the player has at least one element that can be mortgaged
     */
    public boolean hasMortgagableElements() {
        return this.getOwnedElements().stream().filter(s -> s.getDevelopment() == 0).anyMatch(s -> !s.isMortgaged());
    }

    public boolean hasMortgagedElements() {
        return this.getOwnedElements().stream().anyMatch(SystemSquare::isMortgaged);
    }

    /**
     * find out whether the user has any developments
     * @return whether the player has at least one development
     */
    public boolean hasDevelopments() {
        return this.getOwnedElements().stream().anyMatch(s -> s.getDevelopment() > 0);
    }

    /**
     * whether the player is close to going bankrupt or not (less than or equal to 200 credits)
     * @return player resources <= 200
     */
    public boolean goingBankrupt() {
        return this.getPlayerResources() <= 200;
    }
}
