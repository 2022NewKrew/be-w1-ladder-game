package laddergame.domain;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private Boolean isStair;
    private Map<Boolean,String> convertBoolToString = new HashMap<Boolean,String>(){{
        put(true,"-----|");
        put(false,"     |");
    }};

    public Point(Boolean isStair){
        this.isStair = isStair;
    }

    public Boolean getIsStair(){
        return isStair;
    }

    public void setIsStair(Boolean isStair){
        this.isStair = isStair;
    }

    public String toString(){
        return convertBoolToString.get(isStair);
    }
}
