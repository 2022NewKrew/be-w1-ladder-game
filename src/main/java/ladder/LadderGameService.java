package ladder;

import ladder.domain.*;
import ladder.exception.NameLengthException;
import ladder.stratgey.LadderStrategy;
import ladder.stratgey.LadderStrategyFactory;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

//사다리 게임 서비스
public class LadderGameService {
    //사다리게임
    private Players players = null; //게임 플레이어 정보
    private Ladder ladder = null; //사다리 정보

    //입출력
    private OutputView outputView = OutputView.getInstance();

    //게임전략
    private LadderStrategy ladderStrategy;


    //플레이어들 이름 구하기
    public List<String> getPlayersName() {
        return players.getPlayersName();
    }

    public Ladder getLadder() {
        return ladder;
    }

    //사다리게임 정보 출력
    public void printLadderInfo() {
        outputView.printPlayersName(players);
        outputView.printLadder(ladder, players.getPlayersCnt());
    }

    //플레이어들의 정보 생성
    public void makePlayers(List<String> playersName) {
        int initialSize = playersName.size();

        playersName = playersName.stream().filter(this::checkNameLength).collect(Collectors.toList());
        if (playersName.size() < initialSize) {
            throw new NameLengthException("플레이어의 이름은 5글자 미만으로 입력하시오.");
        }

        players = new Players(playersName.size());
        for (String playerName : playersName) {
            players.addPlayer(new Player(playerName));
        }
    }

    //플레이어 이름 길이 검증
    private boolean checkNameLength(String name) {
        if (name.length() <= 5) {
            return true;
        }
        return false;
    }

    //사다리 정보 생성
    public void makeLadder(int height) {
        int playersCnt = players.getPlayersCnt();

        ladder = new Ladder(playersCnt);
        ladder.initLadder(playersCnt, height);

        for (int i = 0; i < playersCnt; i++) {
            Line curLine = ladder.getOneLine(i);
            curLine.initLine(height);
        }
    }

    //전략 정보 생성
    public void makeStrategy(String type) {
        LadderStrategyFactory ladderStrategyFactory = new LadderStrategyFactory();

        ladderStrategy = ladderStrategyFactory.getLadderStrategy(type);
    }

    //선택된 정책에 의한 브릿지 그리기
    public void drawBridgesByStrategy() {
        int height = ladder.getHeight();
        int playersCnt = players.getPlayersCnt();
        int totalCnt = ladderStrategy.getBridgeCntBound(height, playersCnt);

        for (int i = 0; i < totalCnt; i++) {
            int bridgeIdx = ladderStrategy.getBridgeIdx() % height;
            int lineIdx = ladderStrategy.getLineIdx() % (playersCnt - 1);

            drawBridge(lineIdx, bridgeIdx);
        }
    }

    //사다리 가로 브릿지 정보 추가
    public void drawBridge(int lineIdx, int bridgeIdx) {
        if (!checkLadderPolicy(lineIdx, bridgeIdx)) {
            return;
        }
        Line line = ladder.getOneLine(lineIdx);
        Bridge bridge = line.getOneBridge(bridgeIdx);

        bridge.drawBridge();
    }

    //사다리 인접 브릿지 검사
    private boolean checkLadderPolicy(int lineIdx, int bridgeIdx) {
        if (lineIdx == 0) {
            return checkBridgeExist(lineIdx + 1, bridgeIdx); // 오른쪽에 bridge 존재하는지 체크
        } else if (lineIdx == players.getPlayersCnt() - 1) {
            return checkBridgeExist(lineIdx - 1, bridgeIdx);
        }
        return checkBridgeExist(lineIdx - 1, bridgeIdx) && checkBridgeExist(lineIdx + 1, bridgeIdx); // 양쪽에 bridge 존재하는지 체크
    }

    //브릿지 존재 여부 검증
    private boolean checkBridgeExist(int lineIdx, int bridgeIdx) {
        Line line = ladder.getOneLine(lineIdx);
        Bridge bridge = line.getOneBridge(bridgeIdx);

        if (bridge.isExist()) {
            return false;
        }
        return true;
    }

}
