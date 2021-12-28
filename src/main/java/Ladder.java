import java.util.Scanner;

public class Ladder {
    private static int arrHeight, arrWidth;
    private static char[][] horizBarArr;

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

    /* Return : NULL
     * 사용자 입력 값을 바탕으로 arrHeight, arrWidth 멤버 변수 초기화.
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

    /* Return : NULL
     * horizBarArr 멤버변수 초기화
     * horizBarArr 을 arrHeight X arrWidth 만큼의 크기로 초기화
     * horizBarArr 은 가로막대를 놓을 수 있는 칸에 가로막대가 놓여 있는지를 나타낸다.
     */
    public void makeArray() {
        horizBarArr = new char[arrHeight][arrWidth];

        for (int i = 0; i < arrHeight; i++) {
            setRow(i, 1.0, BLANK);
        }
    }

    /* Return : NULL
     * 랜덤하게 사다리를 놓는 함수
     * 가로막대 생성 조건 : 각각의 가로막대 위치에 대해 확률적으로 생성
     * 생성 확률 : UPPERBOUND
     */
    private void setLadder() {
        for (int i = 0; i < arrHeight; i++) {
            setRow(i, UPPERBOUND, HOR_BAR);
        }
    }

    private void setRow(int rowIdx, double probability, char value) {
        for (int j = 0; j < arrWidth; j++) {
            setCell(rowIdx, j, probability, value);
        }
    }

    private void setCell(int rowIdx, int colIdx, double probability, char value) {
        if (probability >= 1.0) {
            horizBarArr[rowIdx][colIdx] = value;
        }

        if (probability <= 0.0) {
            return;
        }

        double randVal = Math.random();

        if (randVal < probability) {
            horizBarArr[rowIdx][colIdx] = value;
        }
    }

    /* Return : NULL, 사다리 출력하는 함수
     */
    public void printLadder() {
        for (char[] r : horizBarArr) {
            printRow(r);
        }
    }

    private void printRow(char [] r) {
        for (char cell : r) {
            System.out.print(VER_BAR);
            System.out.print(cell);
        }
        System.out.println(VER_BAR);
    }
}
