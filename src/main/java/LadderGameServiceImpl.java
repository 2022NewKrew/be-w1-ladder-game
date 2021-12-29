import java.util.Random;

public class LadderGameServiceImpl implements LadderGameService {

    private final Random randomInstance = new Random();

    @Override
    public boolean[][] createLadderMap(int row, int col) {

        boolean[][] ladderMap = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            ladderMap[i] = createFloorMap(col);
        }

        return ladderMap;
    }

    private boolean[] createFloorMap(int col) {
        boolean[] map = new boolean[col];
        for (int j = 0; j < col; j++) {
            map[j] = trueAndFalseGenerator();
        }

        return map;
    }

    private boolean trueAndFalseGenerator() {
        return randomInstance.nextBoolean();
    }
}
