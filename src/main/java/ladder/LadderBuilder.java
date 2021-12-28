package ladder;

public class LadderBuilder {

    public LadderBuilder() {
    }

    public static Ladder createLadder(int width, int height) throws IllegalArgumentException{
        Ladder ladder = new Ladder()
                .width(width)
                .height(height)
                .buildLadder();
        return ladder;
    }
}
