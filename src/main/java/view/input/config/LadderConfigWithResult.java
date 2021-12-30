package view.input.config;

import view.input.config.LadderConfigWithName;

import java.util.List;

public class LadderConfigWithResult extends LadderConfigWithName {

    private final List<String> results;

    public LadderConfigWithResult(int peopleCount, int height, List<String> names, List<String> results) {
        super(peopleCount, height, names);
        this.results = results;
    }

    public List<String> getResults() {
        return results;
    }
}
