package main;

import main.domain.ladder.LadderGame;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] players = inputPlayers();
        int ladderHeight = inputLadderHeight();

        new LadderGame(players, ladderHeight).start();
    }

    private static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }
    private static String[] inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.) (최대 5글자)");
        return sc.nextLine().split("\\s*[,]\\s*");
    }
}
