package upperleaf.laddergame.domain;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 사다리를 실제로 실행하는 객체입니다.
 * progress(String) 플레이어의 이름을 받으면, 사다리를 실행시켜 실행 결과를 반환합니다.
 * progressAll()을 실행하면, Map<String(플레이어 이름), String(실행 결과)> 형태로 결과를 반환합니다.
 */
public class LadderFlow {

    private final Ladder ladder;

    public LadderFlow(Ladder ladder) {
        this.ladder = ladder;
    }

    public Map<String, String> progressAll() {
        return ladder.getPlayerNames().stream().collect(Collectors.toMap(playerName -> playerName, this::progress));
    }

    public String progress(String playerName) {
        int currentLine = findStartIndex(playerName);
        int currentHeight = 0;

        while(currentHeight < ladder.getMaxLadderHeight()) {
            currentLine += moveLine(currentLine, currentHeight);
            currentHeight++;
        }
        return findResult(currentLine);
    }

    private int findStartIndex(String playerName) {
        int index = ladder.getPlayerNames().indexOf(playerName);
        if (index < 0) {
            throw new IllegalArgumentException("존재하지 않는 플레이어 이름입니다.");
        }
        return index;
    }

    private int moveLine(int currentLine, int currentHeight) {
        if(ladder.isRightConnected(currentLine, currentHeight)) {
            return 1;
        }

        if(ladder.isLeftConnected(currentLine, currentHeight)) {
            return -1;
        }
        return 0;
    }

    private String findResult(int index) {
        return ladder.getResults().get(index);
    }
}
