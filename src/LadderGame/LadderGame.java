package LadderGame;

import java.io.*;
import java.util.*;
import LadderGame.Ladder;

public class LadderGame {
    public static void main(String[] args) {
        int players;
        int height;
        Ladder ladder;
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        players = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        height = scanner.nextInt();

        ladder = new Ladder(height, players*2 - 1);
        ladder.makeLadder();
        ladder.printLadder();
    }
}
