package Domain;

public class LadderCell {

    private boolean isHorizontal;

    public LadderCell(boolean isHorizontal) {
        this.isHorizontal = isHorizontal;
    }

    public boolean getIsHorizontal() {
        return isHorizontal;
    }

    public String toString() {
        if (isHorizontal) return "-----";
        return "     ";
    }
}
