import java.util.*;

public class LadderGame {

    // 변수들을 먼저 정해놓고 시작
    static int row, col;
    static Random rand = new Random();

    // 사용자의 입력을 받고 그에 따라 사다리의 가로 세로를 결정
    static void getColAndRol() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        col = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        row = sc.nextInt();
    }


    // 메서드들을 호출
    public static void main(String[] args) {
        getColAndRol();
        Ladder ladder = new Ladder(col, row);
        ladder.printLadder();
 }
}
