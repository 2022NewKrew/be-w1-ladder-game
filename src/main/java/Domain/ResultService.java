package Domain;

import View.Input;

import java.util.ArrayList;
import java.util.List;

public class ResultService {
    ResultList resultList;

    public void makeResultList(Input<ArrayList<String>> resultInput) {
        resultList = new ResultList(resultInput);
    }

    public ResultList getResultList() {
        return resultList;
    }

    public ResultList getResultList(List<Integer> idxList) {
        return resultList.getResultListByIdx(idxList);
    }


}
