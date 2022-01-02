package DTO;

import java.util.List;

public class ResultInfo {
    private final String stringLadder;
    private final List<Integer> resultOrder;

    public ResultInfo(String stringLadder, List<Integer> resultOrder) {
        this.stringLadder = stringLadder;
        this.resultOrder = resultOrder;
    }

    public String getStringLadder() {
        return stringLadder;
    }

    public List<Integer> getResultPeople() {
        return resultOrder;
    }
}
