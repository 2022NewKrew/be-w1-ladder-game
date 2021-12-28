import ladder.LadderGame;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] players = inputPlayers("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.) (최대 5글자)");
        int ladderHeight = inputLadderHeight("최대 사다리 높이는 몇 개인가요?");

        new LadderGame(players, ladderHeight).start();
    }

    private static int inputLadderHeight(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }
    private static String[] inputPlayers(String msg) {
        System.out.println(msg);
        return sc.nextLine().split("\\s*[,]\\s*");
    }
}
