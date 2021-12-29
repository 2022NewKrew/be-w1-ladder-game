public class InputCondition {
    private String query;
    private int limit;
    private String errorMsg;

    public InputCondition(String query, int limit, String errorMsg) {
        this.query = query;
        this.limit = limit;
        this.errorMsg = errorMsg;
    }

    public boolean isValid(int input) {
        if (input > limit) return true;
        return false;
    }

    public String getQuery() {
        return query;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
