package step01;

import java.util.Scanner;

public class LadderMain {
    public LadderMain() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");

        int n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int m = sc.nextInt();
        Ladder ladder = new Ladder(n, m);
        ladder.initLadder();
        ladder.draw();
    }
}

