import java.util.*;

public class LadderGame {

    // 메서드들을 호출
    public static void main(String[] args) {

        // 변수들을 먼저 정해놓고 시작
        int height;
        List<String> names;
        Scanner sc = new Scanner(System.in);

        // 사용자의 입력을 받고 그에 따라 사다리의 가로 세로를 결정
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        names = List.of(sc.nextLine().split(","));

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();

        Ladder ladder = new Ladder(names, height);
        ladder.printNames();
        ladder.printLadder();
 }
}
