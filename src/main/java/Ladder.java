import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    public static final String LINE_VERTICAL = "|";
    public static final String LINE_HORIZONTAL_TRUE = "-";
    public static final String LINE_HORIZONTAL_FALSE = " ";
    private final int NUMBER;
    private final int HEIGHT;
    private final List<Object> LADDER_RESULT = new ArrayList<>();

    public Ladder(int number, int height) {
        this.NUMBER = number;
        this.HEIGHT = height;
        setLadder();
    }

    private String isLineHorizontal(boolean isLine) {
        if (isLine) {
            return LINE_HORIZONTAL_TRUE;
        }
        return LINE_HORIZONTAL_FALSE;
    }

    private void addLine(StringBuilder sb, String line) {
        sb.append(line);
    }

    private void setLadder() {
        Random random = new Random();
        for (int i = 0; i < HEIGHT; i++) {
            StringBuilder sb = new StringBuilder();
            addLine(sb, LINE_VERTICAL);
            for (int j = 0; j < NUMBER - 1; j++) {
                addLine(sb, isLineHorizontal(random.nextBoolean()));
                addLine(sb, LINE_VERTICAL);
            }
            LADDER_RESULT.add(sb.toString());
        }
    }

    public void printLadder() {
        for (int i = 0; i < HEIGHT; i++) {
            System.out.println(LADDER_RESULT.get(i));
        }
    }
}
