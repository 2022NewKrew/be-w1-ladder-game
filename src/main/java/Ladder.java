import java.util.Random;

public class Ladder {
    private final int maxHeight;
    private final LadderRow[] ladderRows;

    static class LadderRow {
        private final char[] ladderMap;

        public LadderRow(int participantsNum) {
            int length = participantsNum * 2 - 1;

            ladderMap = new char[length];
            for (int i=0; i<length; i=i+2)
                ladderMap[i] = '|';
            for (int i=1; i<length; i=i+2)
                ladderMap[i] = createRandomConnection();
        }

        private char createRandomConnection() {
            Random rd = new Random();

            if (rd.nextBoolean())
                return '-';
            return ' ';
        }

        public void printRow() {
            System.out.println(ladderMap);
        }
    }

    public Ladder(int participantsNum, int maxHeight) {
        this.maxHeight = maxHeight;

        ladderRows = new LadderRow[maxHeight];
        for (int i=0; i<maxHeight; i++)
            ladderRows[i] = new LadderRow(participantsNum);
    }

    public void printLadder() {
        for (int i=0; i<maxHeight; i++)
            ladderRows[i].printRow();
    }
}
