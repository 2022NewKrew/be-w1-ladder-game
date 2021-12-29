package upperleaf.laddergame.game.view;

import upperleaf.laddergame.domain.Ladder;
import upperleaf.laddergame.util.StringUtils;

import java.util.List;

public class LadderRenderer {

    public static final int LENGTH = 5;
    public static final String LINE = "|";
    public static final String EMPTY = " ";
    public static final String CONNECT = "-";
    public static final String NEW_LINE = "\n";

    /**
     * 사다리를 출력합니다.
     * 첫번째 줄에는 참가자들의 이름을 출력합니다.
     * 그 이후로는 사다리를 순서대로 출력합니다.
     */
    public LadderView render(Ladder ladder) {
        LadderView ladderView = new LadderView();
        List<String> playerNames = ladder.getPlayerNames();
        ladderView.appendResult(makeNamesAsString(playerNames, LENGTH + 1));

        for(int currentHeight = 0; currentHeight < ladder.getMaxLadderHeight(); currentHeight++) {
            ladderView.appendResult(makeHeight(ladder, currentHeight));
        }
        return ladderView;
    }

    /**
     * 이름들을 한개의 String 객체로 만들어서 반환합니다.
     * 이름들을 사다리 선에 일치시키기 위해서 공간을 조절하는 코드가 포함되어있습니다.
     */
    private String makeNamesAsString(List<String> playerNames, int nameSize) {
        int playerNumbers = playerNames.size();
        StringBuilder sb = new StringBuilder(StringUtils.times(EMPTY, playerNumbers * nameSize));

        for(int i = 0; i < playerNumbers; i++) {
            String name = playerNames.get(i);
            int start = i * nameSize + Math.max(0, (nameSize - name.length())) / 2;
            sb.replace(start, start + name.length(), name);
        }
        sb.append(NEW_LINE);
        return sb.toString();
    }

    /**
     * 사다리에서 한 줄을 출력합니다.
     * 사람의 이름에 사다리를 맞추기 위해서 여백을 출력한뒤, 사람 이름을 출력합니다.
     */
    private String makeHeight(Ladder ladder, int height) {
        StringBuilder builder = new StringBuilder(StringUtils.times(EMPTY, LENGTH / 2));
        for(int currentLine = 0; currentLine < ladder.getPlayerNum(); currentLine++) {
            builder.append(makeLine(ladder, currentLine, height));
        }
        builder.append(NEW_LINE);
        return builder.toString();
    }

    /**
     * 사다리에서 선(Line)을 출력합니다.
     * 연결되어있다면 "|-----"
     * 연결되어있지 않다면 "|     "
     * 마지막 선일 경우 "|" 만 출력합니다.
     */
    private String makeLine(Ladder ladder, int line, int height) {
        StringBuilder sb = new StringBuilder(LINE);
        if(line == ladder.getPlayerNum() - 1){
            return sb.toString();
        }
        boolean isRightConnected = ladder.isRightConnected(line, height);
        sb.append(makeLineCounterPart(isRightConnected));
        return sb.toString();
    }

    private String makeLineCounterPart(boolean isRightConnected) {
        StringBuilder sb = new StringBuilder();
        if (isRightConnected) {
            sb.append(StringUtils.times(CONNECT, LENGTH));
            return sb.toString();
        }
        sb.append(StringUtils.times(EMPTY, LENGTH));
        return sb.toString();
    }
}
