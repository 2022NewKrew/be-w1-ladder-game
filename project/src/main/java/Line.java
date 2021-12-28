import java.util.ArrayList;
import java.util.HashMap;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();
    private HashMap<Boolean,String> convertBoolToString = new HashMap<Boolean,String>(){{
        put(true,"-----|");
        put(false,"     |");
    }};

    public Line(int countOfPerson){
        for(int i=0; i<countOfPerson-1; i++){
            addPoint(Util.generateTrueOrFalseByRandom());
        }
    }

    public void addPoint(Boolean newPoint){
        points.add(checkDoubleStair(newPoint));
    }

    private Boolean checkDoubleStair(Boolean newPoint){
        if(points.size() == 0){
            return newPoint;
        }
        if (points.get(points.size()-1) == true && newPoint == true){
            return false;
        };
        return newPoint;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("  |");
        for(int i = 0; i<points.size(); i++){
            result.append(convertBoolToString.get(points.get(i)));
        }
        return result.toString();
    }
}
