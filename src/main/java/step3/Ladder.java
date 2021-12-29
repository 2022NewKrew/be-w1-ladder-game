package step3;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private int numberOfPlayer;
	private int ladderHeight;
	private List<Line> ladder;

	public Ladder(int numberOfPlayer, int ladderHeight) {
		this.numberOfPlayer = numberOfPlayer;
		this.ladderHeight = ladderHeight;
	}

	public void makeLadder() {
		ladder = new ArrayList<>();

		for (int height = 0; height < ladderHeight; height++) {
			ladder.add(new Line(numberOfPlayer));
		}
	}

	public void printLadder() {
		for (Line line : ladder) {
			line.printLine();
		}
	}
}
