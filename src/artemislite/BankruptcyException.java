package artemislite;

public class BankruptcyException extends Exception {
    private static final long serialVersionID = 1L;

    public BankruptcyException(String message) {
        super(message);
    }
}
