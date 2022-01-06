import java.util.ArrayList;
import java.util.Random;

public class LadderRow {
    static Random random = new Random();
    private ArrayList ladderRowList = new ArrayList<>();
    int countOfPerson = 0;

    public LadderRow(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        for (int people=0; people < countOfPerson; people++){
            assignElement(people);
        }
    }

    public LadderRow(ArrayList nameList){
        for (int people=0; people < nameList.size(); people++){
            ladderRowList.add(assignNameBridge((String) nameList.get(people)));
        }
    }

    public void assignElement(int index){
        if (index == countOfPerson-1){
            ladderRowList.add('|');
            return;
        }
        if (index == 0){
            ladderRowList.add('|');
            ladderRowList.add(assignRandomBridge());
            return;
        }
        if (index > 0 && ladderRowList.get(2*index-1) == "    "){
            ladderRowList.add('|');
            ladderRowList.add(assignRandomBridge());
            return;
        }
        ladderRowList.add('|');
        ladderRowList.add(assignBlankBridge());
    }

    public String assignRandomBridge(){
        return (random.nextBoolean()) ? "----" : "    ";
    }

    public String assignBlankBridge(){
        return "    ";
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