public interface InputCondition {

    public boolean isValid(Input input);

    public String getQuery();

    public String getErrorMsg();

}
