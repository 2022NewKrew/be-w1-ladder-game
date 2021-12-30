package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private final int numberOfPlayer;
	private final int ladderHeight;
	private final List<Row> rowList;

	public Ladder(int numberOfPlayer, int ladderHeight) {
		this.numberOfPlayer = numberOfPlayer;
		this.ladderHeight = ladderHeight;
		rowList = new ArrayList<>();
	}

	public int getNumberOfPlayer() {
		return numberOfPlayer;
	}

	public int getLadderHeight() {
		return ladderHeight;
	}

	public List<Row> getRowList() {
		return rowList;
	}

	public void makeLadder() {
		for (int height = 0; height < ladderHeight; height++) {
			Row row = new Row();
			row.makeLine(numberOfPlayer);
			rowList.add(row);
		}
	}

	public String printLadder() {
		StringBuilder sb = new StringBuilder();

		for (Row row : rowList) {
			sb.append(row.printRow() + "\n");
		}

		return sb.toString();
	}
}
