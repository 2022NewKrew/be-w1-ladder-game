package laddergame.domain;

import laddergame.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private Map<Boolean,String> convertBoolToString = new HashMap<Boolean,String>(){{
        put(true,"-----|");
        put(false,"     |");
    }};

    public Line(int countOfPerson){
        for(int i=0; i<countOfPerson-1; i++){
            addPoint(Util.generateTrueOrFalseByRandom());
        }
    }

    public void addPoint(Boolean newPoint) {
        points.add(isDoubleStair(newPoint));
    }

    private Boolean isDoubleStair(Boolean newPoint){
        if(points.isEmpty()){
            return newPoint;
        }
        if (points.get(points.size()-1) && newPoint){
            return false;
        };
        return newPoint;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("  |");
        for(Boolean point : points){
            result.append(convertBoolToString.get(point));
        }
        return result.toString();
    }
}
