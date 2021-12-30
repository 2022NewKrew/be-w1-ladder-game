package dao;

import domain.ladder.Ladder;
import dto.LadderDTO;

public class LadderDAO {

    private final Ladder ladder;

    public LadderDAO(int frameLength, int height){
        ladder = new Ladder(frameLength, height);
    }

    public LadderDTO getLadderDTO(){
        return new LadderDTO(ladder);
    }
}
