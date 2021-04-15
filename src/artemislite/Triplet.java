package artemislite;

public class Triplet<A, B, C> {
    private final A first;
    private final B second;
    private final C third;

    public Triplet(A first, B second, C third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * @return the first
     */
    public A getFirst() {
        return first;
    }

    /**
     * @return the second
     */
    public B getSecond() {
        return second;
    }

    /**
     * @return the third
     */
    public C getThird() {
        return third;
    }
}
