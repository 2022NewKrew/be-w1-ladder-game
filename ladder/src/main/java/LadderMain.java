import controller.GameController;
import view.GameInputOutputManager;

public class LadderMain {
    public static void main(String[] args){
        GameInputOutputManager gameInputOutputManager = new GameInputOutputManager();
        GameController gameController = new GameController(gameInputOutputManager);
        gameController.startGame();
    }
}
