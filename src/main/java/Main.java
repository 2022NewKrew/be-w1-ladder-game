import controller.LadderGame;
import domain.Ladder;
import domain.Player;
import domain.Result;
import domain.generator.LadderGenerator;
import domain.generator.PlayerGenerator;
import domain.generator.ResultGenerator;

public class Main {
	public static void main(String[] args) throws Exception {
		Player player = PlayerGenerator.generate();
		Ladder ladder = LadderGenerator.generate(player.getNumberOfPlayer());
		Result result = ResultGenerator.generate();

		LadderGame ladderGame = new LadderGame(player, ladder, result);

		ladderGame.printLadderGame();
		ladderGame.startLadderGame();
	}
}
