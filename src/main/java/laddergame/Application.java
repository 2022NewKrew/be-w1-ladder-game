package laddergame;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int numberOfGamer = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = sc.nextInt();

        LadderGame ladderGame = new LadderGame(numberOfGamer, maxHeight);
        ladderGame.printLadder();
    }
}
