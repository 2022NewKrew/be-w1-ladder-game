package Domain;

import java.util.List;

public class ResultService {
    ResultList resultList;

    public void makeResultList(List<String> resultInput, int size) {
        resultList = new ResultList(resultInput, size);
    }

    public ResultList getResultList() {
        return resultList;
    }

    public ResultList getResultList(List<Integer> idxList) {
        return resultList.getResultListByIdx(idxList);
    }


}
