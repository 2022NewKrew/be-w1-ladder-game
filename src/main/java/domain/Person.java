package domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<String> person;

    public Person(String[] nameList){
        person = new ArrayList<>();

        for (String name : nameList) {
            person.add(convertName(name));
        }
    }

    public List<String> getPerson() {
        return person;
    }

    private String convertName(String name){
        if(name.length() > LadderConst.OUTPUT_NAME_SIZE){
            return name.substring(0, LadderConst.OUTPUT_NAME_SIZE);
        }

        return name;
    }
}
