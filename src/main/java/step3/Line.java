package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
	private static final Random RANDOM = new Random();

	private List<String> line;
	private boolean isPrevConnected;

	public Line(int numberOfPlayer) {
		line = new ArrayList<>();
		isPrevConnected = false;

		makeLine(numberOfPlayer);
	}

	public void makeLine(int numberOfPlayer) {
		for (int player = 0; player < numberOfPlayer; player++) {
			line.add(LadderLineStyle.VERTICAL_LINE.getShape());
			line.add(getHorizontalLine(player, numberOfPlayer));
		}
	}

	private String getHorizontalLine(int player, int numberOfPlayer) {
		if (player == numberOfPlayer - 1) {
			return LadderLineStyle.EMPTY.getShape();
		}

		if (isPrevConnected) {
			isPrevConnected = false;
			return LadderLineStyle.HORIZONTAL_EMPTY.getShape();
		}

		return getRandomHorizontalLine();
	}

	private String getRandomHorizontalLine() {
		boolean connect = RANDOM.nextBoolean();

		if (connect) {
			isPrevConnected = true;
			return LadderLineStyle.HORIZONTAL_LINE.getShape();
		}

		return LadderLineStyle.HORIZONTAL_EMPTY.getShape();
	}

	public void printLine() {
		for (String line : line) {
			System.out.print(line);
		}

		System.out.println();
	}
}
