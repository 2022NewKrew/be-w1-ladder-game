package laddergame.util;

import org.apache.commons.lang3.StringUtils;

public class Util {
    static public Boolean generateTrueOrFalseByRandom(){
        return Math.random() > 0.5;
    }

    static public String formatStringSize(String input, int size){
        return String.format("%"+size+"s", StringUtils.substring(input,0,size));
    }
}
