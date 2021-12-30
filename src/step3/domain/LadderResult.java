package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LadderResult {

    private final List<String> result;
    private List<Integer> mappingResult;

    public LadderResult(String result) {
        this.result = new ArrayList<String>(Arrays.asList(result.split(",")));
        mappingResult = new ArrayList<Integer>(this.result.size());
        for(int i=0;i<this.result.size();i++){
            mappingResult.add(i);
        }
    }

    public void swap(int idx, boolean isSwap) {
        if(isSwap) {
            Collections.swap(mappingResult, idx, idx + 1);
        }
    }

    public List<String> getResult() { return result; }

    public List<String> getMappingResult() {
        List<String> retVal = new ArrayList<String>();
        for(int i=0;i<mappingResult.size();i++){
            retVal.add(result.get(mappingResult.indexOf(i)));
        }
        return retVal;
    }
    public String getMappingResult(int index) {
        int idx = mappingResult.indexOf(index);
        return result.get(idx);
    }
}
