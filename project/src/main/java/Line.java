import java.util.ArrayList;
import java.util.HashMap;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();
    private HashMap<Boolean,String> convertBoolToString = new HashMap<Boolean,String>(){{
        put(true,"-|");
        put(false," |");
    }};

    public Line(int countOfPerson){
        for(int i=0; i<countOfPerson-1; i++){
            points.add(Util.generateTrueOrFalseByRandom());
        }
    }

    public String printLine(){
        StringBuilder result = new StringBuilder("|");
        for(int i = 0; i<points.size(); i++){
            result.append(convertBoolToString.get(points.get(i)));
        }
        return result.toString();
    }
}
