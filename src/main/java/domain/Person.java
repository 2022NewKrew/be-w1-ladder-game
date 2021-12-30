package domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<String> person;

    public Person(String[] nameList){
        person = new ArrayList<>();

        for (String name : nameList) {
            person.add(nameLengthCheck(name));
        }
    }

    public List<String> getPerson() {
        return person;
    }

    private String nameLengthCheck(String name){
        if(name.length() > 5){
            return name.substring(0, 5);
        }

        return name;
    }
}
