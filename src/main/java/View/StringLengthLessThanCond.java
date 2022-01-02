package View;

import java.util.List;

public class StringLengthLessThanCond implements StringCond {
    private int limit;

    public StringLengthLessThanCond(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean isValid(List<String> strLst, String str) {
        if (str.length() > limit) return false;
        return true;
    }
}
