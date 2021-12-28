package ladder;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final int width;
    private final int height;
    private ArrayList<StringBuilder> ladder;

    public Ladder(int width, int height) {
        if(width < 1) throw new IllegalArgumentException("참여인원이 잘못 입력되었습니다.");
        if(height < 1) throw new IllegalArgumentException("높이가 잘못 입력되었습니다.");
        this.width = width;
        this.height = height;
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
        for (StringBuilder floor : ladder) {
            System.out.println(floor);
        }
    }
}


