import java.util.Random;

public class LadderGamePlayer {
    private final int maxHeight;
    private final int numOfRow;
    private char[][] ladder;

    public LadderGamePlayer(int maxHeight, int numOfRow) {
        this.maxHeight = maxHeight;
        this.numOfRow = numOfRow;
        this.ladder = new char[maxHeight][numOfRow * 2 - 1];
    }

    public void play(){
        // 사다리 작성
        makeLadder(ladder);

        // 사다리 출력
        printLadder(ladder);
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
        for(int i= 0; i< row.length; i++){
            row[i] = getRandom();
        }
    }

    private char getRandom() {
        Random random = new Random();
        char result = ' ';

        if(random.nextBoolean())
            result = '-';

        return result;
    }

    private void printLadder(char[][] ladder) {
        for(int i=0; i<maxHeight; i++){
            System.out.println(ladder[i]);
        }
    }
}
