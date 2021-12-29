package com.kakao;

import com.kakao.domain.Ladder;
import com.kakao.domain.Player;
import com.kakao.factory.LadderFactory;
import com.kakao.view.InputView;
import com.kakao.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LadderFactory ladderFactory = new LadderFactory();

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    public void start() {
        String[] names = inputView.inputNameOfPlayers();
        int heightOfLadder = inputView.inputHeightOfLadder();

        List<Player> players = Arrays.stream(names)
            .map(Player::create)
            .collect(Collectors.toList());
        Ladder ladder = ladderFactory.create(players.size(), heightOfLadder);

        outputView.print(players, ladder);
    }
}
