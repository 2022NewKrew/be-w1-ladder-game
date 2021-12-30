package ladder.view;

import ladder.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LadderView {
    private static final String DELIMITER = ",";
    private static final String PADDING = "  ";

    private final Scanner scanner;

    public LadderView() {
        scanner = new Scanner(System.in);
    }

    public List<Player> inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] inputPlayers = scanner.nextLine().split(DELIMITER);
        List<Player> players = new ArrayList<>();

        for (String inputPlayer : inputPlayers) {
            players.add(new Player(inputPlayer));
        }
        return players;
    }

    public int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void printLadder(List<Player> players, Ladder ladder) {
        int ladderWidth = ladder.getLadderRows().size();
        printPlayers(players);

        for (int i = 0; i < ladderWidth; i++) {
            LadderRow ladderRow = ladder.getLadderRows().get(i);
            List<LadderCell> row = ladderRow.getRow();
            printLadderRow(row);
        }
    }

    private void printPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.printf("%5s ", player);
        }
        System.out.println();
    }

    private void printLadderRow(List<LadderCell> row) {
        System.out.print(PADDING);

        for (LadderCell ladderCell : row) {
            System.out.print(LineType.VERTICAL_LINE);
            System.out.print(ladderCell.getLine());
        }
        System.out.println(LineType.VERTICAL_LINE);
    }
}
