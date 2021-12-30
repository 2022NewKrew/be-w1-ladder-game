package dto;

import domain.GameResult;
import domain.Ladder;

public class OutputDto {
    private final String ladderBoard;
    private final GameResult gameResult;

    public OutputDto(Ladder ladder){
        this.ladderBoard = ladder.toString();
        this.gameResult = ladder.getResult();
    }

    public String getLadderBoard(){
        return ladderBoard;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
