package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    @DisplayName("5자를 초과하는 이름은 5자로 표기")
    void nameLengthTest(){
        String[] names = {"longName", "testName", "assertName"};
        Person person = new Person(names);

        for(int i=0; i<names.length; i++){
            assertEquals(names[i].substring(0, 5), person.getPerson().get(i));
        }

    }
}