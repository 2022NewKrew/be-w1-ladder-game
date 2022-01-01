package View;

import java.util.List;

public class StringListSizeEqualCond implements StringCond {
    private int limit;

    public StringListSizeEqualCond(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean isValid(List<String> strLst, String str) {
        if (strLst.size() == limit) return true;
        return false;
    }
}
