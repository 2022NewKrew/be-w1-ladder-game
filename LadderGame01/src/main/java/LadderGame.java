import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    private static Random random = new Random();

    public void start(){
        Ladder ladder = input();

        makeLadder(ladder);
        System.out.println(ladder);
    }

    private Ladder input(){
        int width=0, height=0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            width = scanner.nextInt();
            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            height = scanner.nextInt();
        }
        return new Ladder(width, height);
    }

    private void makeLadder(Ladder ladder){
        boolean[][] shape = new boolean[ladder.getHeight()][];
        for(int i = 0 ; i < ladder.getHeight(); ++i){
            shape[i] = makeSingleRow(ladder.getWidth());
        }
        ladder.setShape(shape);
    }
    private boolean[] makeSingleRow(int width){
        boolean[] singleRow = new boolean[width - 1];
        for(int col = 0 ; col < width-1; ++col){
            boolean isLeftBridge = col > 0 && singleRow[col-1];
            singleRow[col] = isLeftBridge ? false : random.nextBoolean();
        }
        return singleRow;
    }

}
