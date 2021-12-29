package step_3.domain;

import step_3.view.input.NameAndHeightInputInterface;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderConnection> ladderConnections = new ArrayList<>();

    public Ladder(List<LadderConnection> ladderConnections) {
        this.ladderConnections.addAll(ladderConnections);
    }

    public void printLadder() {
        ladderConnections
                .forEach(ladderConnection -> {
                    System.out.print(LadderCharacter.ONE_SPACE.getValue().repeat(NameAndHeightInputInterface.maxNameLength / 2));
                    System.out.print(LadderCharacter.POLE.getValue());
                    for(boolean isConnected: ladderConnection.getConnect()) {
                        if (isConnected)
                            System.out.print(LadderCharacter.CONNECTED.getValue().repeat(NameAndHeightInputInterface.maxNameLength));
                        else
                            System.out.print(LadderCharacter.NOT_CONNECTED.getValue().repeat(NameAndHeightInputInterface.maxNameLength));
                        System.out.print(LadderCharacter.POLE.getValue());
                    }
                    System.out.print(LadderCharacter.CHANGE_LINE.getValue());
                });
    }
}
