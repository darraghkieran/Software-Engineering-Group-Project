package artemislite;

/**
 * represents a square on the board
 */
public class Square {
    private String squareName;
    private int position;
    private String message;

    public Square(String squareName, int position, String message) {
        this.squareName = squareName;
        this.position = position;
        this.message = message;
    }

    /**
     * @return the squareName
     */
    public String getSquareName() {
        return squareName;
    }

    /**
     * @param squareName the squareName to set
     */
    public void setSquareName(String squareName) {
        this.squareName = squareName;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * prints the squares message
     */
    public void printMessage() {
        System.out.println(this.message);
    }
}
