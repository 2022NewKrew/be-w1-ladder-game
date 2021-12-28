import java.util.ArrayList;
import java.util.Random;

public class LadderRow {
    private int manCount;
    private int cellCount;
    private ArrayList<LadderCell> row;

    private LadderRow(int manCount) {
        this.manCount = manCount;
        this.cellCount = this.manCount - 1;
        this.row = new ArrayList<>();
    }

    public static LadderRow getInstance(int manCount) {
        LadderRow ladderRow = new LadderRow(manCount);
        ladderRow.makeRow();
        return ladderRow;
    }

    public void makeRow() {
        Random rand = new Random();
        for (int i = 0; i < cellCount; i++)
            row.add(LadderCell.getInstance(rand.nextBoolean()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (LadderCell cell : row) {
            sb.append(cell.toString());
            sb.append("|");
        }
        return sb.toString();
    }
}
