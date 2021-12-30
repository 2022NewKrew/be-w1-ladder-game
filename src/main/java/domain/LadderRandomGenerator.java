package domain;

import common.value.LadderHeight;
import common.value.PlayerCount;
import domain.value.Ladder;
import domain.value.VerticalLine;

import java.util.Random;

public class LadderRandomGenerator implements LadderGenerator {

    private static Random random = new Random();

    public Ladder generate(LadderHeight ladderHeight, PlayerCount playerCount) {
        validatePlayerCount(playerCount);
        return generateRandomLadder(playerCount, ladderHeight);
    }

    private void validatePlayerCount(PlayerCount playerCount) {
        if(playerCount.getValue() - 1 < 0) {
            throw new IllegalArgumentException("사다리 생성 파라미터 오류 입니다~");
        }
    }

    private Ladder generateRandomLadder(PlayerCount playerCount, LadderHeight ladderHeight) {
        Ladder randomLadder = new Ladder(playerCount, ladderHeight);
        for(int playerNum = 0; playerNum < randomLadder.getPlayerCount() - 1; playerNum++) {
            generateHorizontalLine(randomLadder, playerNum);
        }
        return randomLadder;
    }

    private void generateHorizontalLine(Ladder ladder, int playerNum) {
        VerticalLine playerLine = ladder.getVerticalLine(playerNum);
        VerticalLine nextPlayerLine = ladder.getVerticalLine(playerNum + 1);
        for(int height = 0; height < playerLine.getHeight(); height++) {
            boolean existLadder = getExistLadder(playerLine, nextPlayerLine, height);
            if(existLadder == true) {
                ladder.makeHorizontalLine(playerNum, height);
            }
        }
    }

    private boolean getExistLadder(VerticalLine playerLine, VerticalLine nextPlayerLine, int height) {
        boolean existLadder = random.nextBoolean();
        if(playerLine.isConnectableTo(nextPlayerLine, height) == false) {
            existLadder = false;
        }
        return existLadder;
    }

}