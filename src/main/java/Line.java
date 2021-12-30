import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    private static final Random rand = new Random();
    private final List<Boolean> points = new ArrayList<>();
    private static final String VLINE = "|";
    private static final String HLINE = "-----";
    private static final String SPACE = "     ";
    private static final String PADDING = "  ";

    public Line(int numPeople){
        for (int i = 0; i < numPeople-1; i++) {
            addPoints(i);
        }
    }
    @Override
    public String toString(){
        return PADDING + VLINE
                + points.stream()
                .map(p -> p ? HLINE : SPACE)
                .collect(Collectors.joining(VLINE))
                + VLINE;
    }
    private void addPoints(int i){
        if(isNextLadder(i)){
            points.add(false);
            return;
        }
        points.add(rand.nextBoolean());
    }

    private boolean isNextLadder(int i){
        return i==0? false: points.get(i - 1);
    }
}
