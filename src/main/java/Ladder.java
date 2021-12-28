import java.util.Random;
import java.util.Scanner;

public class Ladder {
    private static int arrHeight, arrWidth;
    private static char[][] arr;
    private static final Random random = new Random();

    //클래스 내 상수들
    private static final char HOR_BAR = '-';
    private static final char BLANK = ' ';
    private static final char VER_BAR = '|';
    private static final double UPPERBOUND = 0.3;

    Ladder() {
        getArrParams();
        makeArray();
        setLadder();
    }

    /* Return : NULL, arrHeight, arrWidth 멤버 변수 초기화
     * col, row 값을 사용자 입력으로 받아온다.
     */
    public void getArrParams() {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int numPeople = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        arrWidth = numPeople - 1;
        arrHeight = height;
    }

    /* Return : NULL, arr 멤버변수 초기화
     * arr 을 arrHeight X arrWidth 만큼의 크기로 초기화
     * arr 은 가로막대를 놓을 수 있는 칸에 가로막대가 놓여 있는지를 나타낸다.
     */
    public void makeArray() {
        arr = new char[arrHeight][arrWidth];

        for (int i = 0; i < arrHeight; i++) {
            for (int j = 0; j < arrWidth; j++) {
                arr[i][j] = BLANK;
            }
        }
    }

    /* Return : NULL, 랜덤하게 사다리를 놓는 함수
     * 가로막대 생성 조건 : 각각의 가로막대 위치에 대해 확률적으로 생성
     * 생성 확률 : UPPERBOUND
     */
    public void setLadder() {
        for (int i = 0; i < arrHeight; i++) {
            for (int j = 0; j < arrWidth; j++) {
                double randVal = Math.random();
                if (randVal < UPPERBOUND) {
                    arr[i][j] = HOR_BAR;
                }
            }
        }
    }

    /* Return : NULL, 사다리 출력하는 함수
     */
    public void printLadder() {
        for (char[] r : arr) {
            for (char cell : r) {
                System.out.print(VER_BAR);
                System.out.print(cell);
            }
            System.out.println(VER_BAR);
        }
    }
}
