import java.util.*;

public class Line {
    private static final Random random = new Random();

    private final List<Point> points = new ArrayList<>();

    public Line(int numOfPeople) {
        int pointCnt = numOfPeople - 1;
        createLine(pointCnt);
    }

    private void createLine(int pointCnt) {
        for (int i = 0; i < pointCnt; i++) {
            points.add(new Point(random.nextBoolean()));
        }
        validatePoints();
    }

    private void validatePoints(){
        for(int i=0; i< points.size(); i++){
            checkLeftPoint(i);
        }
    }

    private void checkLeftPoint(int index){
        int leftIndex = index -1;
        if(leftIndex < 0) return;
        if(points.get(leftIndex).isStep()) updatePoint(index);
    }

    private void updatePoint(int index){
        points.get(index).removeStep();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
