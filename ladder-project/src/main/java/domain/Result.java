package domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<String> results;

    public Result(List<String> results) {
        this.results = results;
    }

    public List<String> getResult() {
        return new ArrayList<>(results);
    }
}
