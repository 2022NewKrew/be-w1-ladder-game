import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // 자주 쓸 것 같은 애들은 밖에다 빼놓기
    static int peopleCount;
    static int ladderCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("참여할 사람은 몇 명인가요?");
                peopleCount = sc.nextInt();
                System.out.println("최대 사다리 높이는 몇 개인가요?");
                ladderCount = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못 된 입력입니다. 다시 입력해주세요.\n");
                sc = new Scanner(System.in);
            }
        }

        // ladder 생성
        Ladder ladder = new Ladder(peopleCount, ladderCount);
        LadderFactory ladderFactory = new LadderFactory();
        ladderFactory.generateLadder(ladder);

        // ladder 출력
        ladder.printLadder();
    }
}
