package domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> cells;
    public static Random random = new Random();

    Line (int peopleNum) {
        cells = new ArrayList<>();
        generatePoint(peopleNum);
    }

    public ArrayList<Boolean> getCells(){
        return this.cells;
    }

    public void generatePoint(int peopleNum) {
        for(int i = 0; i < peopleNum - 1; i++) {
            cells.add(generateCellNotDuplicate());
        }
    }

    public Boolean generateCellNotDuplicate(){
        if(cellsIsFill() && isLastCells()) return false;
        return random.nextBoolean();
    }

    public Boolean cellsIsFill(){
        return !cells.isEmpty();
    }

    public Boolean isLastCells(){
        int lastindex = cells.size() - 1;
        return cells.get(lastindex);
    }

    public String isLine(Boolean point){
        if(point) return "-----";
        return "     ";
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("  ");
        for(Boolean point:cells) {
            s.append("|");
            s.append(isLine(point));
        }
        s.append("|");
        return s.toString();
    }
}