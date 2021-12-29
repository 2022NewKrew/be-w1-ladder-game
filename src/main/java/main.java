import ladder.domain.Ladder;
import ladder.service.LadderService;
import ladder.view.LadderController;

public class main {

    public static void main(String[] args) { startGame(); }

    public static void startGame() {

        Ladder ladder = new Ladder();
        LadderService ladderService = new LadderService(ladder);
        LadderController ladderController = new LadderController(ladderService);

        ladderController.startGame();

    }

}
