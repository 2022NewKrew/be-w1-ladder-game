package domain;

import java.util.ArrayList;
import java.util.List;

import util.LadderLineStyle;

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

	public int goLadder(int index) {
		int cur = index;

		for (int height = 0; height < ladderHeight; height++) {
			List<LadderLineStyle> ladderLineStyleList = rowList.get(height).getLadderLineStyleList();

			ladderLineStyleList.get(cur);

			//왼쪽
			int left = cur - 1;
			int right = cur + 1;

			if (left >= 0 && ladderLineStyleList.get(left) == LadderLineStyle.HORIZONTAL_LINE) {
				cur = cur - 2;
			}

			//오른쪽
			if (right < numberOfPlayer * 2 && ladderLineStyleList.get(right) == LadderLineStyle.HORIZONTAL_LINE) {
				cur = cur + 2;
			}
		}

		return cur;
	}

	public String printLadder() {
		StringBuilder sb = new StringBuilder();

		for (Row row : rowList) {
			sb.append(row.printRow() + "\n");
		}

		return sb.toString();
	}
}
