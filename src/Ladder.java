import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ladder {
    private final int nPeople;
    private final int maxHeight;
    private final ArrayList<Line> arr;

    private static final char strStep = '-';
    private static final char strEmpty = ' ';
    private static final char strCol = '|';
    private static final int maxNameLength = 5;

    //constructor
    public Ladder(LadderConfig ladderConfig) {
        this.nPeople = ladderConfig.getNumPeople();
        this.maxHeight = ladderConfig.getMaxHeight();
        this.arr = new ArrayList<Line>();

        buildLines();

        //buildColumns();
        //buildSteps();
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getNumPeople() {
        return this.nPeople;
    }

    public int getMaxNameLength() {
        return maxNameLength;
    }

    public ArrayList<Line> getLadderList() {
        return this.arr;
    }



    //line 생성
    public void buildLines() {
        for(int i=0; i<this.maxHeight; i++){
            Line line = new Line(this.nPeople);
            this.arr.add(line);
        }
    }




//  not used !!

//    // build base columns '|'
//    public void buildColumns() {
//
//        //this.arr = new char[this.maxHeight][this.nCol];
//
//        for (int i=0; i<this.maxHeight; i++) {
//            buildColumnsPerRow(i);
//        }
//    }
//
//    // build base columns for each row
//    public void buildColumnsPerRow(int i) {
//        for (int j=0; j<this.nCol; j+=2) {
//            this.arr[i][j] = strCol;
//        }
//    }
//
//
//    // build steps '-'
//    public void buildSteps() {
//        for (int i=0; i<this.maxHeight; i++) {
//            buildStepsPerRow(i);
//        }
//    }
//
//    // build base steps for each row
//    public void buildStepsPerRow(int i) {
//        for (int j=1; j<this.nCol; j+=2) {
//            buildStepsPerCell(i,j);
//        }
//    }


}