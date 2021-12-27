import java.util.Random;
import java.util.Scanner;

public class Main {
    static int row, col;
    static char [][] arr;
    static Random random = new Random();

    /* Return : NULL, col, row 멤버 변수 초기화
     * col, row 값을 사용자 입력으로 받아온다.
     */
     static void getColRow() {
        Scanner sc = new Scanner(System.in);

        // col 값에서 왜 1을 빼는가? : 한 row 에서 가로 막대는 사람 수 -1 만큼 놓을 수 있다
        System.out.println("참여할 사람은 몇 명인가요?");
        col = sc.nextInt() - 1;

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        row = sc.nextInt();
    }

    /* Return : NULL, arr 멤버변수 초기화
     * arr 을 row X col-1 만큼의 크기로 초기화
     * arr 은 가로막대를 놓을 수 있는 칸에 가로막대가 놓여 있는지를 나타낸다.
     */
    static void makeArray() {
        arr = new char[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                arr[i][j] = ' ';
            }
        }
    }

    /* Return : NULL, 랜덤하게 사다리를 놓는 함수
     * 가로막대를 몇개를 놓을것인가? => 내 임의로 높이만큼 놓기로 결정!
     * 중복 회피 : random 하게 선택한 지점에 가로막대가 없었던 경우에만 i값 증가
     */
    static void setLadder() {
        for (int i = 0; i < row; ) {
            int x,y;
            x = random.nextInt(row);
            y = random.nextInt(col);
            if (arr[x][y] == ' ') {
                arr[x][y] = '-';
                i += 1;
            }
        }
    }

    /* Return : NULL, 사다리 출력하는 함수
     * 가로막대를 몇개를 놓을것인가? => 내 임의로 높이만큼 놓기로 결정!
     */
    static void printLadder() {
        for (char[] r : arr) {
            for (char cell : r) {
                System.out.print("|");
                System.out.print(cell);
            }
            System.out.println("|");
        }
    }

    // Deprecated
    /*
    static void printLadder2() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col-1; j++) {
                System.out.print("|");
                if (random.nextInt(col-1) == 0) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    }
    */

    public static void main(String[] args) {
        getColRow();

        makeArray();
        setLadder();
        printLadder();

        // 모듈화를 더 잘 하기 위해 아래 코드를 포기
        // printLadder2();
    }
}