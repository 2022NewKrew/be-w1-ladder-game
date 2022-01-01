package View;

import java.util.List;

public class StringListSizeGreaterThanEqualCond implements StringCond {
    private int limit;

    public StringListSizeGreaterThanEqualCond(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean isValid(List<String> strLst, String str) {
        if (strLst.size() <= limit) return false;
        return true;
    }
}
