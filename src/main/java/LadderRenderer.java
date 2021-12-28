import java.util.List;

public class LadderRenderer {

    private static final String LINE = "|";
    private static final String EMPTY = " ";
    private static final String CONNECT = "-";
    private static final int LENGTH = 5;

    /**
     * 사다리를 출력합니다.
     * 첫번째 줄에는 참가자들의 이름을 출력합니다.
     * 그 이후로는 사다리를 순서대로 출력합니다.
     */
    public void render(Ladder ladder) {
        List<String> playerNames = ladder.getPlayerNames();
        printNames(playerNames);
        for(int currentHeight = 0; currentHeight < ladder.getMaxLadderHeight(); currentHeight++) {
            printHeight(ladder, currentHeight);
        }
    }

    private void printNames(List<String> playerNames) {
        String names = makeNamesAsString(playerNames, LENGTH + 1);
        System.out.println(names);
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
            sb.insert(start, name);
        }
        return sb.toString();
    }

    /**
     * 사다리에서 한 줄을 출력합니다.
     * 사람의 이름에 사다리를 맞추기 위해서 여백을 출력한뒤, 사람 이름을 출력합니다.
     */
    private void printHeight(Ladder ladder, int height) {
        System.out.print(StringUtils.times(EMPTY, LENGTH / 2));
        for(int currentLine = 0; currentLine < ladder.getPlayerNum(); currentLine++) {
            printLine(ladder, currentLine, height);
        }
        System.out.println();
    }

    /**
     * 사다리에서 선(Line)을 출력합니다.
     * 연결되어있다면 "|-----"
     * 연결되어있지 않다면 "|     "
     * 마지막 선일 경우 "|" 만 출력합니다.
     */
    private void printLine(Ladder ladder, int line, int height) {
        System.out.print(LINE);
        if(line == ladder.getPlayerNum() - 1){
            return;
        }
        boolean isRightConnected = ladder.isRightConnected(line, height);
        printLineCounterPart(isRightConnected);
    }

    private void printLineCounterPart(boolean isRightConnected) {
        if (isRightConnected) {
            System.out.print(StringUtils.times(CONNECT, LENGTH));
            return;
        }
        System.out.print(StringUtils.times(EMPTY, LENGTH));
    }
}
