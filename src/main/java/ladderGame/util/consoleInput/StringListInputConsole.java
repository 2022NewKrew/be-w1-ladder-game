package ladderGame.util.consoleInput;

import ladderGame.util.TypeConverter;

import java.util.List;

public class StringListInputConsole extends InputConsole<List<String>> {

    @Override
    public List<String> convert(String inputStr) {
        return TypeConverter.strToStringList(inputStr);
    }
}
