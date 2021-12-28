import java.util.Random;

public class LadderGameServiceImpl implements LadderGameService {

    @Override
    public boolean[][] createLadderMap(int row, int col) {

        boolean[][] ladderMap = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ladderMap[i][j] = trueAndFalseGenerator();
            }
        }

        return ladderMap;
    }

    private boolean trueAndFalseGenerator() {
        return new Random().nextBoolean();
    }
}
