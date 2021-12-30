package domain;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class People {
    static final String NO_USER_EXCEPTION_MESSAGE = "사람 수는 1명 이상이어야 합니다.";

    private final List<Person> people;

    public People(List<String> peopleNames) {
        validate(peopleNames);
        this.people = createPeople(peopleNames);
    }

    private static void validate(List<String> peopleNames){
        if(peopleNames.isEmpty()){
            throw new IllegalArgumentException(NO_USER_EXCEPTION_MESSAGE);
        }
    }

    private static List<Person> createPeople(List<String> peopleNames){
        return peopleNames.stream()
                .map(Person::new)
                .collect(toList());
    }

    @Override
    public String toString(){
        return people.stream()
                .map(person -> String.format("%7s", person.toString()))
                .reduce("", String::concat);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public Person getPerson(int index){
        return new Person(this.people.get(index));
    }

    public int numberOfPeople(){
        return this.people.size();
    }

    public boolean exist(final String name){
        return people.stream().anyMatch(person -> name.equals(person.getName()));
    }
}