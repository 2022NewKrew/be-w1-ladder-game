public class LadderFactory {

    public LadderFactory() {

    }

    public Ladder buildLadder(int peopleSize, int height) {
        return new Ladder(peopleSize, height);
    }
}
