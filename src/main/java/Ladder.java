import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;
    private final String[] namePeople;

    private static final String VLINE = "|";
    private static final String HLINE = "-----";
    private static final String SPACE = "     ";

    public Ladder(String[] namePeople, int numPeople, int maxHeight){
        ladder = new ArrayList<>();
        this.namePeople = namePeople;
        makeLadder(numPeople, maxHeight);
    }

    private void makeLadder(int numPeople, int maxHeight) {
        for (int i = 0; i < maxHeight; i++) {
            ladder.add(new Line(numPeople));
        }
    }
    public String makeStringLadder(){
        StringBuilder stringLadder = new StringBuilder();
        for (Line line : ladder) {
            stringLadder.append("  ");
            makeHorizontalLine(line, stringLadder);
            stringLadder.append(VLINE).append("\n");
        }
        return stringLadder.toString();
    }

    private static void makeHorizontalLine(Line line, StringBuilder stringLadder){
        for(int j = 0; j< line.getPoints().size(); j++){
            stringLadder.append(VLINE).append(isLadder(line,j));
        }
    }

    private static String isLadder(Line line, int j){
        return line.getPoints().get(j)? HLINE : SPACE;
    }

    public String[] getNamePeople() {
        return namePeople;
    }
}

