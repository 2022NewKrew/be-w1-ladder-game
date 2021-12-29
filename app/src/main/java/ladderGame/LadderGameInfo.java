package ladderGame;

import java.util.Scanner;
import java.util.ArrayList;

public class LadderGameInfo {
    private final int numberOfPlayers;
    private final int height;
    private final String[] players;
    private static Scanner scanner;

    private LadderGameInfo(String[] players, int height) {
        this.players = players;
        this.numberOfPlayers = players.length;
        this.height = height;
    }

    public static LadderGameInfo getLadderGameInfo() {
        scanner = new Scanner(System.in);
        LadderGameInfo instance = new LadderGameInfo(inputPlayers(), inputHeight());
        scanner.close();
        return instance;
    }

    public ArrayList<Line> generateLadder() {
        ArrayList<Line> ladder = new ArrayList<Line>(height);
        for(int i = 0; i < height; i++) {
            ladder.add(new Line(numberOfPlayers));
        }
        return ladder;
    }

    private static String[] inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine().split(",");
    }

    private static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public final void printPlayers() {
        for(String player : players) {
            System.out.printf("%6s", player);
        }
        System.out.println();
    }

    //public int getNumberOfPlayers() { return numberOfPlayers; }

    //public int getHeight() { return height; }

    //public String[] getPlayers() { return players; }
}
