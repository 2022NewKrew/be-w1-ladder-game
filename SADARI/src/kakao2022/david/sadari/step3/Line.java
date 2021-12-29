package kakao2022.david.sadari.step3;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final ArrayList<Boolean> points = new ArrayList<>();
    private boolean isPrevLine;

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++){
            points.add(isLine());
        }
    }

    private boolean isLine(){
        if (random.nextBoolean() && !isPrevLine){
            isPrevLine = true;
            return true;
        }
        isPrevLine = false;
        return false;
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}
