package Domain;

import View.Input;

import java.util.ArrayList;
import java.util.List;

public class ResultList {
    ArrayList<Result> results;

    public ResultList() {
        this.results = new ArrayList<>();
    }

    public ResultList(ArrayList<Result> results) {
        this.results = results;
    }

    public ResultList(Input<ArrayList<String>> resultInput) {
        this();
        makeResults(resultInput);
    }

    private void makeResults(Input<ArrayList<String>> resultInput) {
        ArrayList<String> resultStrs = resultInput.getValue();
        for (String result : resultStrs)
            results.add(new Result(result));
    }


    public ResultList getResultListByIdx(List<Integer> idxList) {
        ArrayList<Result> resultsCopy = new ArrayList<>();
        for (int idx : idxList)
            resultsCopy.add(results.get(idx));
        return new ResultList(resultsCopy);
    }

    public ArrayList<Result> getResults() {
        return results;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        int len = (results.size() + 1) * 5 + results.size();

        for (int i = 0; i < len; i++)
            sb.append(" ");

        for (int i = 0; i < results.size(); i++) {
            int cursor = 5 + 6 * i;
            String player = results.get(i).toString();
            int mid = player.length() / 2;
            sb.replace(cursor - mid, cursor - mid + player.length(), player);
        }
        return sb.toString();
    }

}
