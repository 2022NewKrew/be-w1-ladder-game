package view;

import ladder.Ladder;
import ladder.domain.LadderFloor;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResultFinder {

    public static List<String> getResultAll(Ladder ladder) {
        return ladder.getParticipants().stream()
                .map(p -> getResult(ladder, p))
                .collect(Collectors.toList());
    }

    private static String getResult(Ladder ladder, String next) {
        List<String> participants = ladder.getParticipants();
        List<LadderFloor> ladderFloors = ladder.getLadder();
        int idx = participants.indexOf(next);
        for (int i = 0; i < ladderFloors.size(); i++)
            idx = nextIdx(idx, ladderFloors.get(i));

        return ladder.getResults().get(idx);
    }

    private static int nextIdx(int currentIdx, LadderFloor ladderFloor) {
        List<Boolean> isConnected = ladderFloor.getIsConnected();
        int len = isConnected.size();

        if (currentIdx != 0 && isConnected.get(currentIdx-1)) return currentIdx - 1;
        if (currentIdx != len && isConnected.get(currentIdx)) return currentIdx + 1;
        return currentIdx;
    }


}
