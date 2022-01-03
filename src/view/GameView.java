package view;

import domain.LadderGame;
import domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public class GameView {
    private static final String LUMBER = "|";
    private static final String BRIDGE = "-";
    private static final String SPACE = " ";

    private LadderGame currentGame;

    public GameView(LadderGame game) {
        currentGame = game;
    }

    // 현재는 콘솔 출력이지만, 향후 출력 형태의 확장성을 위해 출력 함수를 따로 정의
    public void print(String message) {
        System.out.println(message);
    }

    public void showParticipants() {
        print(getNameList(currentGame.getParticipants()));
    }

    public void showLadder() {
        List<Line> ladder = currentGame.getLadder();
        // 출력할 Row는 getLadderRow로부터 출력 양식에 맞추어 받아옴
        for (Line currentLine : ladder) {
            print(getLadderRow(currentLine));
        }
    }

    protected String getNameList(List<String> participants) {
        return participants
                .stream()
                .map(participantName -> getStandardizedName(participantName))
                .collect(Collectors.joining(SPACE));
    }

    // MAX_NAME_LENGTH 에 맞춰 이름 양쪽에 공백을 더해줘서 사이즈를 규격화
    protected String getStandardizedName(String name) {
        int maxNameLength = currentGame.getMaxNameLength();
        // 현재 참가자 이름의 길이
        int nameLength = name.length();
        // 이름 길이에 따라 왼쪽 indent 계산
        int leftIndent = (int) (maxNameLength - nameLength) / 2;
        // 오른쪽 indent 계산
        int rightIndent = maxNameLength - nameLength - leftIndent;
        // 계산한 indent 대로 왼쪽공백+이름+오른쪽공백 을 리턴
        return SPACE.repeat(leftIndent) + name + SPACE.repeat(rightIndent);
    }

    private String getLadderRow(Line line) {
        // 처음, 끝단에 있는 사다리 막대(LUMBER) 양쪽에 들여쓸 빈칸 크기 indent 계산
        int indent = (int) currentGame.getMaxNameLength() / 2;
        // lineString에 들여쓰기만큼의 빈칸을 넣어주면서 초기화
        StringBuilder ladderRow = new StringBuilder(SPACE.repeat(indent));
        // 제일 첫 LUMBER 추가
        ladderRow.append(LUMBER);
        // lineLength 만큼 순회하면서 points가 true면 BRIDGE, false면 SPACE를 maxNameLength 길이만큼 늘려서 추가
        // 추가 후에는 또 LUMBER 추가
        for (int i = 0; i < line.getLength(); i++) {
            ladderRow.append(ladderElement(line.getPoints().get(i)));
            ladderRow.append(LUMBER);
        }
        return ladderRow.toString();
    }

    private String ladderElement(boolean isBridge) {
        // 연결되어있는지 여부 isBridge에 따라 사다리 구성요소(연결다리 or 빈칸)를 리턴
        if (isBridge) {
            return BRIDGE.repeat(currentGame.getMaxNameLength());
        }
        return SPACE.repeat(currentGame.getMaxNameLength());
    }
}
