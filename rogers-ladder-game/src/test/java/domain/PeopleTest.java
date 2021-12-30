package domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {

    @Test
    public void testFailedWhenNoUser(){
        //given
        List<String> peopleNames = Collections.emptyList();

        //when
        IllegalArgumentException illegalArgumentException
                = assertThrows(IllegalArgumentException.class, ()->People.valueOf(peopleNames));

        //then
        assertEquals(People.NO_USER_EXCEPTION_MESSAGE, illegalArgumentException.getMessage());
    }

    @Test
    public void testSuccessWhenOneOrMore(){
        //given
        List<String> peopleNames1 = List.of("pobi");
        List<String> peopleNames2 = List.of("pobi", "honux", "crong", "jk");

        //when
        People people1 = People.valueOf(peopleNames1);
        People people2 = People.valueOf(peopleNames2);


        //then
        assertEquals(peopleNames1.size(), people1.numberOfPeople());
        assertEquals(peopleNames2.size(), people2.numberOfPeople());

        String expectedName = peopleNames2.get(peopleNames2.size()-1);
        assertTrue(people2.exist(expectedName));
    }
}