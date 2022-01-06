import java.lang.reflect.Array;
import java.util.Random;
import java.util.ArrayList;

public class LadderClass {

    static Random random = new Random();
    ArrayList listPeople;
    ArrayList ladderArray;
    int printLadderRows;
    int numberPeople;

    LadderClass(ArrayList listPeople, int ladderHeight){
        this.listPeople = listPeople;
        this.numberPeople = listPeople.size();
        this.printLadderRows = ladderHeight;
        ladderArray = new ArrayList<LadderRow>();
    }

    public void assignLadderArray() {
        assignNameRow();
        for (int row = 0; row < printLadderRows; row++) {
            assignLadderRow();
        }
    }

    public void assignNameRow(){
        ladderArray.add(new LadderRow(listPeople));
    }

    public void assignLadderRow(){
        ladderArray.add(new LadderRow(numberPeople));
    }

    public void printLadder(){
        System.out.print("\n");
        for (int row=0; row < ladderArray.size();row++){
            LadderRow printRow = (LadderRow) ladderArray.get(row);
            printRow.printLadderRow();
            System.out.print("\n");
        }
    }
}
