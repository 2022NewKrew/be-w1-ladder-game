package View;

public class NoneInputCondition implements InputCondition{
    String query;

    public NoneInputCondition(String query){
        this.query = query;
    }

    @Override
    public boolean isValid(Object input) {
        return true;
    }

    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
