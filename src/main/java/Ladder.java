import java.util.Random;
import java.util.ArrayList;

public class Ladder {
    private final int numOfPeople;
    private final int heightOfLadder;
    ArrayList<ArrayList<Boolean>> connections = new ArrayList<ArrayList<Boolean>>();

    public Ladder(int NumOfPeople, int HeightOfLadder) {
        this.numOfPeople = NumOfPeople;
        this.heightOfLadder = HeightOfLadder;
        makeConnections();
    }

    public void makeConnections() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for(int layer = 1; layer<= heightOfLadder; layer++){
            ArrayList<Boolean> temp = new ArrayList<Boolean>();
            for(int person = 1; person< numOfPeople; person++)
                temp.add(random.nextBoolean());
            connections.add(temp);
        }
    }

    public void draw(){
        System.out.println(connections);
        for(int layer = 0; layer < heightOfLadder; layer++){
            for(int person = 0; person < numOfPeople-1; person++) {
                System.out.print('|');
                if(connections.get(layer).get(person)){
                    System.out.print('-');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println("|");
        }
    }
}