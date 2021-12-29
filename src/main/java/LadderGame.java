import domain.Ladder;
import view.LadderRenderer;

public class LadderGame {
    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        LadderRenderer ladderRenderer = new LadderRenderer(ladder);
        ladderRenderer.printAll();
    }
}


