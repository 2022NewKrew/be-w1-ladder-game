import controller.LadderGameController;

public class LadderGame {

    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController();
        controller.initializeLadderFromCli();
        controller.showLadder();
    }
}
