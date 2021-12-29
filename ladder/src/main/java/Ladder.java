import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder{
    // 세로 라인
    private final List<Line> lines;
    private final int ladderHeight;

    public Ladder(List<Participant> participants, int numOfLadderHeight){
        this.ladderHeight = numOfLadderHeight;
        lines = LadderMaker.build(participants, numOfLadderHeight);
    }

    public int getLadderHeight(){
        return ladderHeight;
    }

    public List<Line> getLines(){
        return lines;
    }
}