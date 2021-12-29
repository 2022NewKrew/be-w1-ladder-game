package ladderGame;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Line {
    private static final Random random = new Random();
    private List<Boolean> points; // 각 칸에 발판이 있는지 여부

    Line(int numberOfPlayers) {
        points = new ArrayList(numberOfPlayers - 1);
        for(int i = 0; i < numberOfPlayers - 1; i++) {
            points.add(generateBar(i));
        }
    }

    private Boolean generateBar(int idx) { // 발판이 연속하지 않는지 확인하고 랜덤 Boolean 생성
        if(idx != 0 && points.get(idx-1)) // 옆에 발판이 이미 존재하는 경우
            return false;

        return random.nextBoolean();
    }

    public final void print() {
        System.out.print("   ");
        for(Boolean exist : points) {
            System.out.print("|");
            printBar(exist);
        }
    }

    private final void printBar(Boolean exist) {
        if(exist) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }
}