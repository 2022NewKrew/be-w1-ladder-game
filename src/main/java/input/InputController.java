package input;

import dto.LadderInputRawData;

import java.util.Set;

public interface InputController {
    LadderInputRawData inputLadderRawData();

    String inputNameForResult(Set<String> participantsNames);

    void close();
}
