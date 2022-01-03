import domain.LadderGame;
import view.View;


public class App {
    public static void main(String[] args) {
        View view = new View();
        LadderGame ladderGame = view.createLadderGameByPrompt();
        view.print(ladderGame);
    }
}
