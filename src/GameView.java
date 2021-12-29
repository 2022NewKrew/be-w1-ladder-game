import java.util.ArrayList;
import java.util.List;

public class GameView {
    private static final String LUMBER = "|";
    private static final String BRIDGE = "-";
    private static final String SPACE = " ";

    private LadderGame currentGame;

    GameView(LadderGame game) {
        currentGame = game;
    }

    public void showParticipants() {
        System.out.println(getNameList());
    }

    public void showLadder() {
        // 사다리의 높이만큼 순회하면서 LadderRow를 출력
        // 출력할 Row는 getLadderRow로부터 출력 양식에 맞추어 받아옴
        for (int i = 0; i < currentGame.getHeight(); i++) {
            Line currentLine = currentGame.getLadder().get(i);
            System.out.println(getLadderRow(currentLine));
        }
    }

    private StringBuilder getNameList() {
        // 참가자들을 출력하기 위한 StringBuilder 생성
        StringBuilder nameList = new StringBuilder();
        // 루프를 돌면서 참가자들을 추가
        for (int i = 0; i < currentGame.getNumOfParticipants(); i++) {
            // 현재 참가자 이름의 길이
            int nameLength = currentGame.getParticipants().get(i).length();
            // 이름 길이에 따라 왼쪽 indent 계산
            int leftIndent = (int) (currentGame.getMaxNameLength() - nameLength) / 2;
            // 오른쪽 indent 계산한 뒤, +1을 해주어 참가자들 이름 사이에 1칸씩 빈칸을 둠
            int rightIndent = currentGame.getMaxNameLength() - nameLength - leftIndent + 1;
            // 왼쪽 indent, 이름, 오른쪽 indent 순으로 append
            nameList.append(SPACE.repeat(leftIndent));
            nameList.append(currentGame.getParticipants().get(i));
            nameList.append(SPACE.repeat(rightIndent));
        }
        return nameList;
    }

    private StringBuilder getLadderRow(Line line) {
        // 처음, 끝단에 있는 사다리 막대(LUMBER) 양쪽에 들여쓸 빈칸 크기 indent 계산
        int indent = (int) currentGame.getMaxNameLength() / 2;
        // lineString에 들여쓰기만큼의 빈칸을 넣어주면서 초기화
        StringBuilder ladderRow = new StringBuilder(SPACE.repeat(indent));
        // 제일 첫 LUMBER 추가
        ladderRow.append(LUMBER);
        // lineSize 만큼 순회하면서 points가 true면 BRIDGE, false면 SPACE를 maxNameLength 길이만큼 늘려서 추가
        // 추가 후에는 또 LUMBER 추가
        for (int i = 0; i < currentGame.getLadder().get(0).getLineLength(); i++) {
            ladderRow.append(ladderElement(line.getPoints().get(i)));
            ladderRow.append(LUMBER);
        }
        return ladderRow;
    }

    private String ladderElement(boolean isBridge) {
        // 연결되어있는지 여부 isBridge에 따라 사다리 구성요소(연결다리 or 빈칸)를 리턴
        if (isBridge) {
            return BRIDGE.repeat(currentGame.getMaxNameLength());
        }
        return SPACE.repeat(currentGame.getMaxNameLength());
    }
}
