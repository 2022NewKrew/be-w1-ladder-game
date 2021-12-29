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
        for (int i = 0; i < cellCount; i++)
            row.add(LadderCell.getInstance(decideHorizon(row, i)));
    }

    private boolean decideHorizon(ArrayList<LadderCell> row, int idx) {
        Random rand = new Random();
        if (idx != 0 && row.get(idx - 1).getIsHorizontal()) return false;
        return rand.nextBoolean();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     |");
        for (LadderCell cell : row) {
            sb.append(cell.toString());
            sb.append("|");
        }
        sb.append("     ");
        return sb.toString();
    }
}
