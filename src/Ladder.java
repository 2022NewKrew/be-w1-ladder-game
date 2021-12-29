import java.util.*;

public class Ladder {

    private final int participant;
    private final int height;
    private final List<String> names;
    private final ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(List<String> participantNames, int ladderHeight) {
        participant = participantNames.size();
        height = ladderHeight;
        names = participantNames;
        makeLadder();
    }

    public void makeLine() {
        Line line = new Line(participant);
        ladder.add(line);
    }

    public void makeLadder() {
        for (int lineIndex = 0; lineIndex < height; lineIndex++) {
            makeLine();
        }
    }

    public void printNames() {
        for(int participantIndex = 0; participantIndex < participant; participantIndex ++) {
            System.out.printf("%"+"-5"+"s ", names.get(participantIndex));
        }
        System.out.println();
    }

    public void printLadder() {
        for (Line line : ladder) {
            line.printLine(participant);
        }
    }
}