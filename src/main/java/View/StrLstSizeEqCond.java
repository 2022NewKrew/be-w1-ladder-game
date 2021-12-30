package View;

import java.util.ArrayList;

public class StrLstSizeEqCond implements StrCond {
    int limit;

    public StrLstSizeEqCond(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean isValid(ArrayList<String> strLst, String str) {
        if (strLst.size() == limit) return true;
        return false;
    }
}
