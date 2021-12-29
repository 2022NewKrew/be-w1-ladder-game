public interface InputCondition {

    public boolean isValid(Object input);

    public String getQuery();

    public String getErrorMsg();

}
