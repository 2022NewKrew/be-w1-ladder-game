package domain;

import java.util.ArrayList;

public class ResultList {
    private ArrayList<Result> results ;

    public ResultList(ArrayList<Result> results){
        this.results = results;
    }

    public String getResultName(int index){
        Result result = results.get(index);
        return result.getName();
    }

    public int getListSize(){
        return results.size();
    }
}
