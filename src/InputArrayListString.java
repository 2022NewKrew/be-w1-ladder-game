import java.util.ArrayList;

public class InputArrayListString implements Input<ArrayList<String>> {
    private final char DELIMITER = ',';

    public InputArrayListString() {
    }

    public ArrayList<String> getInputValue() {
        String inputValue = scanner.nextLine();
        return makeArrayList(inputValue);
    }

    private ArrayList<String> makeArrayList(String inputValue) {
        ArrayList<String> values = new ArrayList<String>();

        int previousIndex = 0;
        int length = inputValue.length();
        while (previousIndex < length) {
            int currentIndex = getIndexOfDelimiter(inputValue, previousIndex);
            String value = inputValue.substring(previousIndex, currentIndex);
            values.add(value);
            previousIndex = currentIndex + 1;
        }

        return values;
    }

    private int getIndexOfDelimiter(String strings, int startIndex) {
        int index = strings.indexOf(DELIMITER, startIndex);
        if (index == -1)
            return strings.length();

        return index;
    }
}