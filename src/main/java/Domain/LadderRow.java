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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     |");
        for (LadderCell cell : ladderCells) {
            sb.append(cell.toString());
            sb.append("|");
        }
        sb.append("     ");
        return sb.toString();
    }

    public LadderCells getLadderCells() {
        return ladderCells;
    }

    public LadderCell get(int idx) {
        if (idx < 0 || this.ladderCells.size() <= idx) return null;
        return ladderCells.get(idx);
    }

    public int calCol(int dst) {
        return ladderCells.calCol(dst);
    }

    public int size() {
        return ladderCells.size();
    }
}
