public class LadderGameServiceImpl implements LadderGameService {

    @Override
    public boolean[][] createMap(int row, int col) {

        boolean[][] ladderMap = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ladderMap[i][j] = trueAndFalseGenerator();
            }
        }

        return ladderMap;
    }

    private boolean trueAndFalseGenerator() {
        return ((int) (Math.random() * 2)) % 2 == 0;
    }
}
