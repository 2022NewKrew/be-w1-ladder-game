package ladder.view;

import ladder.domain.LadderSimpleGame;

import java.util.List;

public class LadderGameViewConsole implements LadderGameView {

    private static final String PARTICIPANT_LINE = "|";
    private static final String MOVE_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    private LadderSimpleGame ladderSimpleGame;

    private LadderGameViewConsole() {
    }

    public LadderGameViewConsole(LadderSimpleGame ladderSimpleGame) {
        this.ladderSimpleGame = ladderSimpleGame;
    }

    @Override
    public void printView() {
        System.out.println(getLadderString());

    }

    private String getLadderString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getParticipantsString());

        for (List<Boolean> floor : ladderSimpleGame.getBridge()) {
            stringBuilder.append(getFloorString(floor));
        }

        return stringBuilder.toString();
    }

    private String getParticipantsString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("실행결과\n  ");

        for (String participant : ladderSimpleGame.getParticipants()) {
            stringBuilder.append(String.format("%-5s  ", participant));
        }

        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    private String getFloorString(List<Boolean> floor) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(EMPTY_LINE);

        for (int col = 0; col < ladderSimpleGame.getNumberOfParticipants() * 2 - 1; col++) {
            stringBuilder.append(getBridgeChar(col, floor));
        }

        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private String getBridgeChar(int col, List<Boolean> floor) {
        if (col % 2 == 0) {
            return PARTICIPANT_LINE;
        } else if (floor.get(col / 2)) {
            return MOVE_LINE;
        }

        return EMPTY_LINE;

    }

}
