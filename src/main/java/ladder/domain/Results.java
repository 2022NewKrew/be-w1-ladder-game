package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;
    private Map<String, String> gameResults; // 플레이어 별 사다리 게임 결과
    private static final String ALL_RESULTS = "all";

    public Results() {
        results = new ArrayList<>();
        gameResults = new LinkedHashMap<>();
    }

    public void addResult(String result) {
        results.add(new Result(result));
    }

    public List<String> getResults() {
        return results.stream()
                .map(r -> r.getResult())
                .collect(Collectors.toList());
    }

    public String getGameResult(String name) {
        if (ALL_RESULTS.equals(name)) {
            return getAllGameResults().stream()
                    .map(r -> String.valueOf(r))
                    .collect(Collectors.joining("\n"));

        }
        return gameResults.get(name);
    }

    public List<String> getAllGameResults() {
        List<String> allResults = new ArrayList<>();
        gameResults.forEach((key, value) -> {
            allResults.add(key + " : " + value);
        });

        return allResults;
    }

    public void findAllResults(Players players, Ladder ladder) {
        for (int i = 0; i < players.getPlayersCnt(); i++) {
            int resultIdx = findOneResult(i, ladder);
            Player player = players.getOnePlayer(i);
            String result = results.get(resultIdx).getResult();

            gameResults.put(player.getName(), result);
        }
    }

    private int findOneResult(int curPlayer, Ladder ladder) {
        int height = ladder.getHeight();
        int curCol = curPlayer;

        for (int i = 0; i < height; i++) {
            curCol = calculateNextCol(i, curCol, ladder);
        }

        return curCol;
    }

    private int calculateNextCol(int curRow, int curCol, Ladder ladder) {
        if (curCol == 0) {
            return curCol + checkRightMove(curRow, curCol, ladder);
        } else if (curCol == ladder.getWidth() - 1) {
            return curCol + checkLeftMove(curRow, curCol, ladder);
        }

        return curCol + checkRightMove(curRow, curCol, ladder) + checkLeftMove(curRow, curCol, ladder);
    }

    private int checkRightMove(int curRow, int curCol, Ladder ladder) {
        Line line = ladder.getOneLine(curCol);
        boolean exist = line.getOneBridge(curRow)
                .isExist();
        if (exist) {
            return 1;
        }
        return 0;
    }

    private int checkLeftMove(int curRow, int curCol, Ladder ladder) {
        Line line = ladder.getOneLine(curCol - 1);
        boolean exist = line.getOneBridge(curRow)
                .isExist();
        if (exist) {
            return -1;
        }
        return 0;
    }
}
