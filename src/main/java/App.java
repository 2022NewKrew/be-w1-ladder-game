import java.util.Random;
import java.util.Scanner;

public class App {

    // 사다리 출력 모양 지정을 위한 상수
    private static final char LADDER_LINE = '|';
    private static final char LADDER_CROSS = '-';
    private static final char LADDER_EMPTY = ' ';

    // 사다리 정보를 저장하는 2차원 배열 맴버 변수
    private static int[][] ladder;

    // 참여할 사람 및 사다리 높이 저장 맴버 변수
    private static int numOfPlayer;
    private static int heightOfLadder;

    public static void main(String[] args) {

        // 참여할 사람 및 사다리 층수 세팅
        askGameConfigure();

        // 사다리 가로줄 여부를 랜덤으로 지정하여 사다리 생성
        makingLadder();

        // 사다리 출력
        printLadder();
    }

    // 참여 사람 및 사다리 높이 입력
    private static void askGameConfigure() {
        numOfPlayer = askInt("참여할 사람은 몇 명인가요?");
        heightOfLadder = askInt("최대 사다리 높이는 몇 개인가요?");
    }

    // 안내 메시지를 출력하고 양의 정수를 콘솔로 입력받아 반환하는 메서드
    private static int askInt(String message) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println(message);
            try {
                int result = Integer.parseInt(scn.nextLine());
                if (result < 0) { throw new Exception(); }
                return result;
            } catch (Exception e) { System.out.println("0 이상의 정수를 입력해 주셔야 합니다!"); }
        }
    }

    // 랜덤 사다리 정보를 2차원 int 배열로 생성하여 클래스의 ladder 멤버 변수에 저장
    private static void makingLadder() {
        Random random = new Random();
        ladder = new int[heightOfLadder][numOfPlayer];
        for (int i = 0; i < heightOfLadder; i++) {
            for (int j = 0; j < (numOfPlayer - 1); j++) {
                ladder[i][j] = (random.nextInt() < 1) ? 0 : 1;
            }
        }
    }

    // 클래스의 ladder 변수에 저장된 정보를 바탕으로 사다리 인쇄
    private static void printLadder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < heightOfLadder; i++) {
            sb.append("|");
            for (int j = 0; j < (numOfPlayer - 1); j++) {
                sb.append((ladder[i][j] == 0) ? LADDER_EMPTY : LADDER_CROSS).append(LADDER_LINE);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
