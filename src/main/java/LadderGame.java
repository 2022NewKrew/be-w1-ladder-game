import domain.Ladder;
import view.LadderGameStarter;
import view.LadderRenderer;

public class LadderGame {
    private static final int MAX_NAME_LENGTH = 5;

    public static void main(String[] args) {
        LadderGameStarter starter = new LadderGameStarter(MAX_NAME_LENGTH);
        String[] people = starter.getPeople();
        int heightOfLadder = starter.getHeightOfLadder();

        Ladder ladder = new Ladder(people, heightOfLadder);

        LadderRenderer renderer = new LadderRenderer(MAX_NAME_LENGTH);
        renderer.render(ladder.getPeople(), ladder.getConnections());
    }
}
