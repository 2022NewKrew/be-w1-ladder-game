import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private int numOfPeople;
    private int height;
    private ArrayList<ArrayList<String>> ladder = new ArrayList<ArrayList<String>>();

    Ladder(int numOfPeople, int height) {
        this.numOfPeople = numOfPeople;
        this.height = height;
        setLadder();
    }

    private void setLadder() {
        Random random = new Random();
        for(int i = 0; i < height; ++i) {
            ArrayList<String> temparray = new ArrayList<String>();
            temparray.add("|");
            for(int j = 1; j < numOfPeople; ++j) {
                String temp = random.nextBoolean() ? "-" : " ";
                temparray.add(temp);
                temparray.add("|");
            }
            ladder.add(temparray);
        }
    }

    public void show() {
        for (ArrayList<String> row : ladder) {
            for (String el : row) {
                System.out.print(el);
            }
            System.out.println();
        }
    }

}
