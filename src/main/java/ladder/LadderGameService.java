package ladder;

import ladder.domain.*;
import ladder.stratgey.LadderStrategy;
import ladder.stratgey.LadderStrategyFactory;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;


//사다리 게임 서비스
public class LadderGameService {
    //사다리게임
    private Players players; //게임 플레이어 정보
    private Ladder ladder; //사다리 정보
    private Results results; //사다리 게임 결과

    //입출력
    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();

    //게임전략
    private static final String LADDER_STRATEGY = "RANDOM";
    private LadderStrategy ladderStrategy;

    //종료
    private static final String EXIT_CODE = "춘식이";
    private static final String EXIT_MESSAGE = "게임을 종료합니다";

    public LadderGameService() {
        players = new Players();
        ladder = new Ladder();
        results = new Results();
    }

    //게임 시작
    public void startGame() {
        List<String> playersName = inputView.inputPlayersName();
        List<String> gameResults = inputView.inputGameResults();
        int height = inputView.inputLadderHeight();

        initGameInfo(playersName, gameResults, height);
        drawBridgesByStrategy();
        results.findAllResults(players, ladder);

        outputView.printLadderGameResults(players, ladder, results);
        showGameResults();
    }
    
    //사용자로부터 원하는 플레어에대한 결과를 보여줌
    private void showGameResults() {
        String resultPlayerName = inputView.inputResultPlayerName();

        while (!EXIT_CODE.equals(resultPlayerName)) {
            System.out.println(results.getGameResult(resultPlayerName));
            resultPlayerName = inputView.inputResultPlayerName();
        }
        System.out.println(EXIT_MESSAGE);
    }
    
    //게임에 필요한 정보 초기화
    public void initGameInfo(List<String> playersName, List<String> gameResults, int height) {
        makePlayers(playersName);
        makeGameResults(gameResults);
        makeLadder(height);
        makeStrategy();
    }
    
    //사다리 하단 게임결과 정보 생성
    private void makeGameResults(List<String> gameResults) {
        gameResults.forEach(r -> this.results.addResult(r));
    }

    //플레이어들의 정보 생성
    private void makePlayers(List<String> playersName) {
        for (String playerName : playersName) {
            Player player = new Player(playerName);
            player.checkPlayerName();

            players.addPlayer(player);
        }
    }

    //사다리 정보 생성
    private void makeLadder(int height) {
        int playersCnt = players.getPlayersCnt();

        ladder = new Ladder();
        ladder.initLadder(playersCnt, height);

        for (int i = 0; i < playersCnt; i++) {
            Line curLine = ladder.getOneLine(i);
            curLine.initLine(height);
        }
    }

    //전략 정보 생성
    private void makeStrategy() {
        LadderStrategyFactory ladderStrategyFactory = new LadderStrategyFactory();

        ladderStrategy = ladderStrategyFactory.getLadderStrategy(LADDER_STRATEGY);
    }

    //선택된 정책에 의한 브릿지 그리기
    public void drawBridgesByStrategy() {
        int height = ladder.getHeight();
        int playersCnt = players.getPlayersCnt();
        int totalCnt = ladderStrategy.getBridgeCntBound(height, playersCnt);

        for (int i = 0; i < totalCnt; i++) {
            int bridgeIdx = ladderStrategy.getBridgeIdx() % height;
            int lineIdx = ladderStrategy.getLineIdx() % (playersCnt - 1);

            ladder.drawBridge(lineIdx, bridgeIdx);
        }
    }
}
