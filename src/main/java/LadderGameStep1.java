public class LadderGameStep1 implements LadderGame {

    @Override
    public boolean[][] createMap(Ladder ladder) {

        boolean[][] ladderMap = new boolean[ladder.getLadderHeight()][ladder.getNumberOfParticipants() -1];

        for (int i = 0; i < ladderMap.length; i++) {
            for (int j = 0; j < ladderMap[0].length; j++) {
                ladderMap[i][j] = trueAndFalseGenerator();
            }
        }

        return ladderMap;
    }

    private boolean trueAndFalseGenerator() {
        return ((int) (Math.random() * 2)) % 2 == 0;
    }
}
