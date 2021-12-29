import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private int numberOfPlayer;
	private int ladderHeight;
	private List<Row> rowList;

	public Ladder(int numberOfPlayer, int ladderHeight) {
		this.numberOfPlayer = numberOfPlayer;
		this.ladderHeight = ladderHeight;
	}

	public void makeLadder() {
		rowList = new ArrayList<>();

		for (int height = 0; height < ladderHeight; height++) {
			rowList.add(new Row(numberOfPlayer));
		}
	}

	public void printLadder() {
		for (Row row : rowList) {
			row.printRow();
		}
	}
}
