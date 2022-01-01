package DTO;

import java.util.List;

public class InputDTO {
    private final List<String> people;
    private final List<String> results;
    private final int heightOfLadder;

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
