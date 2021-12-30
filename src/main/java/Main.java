import controller.LadderGame;
import domain.Ladder;
import domain.Player;
import domain.generator.LadderGenerator;
import domain.generator.PlayerGenerator;

public class Main {
	public static void main(String[] args) throws Exception {
		Player player = PlayerGenerator.generate();
		Ladder ladder = LadderGenerator.generate(player.getNumberOfPlayer());

		LadderGame ladderGame = new LadderGame(player, ladder);

		ladderGame.printLadderGame();
	}
}
