package keith.domain;

import java.util.List;

public class ProceedLadder {
    private static final String COLON = ": ";
    private static final String LINE_BREAK = "\n";

    public static String getToDest(Ladder ladder, String name) {
        if (!ladder.getParticipants().contains(name)) {
            throw new IllegalArgumentException("잘못된 참가자 이름입니다!");
        }

        int currentPosition = ladder.getStartPoint().get(name);
        int currentHeight = 0;
        List<Line> connections = ladder.getConnections();
        while (currentHeight < connections.size()) {
            List<Boolean> currentRowConnection = connections.get(currentHeight).getPoints();
            currentPosition = goLeftOrRight(currentRowConnection, currentPosition);
            currentHeight += 1;
        }
        return ladder.getDestinations().get(currentPosition);
    }

    private static int goLeftOrRight(List<Boolean> connections, int position) {
        if (connections.get(position)) {
            return position - 1;
        } else if (connections.get(position + 1)) {
            return position + 1;
        }
        return position;
    }

    public static String getToAllDest(Ladder ladder) {
        StringBuilder result = new StringBuilder();
        for (String name: ladder.getParticipants()) {
            result.append(name)
                    .append(COLON)
                    .append(getToDest(ladder, name))
                    .append(LINE_BREAK);
        }
        return result.toString();
    }
}
