import java.util.ArrayList;

public class LadderRenderer {
    public static void render(Ladder ladder){
        StringBuilder ladderString = new StringBuilder();
        int heightOfLadder = ladder.getInfo().getHeightOfLadder();

        for(int layer = 0; layer < heightOfLadder; layer++) {
            ladderString.append(renderOneLine(ladder.getInfo().getNumOfPeople(), ladder.getConnections(), layer));
        }
        System.out.println(ladderString);
    }

    public static StringBuilder renderOneLine(int numOfPeople, ArrayList<ArrayList<Boolean>> connections, int layer){
        StringBuilder ladderStringOneLine = new StringBuilder();

        for(int person = 0; person < numOfPeople-1; person++){
            ladderStringOneLine.append('|');
            ladderStringOneLine.append(connections.get(layer).get(person) ? "-" : " ");
        }
        ladderStringOneLine.append("|\n");
        return ladderStringOneLine;
    }
}
