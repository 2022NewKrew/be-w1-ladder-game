package domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> points;
    public static Random random = new Random();

    Line (int peopleNum) {
        points = new ArrayList<>();
        getPoint(peopleNum);
    }

    public void getPoint(int peopleNum) {
        for(int i = 0; i < peopleNum - 1; i++) {
            points.add(getRandomAndNotDuplicate());
        }
    }

    public Boolean getRandomAndNotDuplicate(){
        if(pointsIsNotEmpty() && pointsLastTrue()) return false;
        return random.nextBoolean();
    }

    public Boolean pointsIsNotEmpty(){
        return !points.isEmpty();
    }

    public Boolean pointsLastTrue(){
        int lastindex = points.size() - 1;
        return points.get(lastindex);
    }

    public String isLine(Boolean point){
        if(point) return "-----";
        return "     ";
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("  ");
        for(Boolean point:points) {
            s.append("|");
            s.append(isLine(point));
        }
        s.append("|");
        return s.toString();
    }
}
