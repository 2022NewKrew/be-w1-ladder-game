public class LadderCell {

    private boolean isHorizontal;

    private LadderCell(boolean isHorizontal) {
        this.isHorizontal = isHorizontal;
    }

    public static LadderCell getInstance(boolean isHorizontal) {
        LadderCell ladderCell = new LadderCell(isHorizontal);
        return ladderCell;
    }

    public boolean getIsHorizontal(){
        return isHorizontal;
    }

    public String toString() {
        if (isHorizontal) return "-----";
        return "     ";
    }
}
