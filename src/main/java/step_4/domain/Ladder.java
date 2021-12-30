package step_4.domain;

import step_4.view.input.NameAndHeightInputInterface;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderConnection> ladderConnections = new ArrayList<>();

    protected Ladder(List<LadderConnection> ladderConnections) {
        this.ladderConnections.addAll(ladderConnections);
    }

    protected int getHeight() {
        return ladderConnections.size();
    }

    protected int getWidth() {
        return ladderConnections.get(0).getConnect().size();
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
