import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final int NUMBER;
    private final int HEIGHT;
    private final List<Object> LADDER_RESULT = new ArrayList<>();

    public Ladder(int number, int height) {
        this.NUMBER = number;
        this.HEIGHT = height;
    }

    public void setLadder() {
        Random random = new Random();
        for(int i=0; i<HEIGHT; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            for(int j=0; j<NUMBER-1; j++) {
                if (random.nextInt(2) == 1) {
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
                sb.append("|");
            }
            LADDER_RESULT.add(sb.toString());
        }
    }

    public void printLadder() {
        for(int i=0; i<HEIGHT; i++) {
            System.out.println(LADDER_RESULT.get(i));
        }
    }
}
