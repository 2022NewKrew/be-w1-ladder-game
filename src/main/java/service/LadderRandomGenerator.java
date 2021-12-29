package service;

import common.value.DirectionType;
import common.value.LadderHeight;
import common.value.PlayerCount;
import service.value.Line;
import service.value.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRandomGenerator implements LadderGenerator {

    private static Random random = new Random();

    private List<Line> ladders;

    public List<Line> generate(LadderHeight ladderHeight, PlayerCount playerCount) {
        validate(ladderHeight, playerCount);
        initLadders(ladderHeight, playerCount);
        generateLadderRows();
        return ladders;
    }

    private void validate(LadderHeight ladderHeight, PlayerCount playerCount) {
        if(ladderHeight.getValue() < 0 || (playerCount.getValue() - 1) < 0) {
            throw new IllegalArgumentException("사다리 생성 파라미터 오류 입니다~");
        }
    }

    private void initLadders(LadderHeight ladderHeight, PlayerCount playerCount) {
        ladders = new ArrayList<>();
        for(int i = 0; i < playerCount.getValue(); i++)
        {
            ladders.add(new Line(ladderHeight.getValue()));
        }
    }

    private List<Line> generateLadderRows() {
        int rowSize = ladders.get(0).getHeight();
        for(int row = 0; row < rowSize; row++) {
            generateLadderRow(row);
        }
        return ladders;
    }

    private void generateLadderRow(int rowIndex) {
        int colSize = ladders.size();
        for(int colIndex = 0; colIndex < colSize - 1; colIndex++) {
            boolean existLadder = getExistLadder(rowIndex, colIndex);
            if(existLadder == true) {
                connectLadder(rowIndex, colIndex);
            }
        }
    }

    private boolean getExistLadder(int rowIndex, int colIndex) {
        boolean existLadder = random.nextBoolean();
        while(!validateExistLadder(rowIndex, colIndex, existLadder)) {
            existLadder = random.nextBoolean();
        }
        return existLadder;
    }

    private boolean validateExistLadder(int rowIndex, int colIndex, boolean existLadder) {

        if(existLadder == false || colIndex == 0) { return true; }

        Point point = ladders.get(colIndex).getPoint(rowIndex);
        if(point.getDirection() == DirectionType.LEFT) {
            return false;
        }

        return true;
    }

    private void connectLadder(int rowIndex, int colIndex) {
        Line leftLine = ladders.get(colIndex);
        Point leftPoint = leftLine.getPoint(rowIndex);
        leftPoint.setDirection(DirectionType.RIGHT);

        Line rightLine = ladders.get(colIndex + 1);
        Point rightPoint = rightLine.getPoint(rowIndex);
        rightPoint.setDirection(DirectionType.LEFT);
    }
}