public class LadderFactory {

    public static Ladder buildLadder(int peopleSize, int height) {
        return new Ladder(peopleSize, height);
    }
}
