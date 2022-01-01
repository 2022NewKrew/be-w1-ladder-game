package DTO;

import java.util.List;

public class InputDTO {
    private List<String> people;
    private List<String> results;
    private int heightOfLadder;

    public InputDTO(List<String> people, List<String> results, int heightOfLadder) {
        this.people = people;
        this.results = results;
        this.heightOfLadder = heightOfLadder;
    }

    public List<String> getPeople() {
        return people;
    }

    public List<String> getResults() {
        return results;
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }
}
