package step3.domain;

import java.util.*;

public class Line {

    private List<Boolean> points;
    private int countOfPoint;
    private static final Random random = new Random();

    public Line (int countOfPerson) {
        this.countOfPoint = countOfPerson-1;
        points = new ArrayList<Boolean>(countOfPoint);
        makeLine();
    }

    private void makeLine(){
        //bar, blank 구분을 위한 변수, true는 bar, false는 blank
        boolean isBar = false;
        for(int i=0;i<countOfPoint;i++){
            //bar==true, 이전에 bar였기에 !isBar에서 false
            //bar==false, 이전에 blank였기에 nextBoolean으로 판단
            isBar = !isBar && random.nextBoolean();
            points.add(isBar);
        }
    }

    public List<Boolean> getPoints(){
        return this.points;
    }
}