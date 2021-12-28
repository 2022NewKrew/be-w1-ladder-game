import java.util.ArrayList;

public class LstSizeStrCond implements StrCond {
    int limit;

    public LstSizeStrCond(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean isValid(ArrayList<String> strLst, String str) {
        if (strLst.size() <= limit) return false;
        return true;
    }
}
