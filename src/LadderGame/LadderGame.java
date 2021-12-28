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
        makeLadder(ladder);
        printLadder(ladder);

    }

    static void makeLadder(Ladder ladder) {
        int height = ladder.getHeight();
        int width = ladder.getWidth();
        char[][] l = new char[height][width];
        Random rand = new Random();

        for (int i=0; i<height; i++) {
            l[i][0] = '|';
            int bridge = rand.nextInt(width/2);
            for (int j=1; j<width; j++) {
                if (bridge == j/2) {
                    l[i][j++] = '-';
                } else {
                    l[i][j++] = ' ';
                }
                l[i][j] = '|';
            }
        }
        ladder.setLadder(l);
    }

    static void printLadder(Ladder ladder){
        int height = ladder.getHeight();
        int width = ladder.getWidth();
        char[][] l = ladder.getLadder();
        StringBuilder output = new StringBuilder();

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                output.append(l[i][j]);
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}
