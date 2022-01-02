package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {

    private static final String NEWLINE = "\n";
    private static final int LADDER_WIDTH = 5;
    private static final int NAME_GAP = 1;

    private final List<Player> playerList;
    private final List<Result> resultList;
    private final List<Line> lineList;

    public Ladder(List<String> playerNames, List<String> resultNames, int ladderHeight) {
        playerList = List.copyOf(setPlayerList(playerNames));
        resultList = List.copyOf(setResultList(resultNames));
        lineList = List.copyOf(setLineList(ladderHeight));
    }

    private List<Player> setPlayerList(List<String> playerNames) {
        List<Player> temp = new ArrayList<>();
        for (String playerName : playerNames) {
            temp.add(new Player(playerName));
        }
        return temp;
    }

    private List<Result> setResultList(List<String> resultNames) {
        List<Result> temp = new ArrayList<>();
        for (String resultName : resultNames) {
            temp.add(new Result(resultName));
        }
        return temp;
    }

    private List<Line> setLineList(int ladderHeight) {
        List<Line> temp = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            temp.add(new Line(playerList.size()));
        }
        return temp;
    }

    public StringBuilder lineListToString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lineList) {
            sb.append(line.pointListToString());
            sb.append(NEWLINE);
        }
        return sb;
    }

    public StringBuilder resultListToString() {
        StringBuilder sb = new StringBuilder();
        for (Result result : resultList) {
            sb.append(result.getNameWithGap(LADDER_WIDTH, NAME_GAP));
        }
        return sb;
    }

    public StringBuilder playerListToString() {
        StringBuilder sb = new StringBuilder();
        for (Player player : playerList) {
            sb.append(player.getNameWithGap(LADDER_WIDTH, NAME_GAP));
        }
        return sb;
    }

    public String playerResultToString(String playerName) {
        return findGameResult(playerName);
    }

    public List<String> allPlayerResultToString() {
        List<String> resultList= new ArrayList<>();
        for (Player player : playerList) {
            resultList.add(player.getName() + " : " + playerResultToString(player.getName()));
        }
        return resultList;
    }

    public String findGameResult(String playerName) {
        int index = 0;
        for (Player player : playerList) {
            if (Objects.equals(player.getName(), playerName)) {
                return followLine(index);
            }
            index++;
        }
        return playerName + " 은(는) 없는 사람입니다.";
    }

    private String followLine(int index) {
        int currentColumn = index * 2;
        int currentRow = -1;
        while (currentRow < lineList.size() - 1) {
            currentRow++;
            Line currentLine = lineList.get(currentRow);
            int nextMove = currentLine.goToNextPoint(currentColumn);
            switch (nextMove) {
                case 1:
                    currentColumn -= 2;
                    break;
                case 2:
                    currentColumn += 2;
                    break;
                case 3:
                    break;
            }
        }
        return resultList.get(currentColumn / 2).getName();
    }
}
