import java.util.ArrayList;

public class LenLTStrCond implements StrCond{
    int limit;
    public LenLTStrCond(int limit){
        this.limit = limit;
    }
    @Override
    public boolean isValid(ArrayList<String> strLst, String str) {
        if(str.length() > limit) return false;
        return true;
    }
}
