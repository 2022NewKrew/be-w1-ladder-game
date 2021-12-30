package repository;

public class Player {
    private final String name;
    private String result;

    public Player(String name, String result){
        this.name = name;
        this.result = result;
    }

    public String getName() { return name; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
