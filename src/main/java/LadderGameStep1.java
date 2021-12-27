public class LadderGameStep1 implements LadderGame {

    @Override
    public boolean[][] createMap(Ladder ladder) {

        int row = ladder.getLadderHeight();
        int col = ladder.getNumberOfParticipants() - 1;

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
