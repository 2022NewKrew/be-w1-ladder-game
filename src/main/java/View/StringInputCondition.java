package View;

import java.util.ArrayList;
import java.util.List;

public class StringInputCondition implements InputCondition {

    private String query;
    private List<StringCond> condLst;
    private String errorMsg;

    public StringInputCondition(String query, List<StringCond> condLst, String errorMsg) {
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

    private boolean checkConds(List<StringCond> condLst, List<String> words, String word) {
        for (StringCond cond : condLst)
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
