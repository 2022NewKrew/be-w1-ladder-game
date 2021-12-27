/*
 * @author ed.shim
 */
package ladderGame;

import java.util.*;

public class LadderGame {
    static int numberOfUser; // 참여자 수
    static int height;       // 사다리 높이
    static List<List<String>> ladder = null;

    public static void main(String[] args) {
        getInput();
        makeRandomLadder();
        printLadder();
    }

    static void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        numberOfUser = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = scanner.nextInt();

        scanner.close();
    }

    static void makeRandomLadder() { // 랜덤으로 사다리를 생성해서 ladder에 정보 저장
        if(ladder == null) ladder = new ArrayList(height);
        for(int i = 0; i < height; i++) {
            makeRow();
        }
    }

    static void makeRow() {
        List<String> temp = new ArrayList(numberOfUser - 1);
        for(int i = 0; i < numberOfUser - 1; i++) {
            if(getRandomBool()) {
                temp.add("-");
            } else {
                temp.add(" ");
            }
        }
        ladder.add(temp);
    }

    static boolean getRandomBool() { return Math.random() < 0.5; }

    static void printLadder() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < numberOfUser - 1; j++) {
                System.out.print("|");
                System.out.print(ladder.get(i).get(j));
            }
            System.out.println("|");
        }
    }
}
