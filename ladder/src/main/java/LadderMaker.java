import java.util.ArrayList;
import java.util.Random;

public class LadderMaker {
    private static final Random random = new Random();

    public static ArrayList<ArrayList<Boolean>> build(int columnMax, int rowMax){
        ArrayList<ArrayList<Boolean>> ladderShape = new ArrayList<>();
        for (int row = 0; row < rowMax; row++)
            ladderShape.add(createRow(row, columnMax));
        return ladderShape;
    }

    private static ArrayList<Boolean> createRow(int row, int columnMax){
        ArrayList<Boolean> ladderShape = new ArrayList<>();
        for (int column = 0; column < columnMax; column++)
            ladderShape.add(isAlreadyConnected(ladderShape, column) && random.nextBoolean());
        return ladderShape;
    }

    private static boolean isAlreadyConnected(ArrayList<Boolean> row, int column){
        if (column == 0)
            return true;
        return !row.get(column-1);
    }
}
