package ladder.view;

import java.util.List;
import java.util.Scanner;

public interface InputInterface {
    List<String> inputParticipants(Scanner sc);
    int inputLadderWidth(Scanner sc);
    int inputLadderHeight(Scanner sc);
}
