package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Results implements Iterable<Result> {
    List<Result> results;

    public Results(List<String> results) {
        this.results = new ArrayList<>();
        for (String result : results)
            this.results.add(new Result(result));
    }

    @Override
    public Iterator<Result> iterator() {
        return results.iterator();
    }

    public Results getResultsByIdx(List<Integer> idxList) {
        List<String> results = new ArrayList<>();
        for (int idx : idxList)
            results.add(this.results.get(idx).getResult());
        return new Results(results);
    }

    public List<Result> getResults() {
        return results;
    }

    public int size() {
        return results.size();
    }

    public Result get(int idx) {
        return results.get(idx);
    }

}
