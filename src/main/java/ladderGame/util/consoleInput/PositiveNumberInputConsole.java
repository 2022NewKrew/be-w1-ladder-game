package ladderGame.util.consoleInput;

import ladderGame.util.TypeConverter;

public class PositiveNumberInputConsole extends InputConsole<Integer> {

    @Override
    public Integer convert(String inputStr) {
        return TypeConverter.strToInteger(inputStr);
    }
}
