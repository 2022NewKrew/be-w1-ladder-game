import java.util.ArrayList;

public class LadderRenderer {
    public void render(Ladder ladder){
        int heightOfLadder = ladder.getInfo().getHeightOfLadder();
        for(int layer = 0; layer < heightOfLadder; layer++)
            renderOneLine(ladder.getInfo().getNumOfPeople(), ladder.getConnections(), layer);
    }

    public void renderOneLine(int numOfPeople, ArrayList<ArrayList<Boolean>> connections, int layer){
        for(int person = 0; person < numOfPeople-1; person++){
            System.out.print('|');
            System.out.print(connections.get(layer).get(person) ? "-" : " ");
        }
        System.out.println("|");
    }
}
