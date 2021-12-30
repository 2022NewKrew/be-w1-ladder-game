package domain.generator;

import domain.Ladder;
import util.Message;

public class LadderGenerator extends InputGenerator {
	public static Ladder generate(int numberOfPlayer) throws Exception {
		System.out.println(Message.LADDER_HEIGHT_INPUT_MESSAGE);
		int ladderHeight = Integer.parseInt(InputGenerator.BR.readLine());

		Ladder ladder = new Ladder(numberOfPlayer, ladderHeight);
		ladder.makeLadder();

		return ladder;
	}
}
