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
        for(int i = 0; i < peopleNum; i++) {
            points.add(getRandomAndNotDuplicate());
        }
    }

    public Boolean getRandomAndNotDuplicate(){
        if(!points.isEmpty() && points.get(points.size() - 1)) return false; //null에러 방지를 위해 선 조건 기입
        return random.nextBoolean();
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
