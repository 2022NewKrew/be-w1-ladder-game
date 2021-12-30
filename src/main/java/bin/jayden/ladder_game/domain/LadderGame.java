package bin.jayden.ladder_game.domain;

import bin.jayden.ladder_game.view.LadderGamePrinter;
import bin.jayden.ladder_game.view.LadderInfoScanner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LadderGame {
    public static final Scanner scanner = new Scanner(System.in);
    public final Map<String, String> resultMap = new HashMap<>();
    public Ladder ladder;
    public LadderGameInfo info;

    @SuppressWarnings("StatementWithEmptyBody")
    public void startLadderGame() {
        info = null;
        while (info == null) //입력을 제대로 받을때까지 반복해서 입력을 받는다.
            info = LadderInfoScanner.getLadderInfo();

        ladder = new Ladder(info.getWidth(), info.getHeight());

        LadderGamePrinter printer = new LadderGamePrinter(ladder, info, resultMap);
        printer.printGame();
        getResults();
        while (printer.printResult());
        System.out.println("\n게임을 종료합니다.");
    }

    private void getResults() {
        List<String> participants = info.getParticipants(), results = info.getResults();
        int width = info.getWidth();
        for (int i = 0; i < width; i++) {
            int resultIndex = getResultIndex(i);
            resultMap.put(participants.get(i), results.get(resultIndex));
        }
    }

    private int getResultIndex(int participantIndex) {
        int width = info.getWidth() - 1, height = info.getHeight(), line = participantIndex;
        List<LadderRow> ladderRows = ladder.getLadderRows();
        for (int i = 0; i < height; i++) {
            if (line > 0 && ladderRows.get(i).getIsLine(line - 1))
                line--;
            else if (line < width && ladderRows.get(i).getIsLine(line))
                line++;

        }
        return line;
    }


}
