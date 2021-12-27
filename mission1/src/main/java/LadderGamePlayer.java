import java.util.Random;

public class LadderGamePlayer {
    private int maxHeight;
    private int numOfRow;

    public LadderGamePlayer(int maxHeight, int numOfRow) {
        this.maxHeight = maxHeight;
        this.numOfRow = numOfRow;
    }

    public void play(){
        // 사다리 틀 만들기
        char[][] ladder = makeLadder(maxHeight, numOfRow * 2 - 1);

        // 사다리 채우기
        fillLadder(ladder);

        // 사다리 출력
        for(int i=0; i<maxHeight; i++){
            System.out.println(ladder[i]);
        }
    }

    public char[][] makeLadder(int height, int width){
        char[][] ladder = new char[height][width];

        // 세로 줄만 채운다
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j+=2){
                ladder[i][j] = '|';
            }
        }
        return ladder;
    }

    public void fillLadder(char[][] ladder){
        Random random = new Random();

        for(int i= 0; i< ladder.length; i++){
            for(int j= 1; j< ladder[0].length; j+=2){
                if(random.nextBoolean())
                    ladder[i][j] = '-';
                else
                    ladder[i][j] = ' ';
            }
        }
    }
}
