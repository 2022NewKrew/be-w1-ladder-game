import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    static public Boolean generateTrueOrFalseByRandom(){
        if (Math.random() > 0.5){
            return true;
        }
        return false;
    }

    static public String resizeString(String input, int maxSize){
        if(input.length()>maxSize){
            return input.substring(0, maxSize);
        }
        return input;
    }
}
