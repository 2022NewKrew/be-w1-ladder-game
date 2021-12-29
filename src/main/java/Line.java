import java.util.ArrayList;
import java.util.Random;

public class Line {
    private final String VERTICAL_LINE = "|";
    private final int nameLength = 5;
    private final String BAR = "-".repeat(nameLength);
    private final String BLANK = " ".repeat(nameLength);

    private ArrayList<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        Random random = new Random();
        points.add(random.nextInt(3) == 0);
        for (int i = 1 ; i < countOfPerson - 1 ; i++) {
            points.add(random.nextBoolean() && !points.get(i - 1));
        }
    }

    public String printLine(int countOfPerson) {
        StringBuilder stringBuilder = new StringBuilder("  ");
        stringBuilder.append(VERTICAL_LINE);
        for (int i = 0 ; i < countOfPerson - 1 ; i++) {
            stringBuilder.append(printBarOrBlank(points.get(i)));
            stringBuilder.append(VERTICAL_LINE);
        }
        return stringBuilder.toString();
    }

    private String printBarOrBlank(Boolean point) {
        if (point) {
            return BAR;
        }
        return BLANK;
    }
}
