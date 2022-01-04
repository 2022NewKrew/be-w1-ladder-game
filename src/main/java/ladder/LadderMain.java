package ladder;

import ladder.view.LadderInput;
import ladder.domain.Ladder;

import java.util.List;


public class LadderMain {

    public static void main(String[] args) {

        List<String> players = LadderInput.getPlayers();
        List<String> ladderResult = LadderInput.getLadderResult();
        int ladderHeight = LadderInput.getLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, players, ladderResult);

        String playerName = LadderInput.getQuery();
        while (!playerName.equals("춘식이")) {
            ladder.queryResult(playerName);
            playerName = LadderInput.getQuery();
        }
        System.out.println("게임을 종료합니다.");
    }
}
