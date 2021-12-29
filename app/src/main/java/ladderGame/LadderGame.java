/*
 * @author ed.shim
 */
package ladderGame;

import java.util.List;

public class LadderGame {
    private final List<Line> ladder;
    private final LadderGameInfo ladderGameInfo;

    LadderGame() {
        ladderGameInfo = LadderGameInfo.getLadderGameInfo();

        /* 기존 - getter 사용
        ladder = new ArrayList(ladderGameInfo.getHeight());
        for(int i = 0; i < ladderGameInfo.getHeight(); i++) {
            ladder.add(new Line(ladderGameInfo.getNumberOfPlayers()));
        } */
        ladder = ladderGameInfo.generateLadder(); // 관련 action 주체를 LadderGameInfo 로 옮기기
    }

    public final void print() {
        ladderGameInfo.printPlayers();
        printLine();
    }

    private final void printLine() {
        for(Line currentLine : ladder) {
            currentLine.print();
            System.out.println("|");
        }
    }

    /* 마찬가지로 getter 사용하지 않고 LadderGameInfo 에서 처리하도록 옮기기
    private final void printPlayers() {
        String[] players = ladderGameInfo.getPlayers();

        for(String player : players) {
            System.out.printf("%6s", player);
        }
        System.out.println();
    } */
}