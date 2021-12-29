import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder{
    // 연결되는 곳 true, 아닌 곳 false 로 저장
    private final ArrayList<ArrayList<Boolean>> ladderShape;
    private final List<Participant> participants;
    private final int numOfLadderHeight;

    public Ladder(List<Participant> participants, int numOfLadderHeight){
        this.participants = participants;
        this.numOfLadderHeight = numOfLadderHeight;

        ladderShape = LadderMaker.build(participants, numOfLadderHeight);
    }

    public List<Participant> getParticipants(){
        return participants;
    }

    public ArrayList<ArrayList<Boolean>> getLadderShape(){
        return ladderShape;
    }
}