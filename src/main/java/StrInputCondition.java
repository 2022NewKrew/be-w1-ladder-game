import java.util.ArrayList;

public class StrInputCondition implements InputCondition{

    private String query;
    ArrayList<StrCond> condLst;
    private String errorMsg;

    public StrInputCondition(String query, ArrayList<StrCond> condLst, String errorMsg){
        this.query = query;
        this.condLst = condLst;
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean isValid(Input input) {
        ArrayList<String> inputs = (ArrayList<String>) input.getValue();
        for(String word : inputs)
            if(!checkConds(condLst, inputs, word)) return false;
        return true;
    }

    private boolean checkConds(ArrayList<StrCond> condLst, ArrayList<String> words, String word){
        for(StrCond cond : condLst)
            if(!cond.isValid(words, word)) return false;
        return true;
    }

    @Override
    public String getQuery() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
