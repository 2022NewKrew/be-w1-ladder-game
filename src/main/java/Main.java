import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int personNum, ladderHeight;
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Name names = new Name(Arrays.asList(sc.nextLine().split(",")));
        personNum = names.getLength();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = sc.nextInt();

        names.printNames();
        Ladder ladder = new Ladder(personNum, ladderHeight);
        ladder.printLadder();
    }
}

