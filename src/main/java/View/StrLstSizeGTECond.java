package View;

import java.util.ArrayList;

public class StrLstSizeGTECond implements StrCond {
    int limit;

    public StrLstSizeGTECond(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean isValid(ArrayList<String> strLst, String str) {
        if (strLst.size() <= limit) return false;
        return true;
    }
}
