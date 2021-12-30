package View;

import java.util.ArrayList;

public class StrInputCondition implements InputCondition {

    private String query;
    private ArrayList<StrCond> condLst;
    private String errorMsg;

    public StrInputCondition(String query, ArrayList<StrCond> condLst, String errorMsg) {
        this.query = query;
        this.condLst = condLst;
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean isValid(Object input) {
        ArrayList<String> words = (ArrayList<String>) input;
        for (String word : words)
            if (!checkConds(condLst, words, word)) return false;
        return true;
    }

    private boolean checkConds(ArrayList<StrCond> condLst, ArrayList<String> words, String word) {
        for (StrCond cond : condLst)
            if (!cond.isValid(words, word)) return false;
        return true;
    }

    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}
