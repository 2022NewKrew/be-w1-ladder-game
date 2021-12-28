import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    int number;
    int height;
    List<Object> ladderResult = new ArrayList<>();

    public Ladder(int number, int height) {
        this.number = number;
        this.height = height;
    }

    public void setLadder() {
        Random random = new Random();
        for(int i=0; i<height; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            for(int j=0; j<number-1; j++) {
                if (random.nextInt(2) == 1) {
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
                sb.append("|");
            }
            ladderResult.add(sb.toString());
        }
    }

    public void printLadder() {
        for(int i=0; i<height; i++) {
            System.out.println(ladderResult.get(i));
        }
    }
}
