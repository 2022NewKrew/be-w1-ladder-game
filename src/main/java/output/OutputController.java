package output;

import service.domain.Ladder;

import java.util.List;
import java.util.Map;

public interface OutputController {
    public void outputLadder(Ladder ladder);

    void outputResult(Map<String, Integer> playLadderGameResult, List<String> gameResultsLine, String result);

    void outputEndingComment();
}
