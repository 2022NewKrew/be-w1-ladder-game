package domain;

import java.util.regex.Pattern;

public class Person {
    static final String NAME_LENGTH_EXCEPTION_MESSAGE = "사용자의 이름은 영문자로만 1글자 이상 5글자 이하여야 합니다.";

    private static final Pattern namePattern = Pattern.compile("^[a-zA-Z]{1,5}$");

    private final String name;

    public Person(String name){
        validate(name);
        this.name = name;
    }

    public Person(Person person){
        this.name = person.name;
    }

    private static void validate(String name){
        if(!namePattern.matcher(name).find()){
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
