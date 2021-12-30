package step2LadderGame.util.consoleInput;

import step2LadderGame.util.TypeConverter;

public class PositiveNumberInputConsole extends InputConsole<Integer> {

    @Override
    public Integer convert(String inputStr) {
        return TypeConverter.strToInteger(inputStr);
    }
}
