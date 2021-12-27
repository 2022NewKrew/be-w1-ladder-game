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

    // 사다리 가로로 한줄을 만듦
    // 사다리 대가 놓여지는 위치와 옆으로 넘어갈수 있는 칸을 구분하여 프린트
    static void makeOneDepthLadder() {
        for (int c = 0; c < col * 2-1; c++) {
            if ((c & 1) == 0) {
                System.out.print("|");
            } else if (rand.nextBoolean()) {
                System.out.print(" ");
            } else {
                System.out.print("-");
            }
        }
    }

    // 높이 별로 사다리를 만들고 한 높이를 다 만든 후에는 줄 바꿈
    static void makeLadder() {
        for (int r=0; r < row; r++) {
            makeOneDepthLadder();
            System.out.println();
        }
    }

    // 메서드들을 호출
    public static void main(String[] args) {
        getColAndRol();
        makeLadder();
 }
}
