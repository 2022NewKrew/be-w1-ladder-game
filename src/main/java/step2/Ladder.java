package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
	private static final char VERTICAL_LINE = '|';
	private static final char HORIZONTAL_LINE = '-';
	private static final char EMPTY = ' ';
	private static final Random RANDOM = new Random();

	private List<Character>[] ladder;
	private int numberOfPlayer;
	private int ladderHeight;

	public Ladder(int numberOfPlayer, int ladderHeight) {
		this.numberOfPlayer = numberOfPlayer;
		this.ladderHeight = ladderHeight;
	}

	public void makeLadder() {
		ladder = new ArrayList[ladderHeight];

		for (int height = 0; height < ladderHeight; height++) {
			ladder[height] = new ArrayList<>();
			makeLine(height);
		}
	}

	private void makeLine(int height) {
		for (int player = 0; player < numberOfPlayer; player++) {
			ladder[height].add(VERTICAL_LINE);
			ladder[height].add(getRandomCross(player, numberOfPlayer));
		}
	}

	private char getRandomCross(int player, int numberOfPlayer) {
		if (player == numberOfPlayer - 1) {
			return EMPTY;
		}

		boolean isEmpty = RANDOM.nextBoolean();

		return isEmpty ? EMPTY : HORIZONTAL_LINE;
	}

	public void printLadder() {
		for (int height = 0; height < ladderHeight; height++) {
			printLine(height);
		}
	}

	private void printLine(int height) {
		for (char ch : ladder[height]) {
			System.out.print(ch);
		}

		System.out.println();
	}
}
