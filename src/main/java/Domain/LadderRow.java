package Domain;

public class LadderRow {
    private int manCount;
    private int cellCount;
    private LadderCells ladderCells;

    public LadderRow(int manCount) {
        this.manCount = manCount;
        this.cellCount = this.manCount - 1;
        this.ladderCells = new LadderCells(cellCount);
    }

    public LadderCells getLadderCells() {
        return ladderCells;
    }

    public String toString() {
        return ladderCells.toString();
    }

    public int calCol(int dst) {
        return ladderCells.calCol(dst);
    }

    public int size() {
        return ladderCells.size();
    }
}
