import java.util.ArrayList;
import java.util.Random;

public class LadderRow {
    static Random random = new Random();
    private ArrayList ladderRowList = new ArrayList<>();

    public LadderRow(int countOfPerson) {
        ladderRowList.add('|');
        for (int people=1; people < countOfPerson; people++){
            ladderRowList.add(assignRandomBridge());
            ladderRowList.add('|');
        }
    }

    public LadderRow(ArrayList nameList){
        for (int people=0; people < nameList.size(); people++){
            ladderRowList.add(assignNameBridge((String) nameList.get(people)));
        }
    }

    public String assignRandomBridge(){
        return (random.nextBoolean()) ? "----" : "    ";
    }

    public String assignNameBridge(String people){
        return people + " ".repeat(5 - people.length());
    }

    public void printLadderRow(){
        for (int col = 0; col < ladderRowList.size(); col++){
            System.out.print(ladderRowList.get(col));
        }
    }
}