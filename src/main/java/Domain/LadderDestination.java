package Domain;

public class LadderDestination {
    private int start;
    private int dst;

    public LadderDestination(int start, int dst) {
        this.start = start;
        this.dst = dst;
    }

    public int getDst() {
        return this.dst;
    }

}
