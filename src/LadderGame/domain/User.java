package LadderGame.domain;

public class User {
    private static final int MAX_NAME_SIZE = 5;

    private final String name;
    private String result;

    public User(String name) {
        this.name = createName(name);
    }

    private String createName(String name) {
        try {
            checkMaxLengthName(name);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return name;
    }

    private void checkMaxLengthName(String name) throws Exception {
        if (name.length() > MAX_NAME_SIZE) {
            throw new Exception("이름 크기는 " + MAX_NAME_SIZE + "을(를) 넘을 수 없습니다.");
        }
        if (name.length() <= 0) {
            throw new Exception("이름 크기는 0보다 커야합니다.");
        }
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }

    public String getName() {
        return this.name;
    }

    public String getNameResult() {
        return this.name + " : " + this.result;
    }
}
