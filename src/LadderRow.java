import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow{
    private static final Random random = new Random();
    private final List<Boolean> row = new ArrayList<>();

    public LadderRow(int width){
        for (int j = 0; j < width - 1; j++) {
            row.add(random.nextBoolean());
        }
    }
    public List<Boolean> getRow(){
        return row;
    }
}
