package service;

import configuration.LadderGameConfiguration;
import configuration.LadderHeight;
import configuration.PeopleCount;

public class LadderGameService {

    private final LadderGameConfiguration ladderGameConfiguration;

    private final LadderGenerator ladderGenerator;

    private boolean[][] ladderStatus;

    public LadderGameService(LadderGameConfiguration ladderGameConfiguration, LadderGenerator ladderGameGenerator) {
        this.ladderGameConfiguration = ladderGameConfiguration;
        this.ladderGenerator = ladderGameGenerator;
    }

    public void start() {
        // 현재 게임의 기능은 사다리생성/사다리출력만 있으며,
        // 추가로 게임의 로직이 정해지면 아래에 추가할 것.
        // 1. 사다리 생성
        LadderHeight maxLadderHeight = ladderGameConfiguration.getMaxLadderHeight();
        PeopleCount peopleCount = ladderGameConfiguration.getPeopleCount();

        ladderStatus = ladderGenerator.generate(
                maxLadderHeight.getValue(),
                peopleCount.getValue() - 1
        );

        // 2. 사다리 출력
        printLadderRows();
    }

    private void printLadderRows() {
        int height = ladderStatus.length;
        for(int row = 0; row < height; row++) {
            printLadderRow(row);
        }
    }

    private void printLadderRow(int rowIndex) {

        int width = ladderStatus[0].length;
        StringBuilder stringBuilder = new StringBuilder();

        for(int colIndex = 0; colIndex < width; colIndex++) {
            String ladder = "| ";

            boolean existLadder = ladderStatus[rowIndex][colIndex];
            if(existLadder) {
                ladder = "|-";
            }

            stringBuilder.append(ladder);
        }
        stringBuilder.append("|");

        System.out.println(stringBuilder);
    }
}
