import java.util.Random;

public class LadderMaker {
    private int row;
    private int column;
    private char[][] ladder;
    private Random random;

    public LadderMaker(LadderInputManager ladderInputManager) {
        this.row = ladderInputManager.getMaxHeight();
        this.column = ladderInputManager.getNumOfPlayer() * 2 - 1;
        this.ladder = new char[row][column];
        this.random = new Random();
        makeLadder(ladder);
    }

    public char[][] getLadder() {
        return ladder;
    }

    private void makeLadder(char[][] ladder){
        for (char[] row : ladder) {
            // 한 줄씩 채우기
            fillRow(row);
        }
    }

    private void fillRow(char[] row){
        // 세로 줄
        for(int i=0; i<row.length; i+=2)
            row[i] = '|';

        // 가로 줄
        for(int i= 1; i< row.length; i+=2){
            row[i] = getRandom();
        }
    }

    private char getRandom() {
        if(random.nextBoolean())
            return '-';

        return ' ';
    }
}
