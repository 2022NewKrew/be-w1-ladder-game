package ladderGame.view;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/*
*   사다리 한 줄에 관한 class 입니다.
*   한 줄에 각 칸에 발판이 있는지 여부를 담고있는 points 필드와
*   한 줄을 생성하는 메소드가 있습니다.
* */
public class Line {
    private static final Random random = new Random();
    private final List<Boolean> points; // 각 칸에 발판이 있는지 여부

    Line(int numberOfPlayers) {
        points = new ArrayList(numberOfPlayers - 1);
        for(int i = 0; i < numberOfPlayers - 1; i++) {
            points.add(generateBar(i));
        }
    }

    private final Boolean generateBar(int idx) { // 발판이 연속하지 않는지 확인하고 랜덤 Boolean 생성
        if(idx != 0 && points.get(idx-1)) // 옆에 발판이 이미 존재하는 경우
            return false;

        return random.nextBoolean();
    }

    public final List<Boolean> getPoints() { return points; }
}