package domain;

import java.util.Locale;

public class Person {
    private final String name;

    public static Person createPerson(String name){
        return new Person(name);
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
