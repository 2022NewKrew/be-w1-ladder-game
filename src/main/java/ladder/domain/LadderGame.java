package ladder.domain;

import ladder.view.InputView;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LadderGame {
    private List<Player> players;
    private List<Prize> prizes;
    private final Ladder ladder;
    private final InputView inputView = new InputView();
    public static final int PLAYER_NAME_LENGTH_LIMIT = 5;

    public List<Player> getPlayers() {
        return players;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGame() {
        ladder = generateLadder();
    }

    public Prize getPrizeByName(String name) throws NoSuchElementException {
        int startIndex = IntStream.range(0, players.size())
                .filter(i -> name.equals(players.get(i).getName()))
                .findFirst()
                .orElseThrow();
        int resultIndex = ladder.getRunResult(startIndex);
        return prizes.get(resultIndex);
    }

    /**
     * {@link Scanner}로부터 플레이어, 사다리 높이를 입력받아 {@link Ladder}를 만들어서 반환
     */
    private Ladder generateLadder() {
        while (true) {
            Ladder ladder = tryGenerateLadder();
            if (ladder != null)
                return ladder;
        }
    }

    private Ladder tryGenerateLadder() {
        try {
            players = inputView.getPlayersFromScanner("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ");
            prizes = inputView.getPrizesFromScanner("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요) ", players);
            int height = inputView.getPositiveIntFromScanner("사다리 높이는 몇개인가요? ");
            return new Ladder(players.size(), height);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
