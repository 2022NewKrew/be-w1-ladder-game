package dto;

import domain.Ladder;

public class OutputDto {
    private final String ladderBoard;

    public OutputDto(Ladder ladder){
        this.ladderBoard = ladder.toString();
    }

    public String getLadderBoard(){
        return ladderBoard;
    }
}
