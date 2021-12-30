package domain;

import exception.IllegalInputException;

import java.util.List;

public class Ladder{
    // 세로 라인
    private final List<Line> lines;
    private final int ladderHeight;

    private final List<Participant> participants;

    private final StringBuilder shape;

    public Ladder(List<Participant> participants, List<Result> results, int ladderHeight){
        shape = new StringBuilder();

        this.participants = participants;
        this.ladderHeight = ladderHeight;
        lines = LadderMaker.build(participants, results, ladderHeight);
        makeShape();
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public String getShape(){
        return shape.toString();
    }

    public List<Line> getLines(){
        return lines;
    }

    public List<Participant> getParticipants(){
        return participants;
    }

    public String getResultByParticipant(String name){
        return lines
                .stream()
                .filter(line -> line.getParticipant().getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalInputException("없는 참가자입니다."))
                .getResult(0)
                .getName();
    }

    private void makeShape(){
        for (int currentHeight = 0; currentHeight < ladderHeight; currentHeight++)
            makeRow(currentHeight);
    }

    private void makeRow(int curHeight){
        shape.append("   ");
        lines.stream()
                .map(line -> mapBar(line, curHeight))
                .forEach(shape::append);
        shape.append("\n");
    }

    private String mapBar(Line line, int curHeight){
        if (line.getConnections()[curHeight] != null
                && line.getLineNum() < line.getConnections()[curHeight].getLineNum())
            return "|-----";
        return "|     ";
    }
}