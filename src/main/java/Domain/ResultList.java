package Domain;

import View.Input;

import java.util.ArrayList;
import java.util.List;

public class ResultList {
    Results results;

    public ResultList(List<String> results, int size) {
        if (results.size() != size) {
            throw new IllegalArgumentException(String.format("입력 값의 갯수는 %d 개여야 합니다!", size));
        }
        this.results = new Results(results);
    }

    public ResultList(Results results) {
        this.results = results;
    }

    public ResultList getResultListByIdx(List<Integer> idxList) {
        return new ResultList(results.getResultsByIdx(idxList));
    }

    public Results getResults() {
        return results;
    }

    public String toString() {
        return results.toString();
    }


}
