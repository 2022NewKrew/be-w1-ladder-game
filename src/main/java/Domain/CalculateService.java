package Domain;

import View.Input;

import java.util.ArrayList;
import java.util.List;

public class CalculateService {

    private final LadderService ladderService;
    private final PlayerService playerService;
    private final ResultService resultService;

    public CalculateService(LadderService ladderService, PlayerService playerService, ResultService resultService) {
        this.ladderService = ladderService;
        this.playerService = playerService;
        this.resultService = resultService;
    }


    public ResultList calculatePlayerResult(Input<ArrayList<String>> players) {
        List<Integer> playerIdxLst = playerService.getPlayerIdxLst(players);
        List<Integer> dstIdxLst = ladderService.getPlayerDstIdx(playerIdxLst);
        ResultList results = resultService.getResultList(dstIdxLst);
        return results;
    }

    public ResultList calculateAllPlayerResult() {
        List<Integer> playerIdxLst = playerService.getAllPlayerIdxLst();
        List<Integer> dstIdxLst = ladderService.getPlayerDstIdx(playerIdxLst);
        ResultList results = resultService.getResultList(dstIdxLst);
        return results;
    }


}
