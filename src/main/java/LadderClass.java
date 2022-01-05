import java.util.Random;

public class LadderClass {

    static Random random = new Random();
    char[][] ladderArray;

    LadderClass(int numberPeople, int ladderHeight){
        int printLadderColumns;
        int printLadderRows;

        printLadderColumns = numberPeople + numberPeople -1;
        printLadderRows = ladderHeight;
        ladderArray = new char[printLadderRows][printLadderColumns];
    }

    public void assignLadderArray() {
        for (int row = 0; row < ladderArray.length; row++) {
            assignLadderRow(row);
        }
    }

    public void assignLadderRow(int row){
        for (int col = 0; col < ladderArray[row].length; col++) {
            assignLadderElement(row, col);
        }
    }

    public void assignLadderElement(int row, int col){
        if (col%2 == 1){
            ladderArray[row][col] = assignRandomBridge();
            return;
        }
        ladderArray[row][col] = '|';
    }

    public char assignRandomBridge(){
        return (random.nextBoolean()) ? '-' : ' ';
    }

    public void printLadder(){
        for (int row = 0; row < ladderArray.length; row++){
            System.out.println(ladderArray[row]);
        }
    }

}
