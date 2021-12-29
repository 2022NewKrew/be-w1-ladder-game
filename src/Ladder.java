import java.util.Arrays;
import java.util.Random;

public class Ladder {
    private final int nPeople;
    private final int maxHeight;
    private static char[][] arr;
    private final int nCol;
    private static final Random random = new Random();

    private static final char strStep = '-';
    private static final char strEmpty = ' ';
    private static final char strCol = '|';

    //constructor
    public Ladder(LadderConfig ladderConfig) {
        this.nPeople = ladderConfig.getNumPeople();
        this.maxHeight = ladderConfig.getMaxHeight();
        this.nCol = 2 * this.nPeople -1;
        buildColumns();
        buildSteps();
    }

    public char[][] getCharArr() {
        return this.arr;
    }

    // build base columns '|'
    public void buildColumns() {

        this.arr = new char[this.maxHeight][this.nCol];

        for (int i=0; i<this.maxHeight; i++) {
            buildColumnsPerRow(i);
        }
    }

    // build base columns for each row
    public void buildColumnsPerRow(int i) {
        for (int j=0; j<this.nCol; j+=2) {
            this.arr[i][j] = strCol;
        }
    }


    // build steps '-'
    public void buildSteps() {
        for (int i=0; i<this.maxHeight; i++) {
            buildStepsPerRow(i);
        }
    }

    // build base steps for each row
    public void buildStepsPerRow(int i) {
        for (int j=1; j<this.nCol; j+=2) {
            buildStepsPerCell(i,j);
        }
    }

    // build base steps for each cell
    public void buildStepsPerCell(int i, int j){
        float randomFloat = random.nextFloat();

        if (randomFloat <0.5) { // make each step by 50% probability
            this.arr[i][j] = strStep;
            return;
        }
        this.arr[i][j] = strEmpty;
    }


}