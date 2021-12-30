package domain;

import java.util.List;

public class Name {

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getLength(){
        return name.length();
    }

    //이름의 유효성 검사
    public void nameValid() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다");
        }
    }

}
