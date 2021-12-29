package validator;

import java.util.List;

public class Validator {
    public static void checkPositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNameLength(List<String> participantsNames){
        participantsNames.forEach(Validator::checkNameLengthUnder5);
    }

    private static void checkNameLengthUnder5(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException();
        }
    }
}
