package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.view.Input;
import ladder.view.LadderGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderGameApplication {
    public static void main(String[] args) {
        try {
            // 1. Generate Ladder
            Input input = new Input();
            LadderGenerator ladderGenerator = new LadderGenerator(input);
            Ladder ladder = ladderGenerator.generateLadder();

            // 2. Print Result
            System.out.println("\n사다리 결과\n");
            System.out.println(ladder);

            // 3. Call Ladder Game
            LadderGame ladderGame = new LadderGame(input, ladder);
            ladderGame.playLadderGame();

        } catch (IOException e) {
            System.err.println("예외가 발생했습니다: " + e.getMessage());
        }
    }
}
