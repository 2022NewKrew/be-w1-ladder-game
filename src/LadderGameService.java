import inout.InputOutputInfo;
import ladder.LadderInfo;
import players.PlayersInfo;

//사다리 게임 서비스
public class LadderGameService {
    private PlayersInfo playersInfo = null; //게임 플레이어 정보
    private LadderInfo ladderInfo = null; //사다리 정보

    //사다리 높이와 플레이어 수 입력
    private void inputInfo() {
        InputOutputInfo inputOutputInfo = InputOutputInfo.getInstance();

        playersInfo = new PlayersInfo(inputOutputInfo.inputPlayersCnt());
        ladderInfo = new LadderInfo(inputOutputInfo.inputLadderHeight(), playersInfo.getTotalNum());
    }

    //사다리 만들기
    public void makeLadder() {
        inputInfo();

        ladderInfo.initLadder();
        ladderInfo.insertBridgeInfo();
    }

    //사다리 출력
    public void printLadderInfo() {
        InputOutputInfo inputOutputInfo = InputOutputInfo.getInstance();

        inputOutputInfo.printLadder(ladderInfo);
    }

}
