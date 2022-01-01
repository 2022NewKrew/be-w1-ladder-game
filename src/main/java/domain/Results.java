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
        if(res.length() > 5){
            return res.substring(0, 5);
        }

        return res;
    }
}
