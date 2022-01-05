import java.util.Random;

public class LadderClass {

    char[][] ladderArray;
    static Random random = new Random();

    LadderClass(int numberPeople, int ladderHeight){
        int printLadderColumns;
        int printLadderRows;

        printLadderColumns = numberPeople + numberPeople -1;
        printLadderRows = ladderHeight;
        ladderArray = new char[printLadderRows][printLadderColumns];
    }

    public void assignLadderArray(){

        for (int row = 0; row < ladderArray.length; row++){
            for (int col = 0; col< ladderArray[row].length; col++){
                if (col%2 == 1){
                    ladderArray[row][col] = assignRandomBridge(random);
                }
                else{
                    ladderArray[row][col] = '|';
                }
            }
        }
    }

    public char assignRandomBridge(Random random){
        return (random.nextBoolean()) ? '-' : ' ';
    }

    public void printLadder(){
        for (int row = 0; row < ladderArray.length; row++){
            for (int col = 0; col< ladderArray[row].length; col++){
                System.out.print(ladderArray[row][col]);
            }
            System.out.print("\n");
        }
    }

}
