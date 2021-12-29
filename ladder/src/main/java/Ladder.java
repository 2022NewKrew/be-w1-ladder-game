import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ladder{
    // 연결되는 곳 true, 아닌 곳 false 로 저장
    private final ArrayList<ArrayList<Boolean>> ladderShape;
    private final int numOfParticipants;
    private final int numOfLadderHeight;

    public Ladder(int numOfParticipants, int numOfLadderHeight){
        this.numOfParticipants = numOfParticipants;
        this.numOfLadderHeight = numOfLadderHeight;

        ladderShape = LadderMaker.build(numOfParticipants - 1, numOfLadderHeight);
    }

    public ArrayList<ArrayList<Boolean>> getLadderShape(){
        return ladderShape;
    }
}