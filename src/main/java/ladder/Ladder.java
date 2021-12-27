package ladder;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private int width;
    private int height;
    private ArrayList<StringBuilder> ladder;

    public Ladder() {
    }

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Ladder width(int width) {
        this.width = width;
        return this;
    }

    public Ladder height(int height) {
        this.height = height;
        return this;
    }

    public Ladder buildLadder(){
        ladder = new ArrayList<>(height);
        for(int i = 0; i < height; i++) {
            ladder.add(createFloor());
        }
        return this;
    }

    private StringBuilder createFloor() {
        StringBuilder floor = new StringBuilder();
        for (int i = 0; i < width * 2 - 1; i++) {
            if(i % 2 == 0) floor.append("|");
            else floor.append(decideConnect());
        }
        return floor;
    }

    private String decideConnect() {
        Random random = new Random();
        int randNum = random.nextInt(2);
        if(randNum == 1) return "-";
        return " ";
    }

    public void print() {
        //변수명 고민 depth? level? floor?
        for (StringBuilder floor : ladder) {
            System.out.println(floor);
        }
    }
}


