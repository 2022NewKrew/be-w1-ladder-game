package Mission2;

import Mission1.Ladder;

import java.util.Scanner;

public class Main {
    // 인스턴스 변수
    private static int n, m; //변경

    // 메인 메소드
    public static void main(String[] args) {
        input();
        Mission1.Ladder ladder = new Ladder(n, m);
        ladder.routine();
    }

    // 메소드
    public static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        m = sc.nextInt();
    }
}
