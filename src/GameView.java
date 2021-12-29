import java.util.List;

public class GameView {
    private final String LUMBER = "|";
    private final String BRIDGE = "-";
    private final String SPACE = " ";
    private final int maxNameLength = 5;

    LadderGame currentGame;
    List<Line> currentLadder;
    String[] currentParticipants;
    int numOfParticipants;
    int lineSize;
    int height;

    GameView(LadderGame game) {
        currentGame = game;
        currentLadder = currentGame.getLadder();
        currentParticipants = currentGame.getParticipants();
        numOfParticipants = currentParticipants.length;
        lineSize = numOfParticipants - 1;
        height = currentLadder.size();
    }

    public void showParticipants() {
        // 참가자들을 출력하기 위한 StringBuilder 생성
        StringBuilder nameString = new StringBuilder();
        // 루프를 돌면서 참가자들을 추가
        for (int i = 0; i < numOfParticipants; i++) {
            // 현재 참가자 이름의 길이
            int nameLength = currentParticipants[i].length();
            // 이름 길이에 따라 왼쪽 indent 계산
            int leftIndent = (int) (maxNameLength - nameLength) / 2;
            // 오른쪽 indent 계산한 뒤, +1을 해주어 참가자들 이름 사이에 1칸씩 빈칸을 둠
            int rightIndent = maxNameLength - nameLength - leftIndent + 1;
            // 왼쪽 indent, 이름, 오른쪽 indent 순으로 append
            nameString.append(SPACE.repeat(leftIndent));
            nameString.append(currentParticipants[i]);
            nameString.append(SPACE.repeat(rightIndent));
        }
        System.out.println(nameString);
    }

    public void showLadder() {
        // 사다리의 높이만큼 순회하면서 Line을 출력
        // 출력할 Line은 getLineString으로부터 출력 양식에 맞추어 받아옴
        for (int i = 0; i < height; i++) {
            Line currentLine = currentLadder.get(i);
            System.out.println(getLineString(currentLine));
        }
    }

    private StringBuilder getLineString(Line line) {
        // 처음, 끝단에 있는 사다리 막대(LUMBER) 양쪽에 들여쓸 빈칸 크기 indent 계산
        int indent = (int) maxNameLength / 2;
        // lineString에 들여쓰기만큼의 빈칸을 넣어주면서 초기화
        StringBuilder lineString = new StringBuilder(SPACE.repeat(indent));
        // 제일 첫 LUMBER 추가
        lineString.append(LUMBER);
        // lineSize 만큼 순회하면서 points가 true면 BRIDGE, false면 SPACE를 maxNameLength 길이만큼 늘려서 추가
        // 추가 후에는 또 LUMBER 추가
        for (int i = 0; i < lineSize; i++) {
            lineString.append(ladderElement(line.getPoints().get(i), maxNameLength));
            lineString.append(LUMBER);
        }
        // 마지막 LUMBER 뒤에 올 indent만큼의 SPACE (사실 없어도 될 듯 함)
        lineString.append(SPACE.repeat(indent));
        return lineString;
    }

    private String ladderElement(boolean isBridge, int maxNameLength) {
        // 연결되어있는지 여부 isBridge에 따라 사다리 구성요소(연결다리 or 빈칸)를 리턴
        if (isBridge) {
            return BRIDGE.repeat(maxNameLength);
        }
        return SPACE.repeat(maxNameLength);
    }
}
