package step2LadderGame.util.consoleInput;

import step2LadderGame.util.TypeConverter;

import java.util.List;

public class StringListInputConsole extends InputConsole<List<String>> {

    @Override
    public List<String> convert(String inputStr) {
        return TypeConverter.strToStringList(inputStr);
    }
}
