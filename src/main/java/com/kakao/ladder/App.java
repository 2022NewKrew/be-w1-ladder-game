package com.kakao.ladder;

import com.kakao.ladder.ladder.Ladder;
import java.util.Scanner;

public class App {

    private static int n;
    private static int m;

    public static void main(String[] args) {
        input();
        Ladder ladder = Ladder.create(n, m);
        System.out.println(ladder);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        m = sc.nextInt();
    }
}
