package domain;

import view.LadderGameInputManager;
import view.LadderGameRenderer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame{

    private final LadderGameInputManager inputManager;
    private final LadderGameRenderer renderer;

    private final List<String> participants;
    private final Ladder ladder;
    private final List<String> results;
    private final List<Integer> mappedResultIdx;

    private final String ALL = "all";

    public LadderGame(LadderGameInputManager inputManager, LadderGameRenderer renderer) {
        this.inputManager = inputManager;
        this.renderer = renderer;

        this.participants = inputManager.getParticipants();
        this.ladder = inputManager.getLadder(participants);
        this.results = inputManager.getResults();

        mappedResultIdx = calculateResults();
    }

    private List<Integer> calculateResults() {
        List<Integer> resultIdx = IntStream.range(0, participants.size())
                .boxed().collect(Collectors.toList());

        List<Line> listTypeLadder = ladder.getLadderToList();

        //라인 한 줄씩 탐색
        listTypeLadder.forEach(line -> calculateLineResults(resultIdx, line.getLineToList()));

        return Collections.unmodifiableList(resultIdx);
    }

    private void calculateLineResults(List<Integer> curIdx, List<Boolean> line) {
        //중간에 다리가 있으면 swap
        for (int i = 0; i < line.size(); i++) {
            if (line.get(i)) {
                Collections.swap(curIdx, i, i + 1);
            }
        }
    }

    public void play() {
        renderer.displayGameSettings(participants, ladder, results);

        String answer = inputManager.getRequest();

        while(answer != null) { //ESCAPE_WORD면 null
            getResponse(answer);
            answer = inputManager.getRequest();
        }
    }

    private void getResponse(String answer) {
        if(answer.equals(ALL)) {
            getAllResults();
        }
        else if(participants.stream().anyMatch(s -> s.equals(answer))) {
            getResult(answer);
        }
        else {
            renderer.displaySentence("명단에 없습니다. 다시 입력해주세요.");
        }
    }

    private void getAllResults() {
        for(int i = 0; i < participants.size(); i++) {
            int resultIdx = mappedResultIdx.indexOf(i);
            renderer.displaySentence(participants.get(i) + " : " + results.get(resultIdx));
        }
    }

    private void getResult(String answer) {
        int idx = participants.indexOf(answer);
        int resultIdx = mappedResultIdx.indexOf(idx);

        renderer.displaySentence(results.get(resultIdx));
    }
}
