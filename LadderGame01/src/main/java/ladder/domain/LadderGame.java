package ladder.domain;

import ladder.util.ResourceManager;
import ladder.view.InputInterface;
import ladder.view.InputInterfaceImpl;
import ladder.view.OutputInterface;
import ladder.view.OutputInterfaceImpl;

import java.util.*;

public class LadderGame{
    private static final ResourceManager resourceManager = new ResourceManager();
    private static final InputInterface inputImpl = new InputInterfaceImpl();
    private static final OutputInterface outputImpl = new OutputInterfaceImpl();

    private List<String> participants = new ArrayList<>();
    private Ladder ladder;

    public void start(){
        participants = inputImpl.inputParticipants(resourceManager.SCANNER);
        System.out.println();
        ladder = new Ladder(participants.size(), inputImpl.inputLadderHeight(resourceManager.SCANNER));

        System.out.println("\n실행결과\n");
        outputImpl.printParticipants(participants);
        outputImpl.printLadder(ladder);
    }


}
