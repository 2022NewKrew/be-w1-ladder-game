import java.util.ArrayList;

public class Ladder {

    private int height;
    private int manCount;
    private ArrayList<LadderRow> ladderMap;

    private Ladder(int height, int manCount) {
        this.height = height;
        this.manCount = manCount;
        this.ladderMap = new ArrayList<>();
    }

    public static Ladder getInstance(int height, int manCount) {
        Ladder ladder = new Ladder(height, manCount);
        ladder.makeMap();
        return ladder;
    }

    public void makeMap() {
        for (int i = 0; i < height; i++)
            makeRow(manCount);
    }

    public void makeRow(int manCount) {
        ladderMap.add(LadderRow.getInstance(manCount));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow row : ladderMap) {
            sb.append(row.toString());
            sb.append("\n");
        }
        return sb.toString();
    }


}
