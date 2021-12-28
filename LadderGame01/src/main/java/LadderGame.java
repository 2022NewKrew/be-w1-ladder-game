import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    static Random random = new Random();

    public void start(){
        Ladder ladderObj = input();

        makeLadder(ladderObj);
        System.out.println(ladderObj);
    }

    private Ladder input(){
        int width, height;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            width = scanner.nextInt();
            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            height = scanner.nextInt();
        }
        return new Ladder(width, height);
    }

    private void makeLadder(Ladder ladderObj){
        boolean[][] ladder = new boolean[ladderObj.getHeight()][ladderObj.getWidth()-1];
        for(int i = 0 ; i < ladderObj.getHeight(); ++i){
            for(int j = 0 ; j < ladderObj.getWidth()-1; ++j){
                ladder[i][j] = (j > 0 && ladder[i][j-1])? false : random.nextBoolean();
            }
        }
        ladderObj.setLadder(ladder);
    }
}
