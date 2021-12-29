package ladderGame.view.input;

import ladderGame.domain.ladderConfig.LadderConfig;
import ladderGame.exception.ladderException.ConsoleInputCountExceededException;

public interface InputInterface {
    LadderConfig inputLadderConfig() throws ConsoleInputCountExceededException;
}
