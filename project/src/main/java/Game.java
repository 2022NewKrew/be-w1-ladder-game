import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Ladder ladder;
    private Scanner sc = new Scanner(System.in);

    private int inputCountOfPerson(){
        System.out.println("참여할 사람은 몇 명인가요?");
        int countOfPerson = sc.nextInt();
        return countOfPerson;
    }

    private int inputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        return height;
    }

    public void init(){
        ladder = new Ladder(inputCountOfPerson(), inputLadderHeight());
        ladder.printLadder();
    }
}
