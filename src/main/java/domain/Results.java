package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private final List<String> result;

    public Results(String[] resultList){
        result = new ArrayList<>();

        for (String res : resultList) {
            result.add(convertResult(res));
        }
    }

    public List<String> getResult() {
        return result;
    }

    private String convertResult(String res){
        if(res.length() > LadderConst.OUTPUT_RESULT_SIZE){
            return res.substring(0, LadderConst.OUTPUT_RESULT_SIZE);
        }

        return res;
    }
}
