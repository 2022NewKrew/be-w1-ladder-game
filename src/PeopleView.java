import java.util.ArrayList;

public class PeopleView {
    private final int MAX_NAME_LENGTH = 5;
    private final String LEFT_MARGIN = "  ";
    private final String BLANK = " ";

    private ArrayList<String> people;

    public PeopleView(ArrayList<String> people) {
        this.people = people;
    }

    public void print() {
        printMargin();
        int count = people.size();
        for (int i = 0; i < count; i++) {
            String name = people.get(i);
            printName(name);
        }
        System.out.println();
    }

    private void printMargin() {
        System.out.print(LEFT_MARGIN);
    }

    private void printName(String name) {
        int length = name.length();
        int defaultBlankSize = (int) ((MAX_NAME_LENGTH - length) / 2);
        int preBlankSize = getPreBlankSize(length, defaultBlankSize);
        int postBlankSize = defaultBlankSize + 1;

        printBlank(preBlankSize);
        System.out.print(name);
        printBlank(postBlankSize);
    }

    private int getPreBlankSize(int length, int defaultBlankSize) {
        Boolean isEven = length % 2 == 0;
        if (isEven)
            return defaultBlankSize + 1;

        return defaultBlankSize;
    }

    private void printBlank(int count) {
        for (int i = 0; i < count; i++)
            System.out.printf(BLANK);
    }
}
