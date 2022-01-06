import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        int maxLadderHeight;
        ArrayList listPeople;

        listPeople = InterfaceClass.getPeopleList();
        maxLadderHeight = InterfaceClass.getLadderHeight();

        LadderClass ladder = new LadderClass(listPeople, maxLadderHeight);
        ladder.assignLadderArray();
        ladder.printLadder();
    }

}
