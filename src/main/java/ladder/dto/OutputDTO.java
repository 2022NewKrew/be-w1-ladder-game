package ladder.dto;


import ladder.domain.Line;

import java.util.List;

public class OutputDTO {

    List<Line> ladder;
    String[] namesOfPeople;

    public List<Line> getLadder() {
        return ladder;
    }

    public String[] getNamesOfPeople() {
        return namesOfPeople;
    }

    private OutputDTO(){}

    public OutputDTO(List<Line> ladder,String[] namesOfPeople){
        this.ladder=ladder;
        this.namesOfPeople=namesOfPeople;
    }
}
