package service.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGamePlay {
    public Map<String, Integer> playLadderGame(Ladder ladder){
        List<List<Integer>> ladderAlgorithmBoard = new ArrayList<>();
        BuildLadderAlgorithmBoard(ladderAlgorithmBoard, ladder);
        return calculateLadderGamePlayResult(ladderAlgorithmBoard, ladder.getParticipantsNames());
    }

    private Map<String, Integer> calculateLadderGamePlayResult(List<List<Integer>> ladderAlgorithmBoard, List<String> participantsNames) {
        HashMap<String, Integer> ladderGamePlayResult = new HashMap<>();
        for (int playerNumber = 0; playerNumber < participantsNames.size(); playerNumber++){
            ladderGamePlayResult.put(participantsNames.get(playerNumber), downPlayerToResult(playerNumber, ladderAlgorithmBoard));
        }
        return ladderGamePlayResult;
    }

    private Integer downPlayerToResult(int playerNumber, List<List<Integer>> ladderAlgorithmBoard) {
        int curLine = playerNumber;
        for (List<Integer> ladderLine : ladderAlgorithmBoard) {
            curLine = curLine != ladderLine.get(curLine) ? ladderLine.get(curLine) : curLine;
        }
        return curLine;
    }


    private void BuildLadderAlgorithmBoard(List<List<Integer>> ladderAlgorithmBoard, Ladder ladder) {
        initLadderAlgorithmBoard(ladderAlgorithmBoard, ladder.getLadder().size(), ladder.getParticipantsNames().size());
        buildConnectionOfLadderAlgorithmBoard(ladderAlgorithmBoard, ladder.getLadder());
    }

    private void buildConnectionOfLadderAlgorithmBoard(List<List<Integer>> ladderAlgorithmBoard, List<LadderLine> ladder) {
        for (int lineNumber = 0; lineNumber < ladder.size(); lineNumber++) {
            buildLadderAlgorithmBoardLine(ladderAlgorithmBoard.get(lineNumber), ladder.get(lineNumber).getIsLadderConnected());
        }
    }

    private void buildLadderAlgorithmBoardLine(List<Integer> ladderAlgorithmBoardLine, List<Boolean> isLadderConnected) {
        for (int i = 0; i < isLadderConnected.size(); i++){
            if (isLadderConnected.get(i)){
                int tmp = ladderAlgorithmBoardLine.get(i);
                ladderAlgorithmBoardLine.set(i, ladderAlgorithmBoardLine.get(i + 1));
                ladderAlgorithmBoardLine.set(i + 1, tmp);
            }
        }
    }

    private void initLadderAlgorithmBoard(List<List<Integer>> ladderAlgorithmBoard, int heights, int numberOfParticipants) {
        for (int i = 0; i < heights; i++){
            ladderAlgorithmBoard.add(IntStream.rangeClosed(0, numberOfParticipants - 1).boxed().collect(Collectors.toList()));
        }
    }


}
