public class InputCondition {
    private String query;
    private int limit;
    private String errorMsg;

    public InputCondition(String query, int limit, String errorMsg){
        this.query = query;
        this.limit = limit;
        this.errorMsg = errorMsg;
    }

    public boolean isValid(int input){
        if(input > limit) return true;
        System.out.println(getErrorMsg());
        return false;
    }

    public String getQuery(){
        return query;
    }

    private String getErrorMsg(){
        return errorMsg;
    }

}
