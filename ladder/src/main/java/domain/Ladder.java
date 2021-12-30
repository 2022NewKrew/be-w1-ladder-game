package domain;

import java.util.List;

public class Ladder{
    // 세로 라인
    private final List<Line> lines;
    private final int ladderHeight;

    public Ladder(List<Participant> participants, List<Result> results, int numOfLadderHeight){
        this.ladderHeight = numOfLadderHeight;
        lines = LadderMaker.build(participants, results, numOfLadderHeight);
    }

    public int getLadderHeight(){
        return ladderHeight;
    }

    public List<Line> getLines(){
        return lines;
    }
}