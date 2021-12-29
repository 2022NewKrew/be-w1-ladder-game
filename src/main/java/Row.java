import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Row {
	private static final Random RANDOM = new Random();

	private List<LadderLineStyle> ladderLineStyleList;
	private boolean isPrevConnected;

	public Row(int numberOfPlayer) {
		ladderLineStyleList = new ArrayList<>();
		isPrevConnected = false;

		makeLine(numberOfPlayer);
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
		boolean connect = RANDOM.nextBoolean();

		if (connect) {
			isPrevConnected = true;
			return LadderLineStyle.HORIZONTAL_LINE;
		}

		return LadderLineStyle.HORIZONTAL_EMPTY;
	}

	public void printRow() {
		for (LadderLineStyle ladderLineStyle : ladderLineStyleList) {
			System.out.print(ladderLineStyle.getShape());
		}

		System.out.println();
	}
}
