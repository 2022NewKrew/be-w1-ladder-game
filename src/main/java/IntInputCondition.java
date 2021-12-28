public class IntInputCondition implements InputCondition{
    private String query;
    private int limit;
    private String errorMsg;

    public IntInputCondition(String query, int limit, String errorMsg) {
        this.query = query;
        this.limit = limit;
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean isValid(Input input) {
        if ((int)input.getValue() > limit) return true;
        return false;
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
