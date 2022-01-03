package domain;

import view.input.NameAndHeightInputInterface;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderConnection> ladderConnections = new ArrayList<>();
    private final Map<String, String> ladderResults = new HashMap<>();

    protected Ladder(List<LadderConnection> ladderConnections, String[] names, String[] results) {
        this.ladderConnections.addAll(ladderConnections);
        this.calculateLadderResults(names, results);
    }

    public String getLadderResult(String name) {
        return ladderResults.get(name);
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
                    System.out.print(LadderCharacter.NEW_LINE.getValue());
                });
    }

    protected int getHeight() {
        return ladderConnections.size();
    }

    protected int getWidth() {
        return ladderConnections.get(0).getConnect().size();
    }

    private void calculateLadderResults(String[] names, String[] results) {
        for (int index = 0; index < getWidth() + 1; index++) { // n 개의 연결 관계가 있으면 n+1 명의 참가자임 
            ladderResults.put(names[index], results[calculateLadderResult(index)]);
        }
    }

    private int calculateLadderResult(int index) {
        AtomicInteger point = new AtomicInteger(index);

        IntStream.range(0, getHeight())
                .forEach(depth -> {
                    if (ladderConnections.get(depth).isLeftConnected(point.get())) {
                        point.addAndGet(-1);
                    }
                    else if (ladderConnections.get(depth).isRightConnected(getWidth() + 1, point.get())) {
                        point.addAndGet(1);
                    }
                });

        return point.get();
    }
}
