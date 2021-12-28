import java.util.Random;

public class LadderFactory {

    public LadderFactory() {}

    public void generateLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getLadderCount(); i++) {
            StringBuilder tempLadderLine = new StringBuilder();
            makeLadderLine(tempLadderLine, ladder.getPeopleCount()-1);
            ladder.addLadderLine(tempLadderLine);
        }

    }

    public void makeLadderLine(StringBuilder ladderLine, int count){
        Random random = new Random();
        for(int i=0; i<count; i++){
            ladderLine.append(random.nextBoolean() ? "|-" : "| ");
        }
        ladderLine.append("|");
    }
}
