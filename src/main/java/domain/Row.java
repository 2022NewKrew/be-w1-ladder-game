package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.LadderLineStyle;

public class Row {
	private static final Random RANDOM = new Random();

	private final List<LadderLineStyle> ladderLineStyleList;
	private boolean isPrevConnected;

	public Row() {
		ladderLineStyleList = new ArrayList<>();
		isPrevConnected = false;
	}

	public List<LadderLineStyle> getLadderLineStyleList() {
		return ladderLineStyleList;
	}

	public void prevConnected() {
		isPrevConnected = true;
	}

	public void makeLine(int numberOfPlayer) {
		for (int player = 0; player < numberOfPlayer; player++) {
			ladderLineStyleList.add(LadderLineStyle.VERTICAL_LINE);
			ladderLineStyleList.add(getHorizontalLine(player, numberOfPlayer));
		}
	}

	private LadderLineStyle getHorizontalLine(int player, int numberOfPlayer) {
		if (player == numberOfPlayer - 1) {
			return LadderLineStyle.EMPTY;
		}

		if (isPrevConnected) {
			isPrevConnected = false;
			return LadderLineStyle.HORIZONTAL_EMPTY;
		}

		return getRandomHorizontalLine();
	}

	private LadderLineStyle getRandomHorizontalLine() {
		boolean isConnectable = RANDOM.nextBoolean();

		if (isConnectable) {
			isPrevConnected = true;
			return LadderLineStyle.HORIZONTAL_LINE;
		}

		return LadderLineStyle.HORIZONTAL_EMPTY;
	}

	public String printRow() {
		StringBuilder sb = new StringBuilder();

		for (LadderLineStyle ladderLineStyle : ladderLineStyleList) {
			sb.append(ladderLineStyle.getShape());
		}

		return sb.toString();
	}
}
