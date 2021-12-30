package step2LadderGame.view.input;

import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.exception.ladderException.ConsoleInputCountExceededException;

public interface InputInterface {
    LadderConfig inputLadderConfig() throws ConsoleInputCountExceededException;
}
