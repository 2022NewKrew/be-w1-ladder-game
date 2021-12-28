package ladder;

import java.util.Arrays;
import java.util.Scanner;

public class Ladder {

    private final static Scanner sc = new Scanner(System.in);

    // 참여하는 사람의 수와 사다리의 높이
    private int numOfPersons;
    private int ladderHeight;

    /*
    사다리에서 좌우의 연결 여부를 저장하는 배열, ladderHeight x (numOfPersons - 1) 크기이다.
    true가 연결, false가 비연결.

    만약 linked[0][0] = true 라면,
    맨 위 행의 첫번째 사람의 줄과, 두번째 사람의 줄 사이가 연결된 것을 말한다.
    */
    private boolean[][] linked;

    /*
    참여할 사람의 수와 사다리 높이를 입력받아 저장하는 메서드
    사람의 수를 입력받는 메서드와 사다리 높이를 입력받는 메서드를 호출한다.
    */
    private void input() {
        inputNumOfPersons();
        inputLadderHeight();
    }

    // 사다리 높이를 입력받는 메서드
    private void inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.ladderHeight = sc.nextInt();
    }

    // 사람의 수를 입력받는 메서드
    private void inputNumOfPersons() {
        System.out.println("참여할 사람은 몇 명인가요?");
        this.numOfPersons = sc.nextInt();
    }

    /*
    입력받은 사람의 수와 사다리 높이를 가지고 사다리를 만드는 메서드
    양 옆이 연결될 확률은 50%로 정했다.
     */
    private void makeLadder() {
        this.linked = new boolean[this.ladderHeight][this.numOfPersons - 1];
        for (int i = 0; i < this.ladderHeight; i++) {
            for (int j = 0; j < this.numOfPersons - 1; j++) {
                this.linked[i][j] = Math.random() >= 0.5;
            }
        }
    }

    private void printLadder() {
        System.out.println(this.ladderToStr());
    }

    /*
    사다리 연결 정보(linked)로 현재 만들어진 사다리의 형태를 출력하는 메서드
    '-'는 양 옆이 연결돼있다는 뜻이고, ' '(공백)은 양 옆이 연결되지 않았다는 뜻이다.
    */
    private String ladderToStr() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.ladderHeight; i++) {
            sb.append("|");
            for (int j = 0; j < this.numOfPersons - 1; j++) {
                sb.append(this.linked[i][j] ? "-" : " ").append("|");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("참여한 사람의 수 : ").append(numOfPersons)
                .append("\n")
                .append("사다리 높이 : ").append(ladderHeight)
                .append("\n\n")
                .append(this.ladderToStr());
        return sb.toString();
    }

    public static void main(String[] args) {
        Ladder ladder = new Ladder();

        ladder.input();
        ladder.makeLadder();
        ladder.printLadder();
        System.out.println(ladder);
    }
}
