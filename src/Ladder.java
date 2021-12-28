import java.util.ArrayList;

public class Ladder {

    // instance variable
    private int peopleCount;
    private int ladderCount;
    private ArrayList<StringBuilder> ladder;

    // Constructor
    public Ladder(int peopleCount, int ladderCount){
        this.peopleCount = peopleCount;
        this.ladderCount = ladderCount;
        this.ladder = new ArrayList<>();
    }

    public void addLadderLine(StringBuilder ladderLine){
        this.ladder.add(ladderLine);
    }

    public void printLadder(){
        for (int i = 0; i < this.ladderCount; i++) {
            System.out.println(ladder.get(i));
        }
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getLadderCount() {
        return ladderCount;
    }
}
