import java.util.ArrayList;


public class Ladder {
    private final int nPeople;
    private final int maxHeight;
    private final String[] peopleNames;
    private final ArrayList<Line> arr;


    private static final int maxNameLength = 5;

    //constructor
    public Ladder(LadderConfig ladderConfig) {
        this.nPeople = ladderConfig.getNumPeople();
        this.maxHeight = ladderConfig.getMaxHeight();
        this.peopleNames =ladderConfig.getPeopleNames();
        this.arr = new ArrayList<Line>();

        buildLines();
    }


    public String[] getPeopleNames() {
        return this.peopleNames;
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


=======
import java.util.Arrays;
import java.util.Random;

public final class Ladder {
    private final int nPeople;
    private final int maxHeight;
    private char[][] arr;
    private final int nCol;
    Random random = new Random();


    //constructor
    public Ladder(int n, int m) {
        this.nPeople = n;
        this.maxHeight = m;
        this.nCol = 2 * n -1;

        buildColumns();
        buildSteps();
    }

    // build base columns '|'
    public void buildColumns() {

        this.arr = new char[this.nCol][maxHeight];

        for (int i=0; i<this.maxHeight; i++) {
            buildColumnsPerRow(i);
        }
    }

    // build base columns for each row
    public void buildColumnsPerRow(int i) {
        for (int j=0; j<this.nCol; j+=2) {
            this.arr[i][j]='|';
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
        for (int j=1; j<this.maxHeight; j+=2) {
            buildStepsPerCell(i,j);
        }
    }

    // build base steps for each cell
    public void buildStepsPerCell(int i, int j){
        float random_float = random.nextFloat();

        if (random_float <0.5) { // make each step by 50% probability
            this.arr[i][j] = '-';
            return;
        }
        this.arr[i][j]=' ';
    }

    // print ladder as string
    public void printLadder() {

        for (char[] row : this.arr) {
            String strRow = readRow(row);
            System.out.println(strRow);

        }
    }

    // read row as string
    public String readRow( char[] row) {
        StringBuilder sb = new StringBuilder();
        for (char ch : row) {
            sb.append(ch);
        }
        String strRow = sb.toString();
        return strRow;
    }
