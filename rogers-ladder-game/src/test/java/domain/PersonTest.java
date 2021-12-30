package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    public void testFailedNameLengthLessOrOver(){
        //given
        String name1 = "";
        String name2 = "pobyyy";

        //when
        IllegalArgumentException illegalArgumentException1
                = assertThrows(IllegalArgumentException.class, ()->Person.valueOf(name1));
        IllegalArgumentException illegalArgumentException2
                = assertThrows(IllegalArgumentException.class, ()->Person.valueOf(name2));

        //then
        assertEquals(Person.NAME_LENGTH_EXCEPTION_MESSAGE, illegalArgumentException1.getMessage());
        assertEquals(Person.NAME_LENGTH_EXCEPTION_MESSAGE, illegalArgumentException2.getMessage());
    }

    @Test
    public void testFailedWhenNameContainsNotAlphabet(){
        //given
        String name1 = "pobi1";
        String name2 = "po$bi";

        //when
        IllegalArgumentException illegalArgumentException1
                = assertThrows(IllegalArgumentException.class, ()->Person.valueOf(name1));
        IllegalArgumentException illegalArgumentException2
                = assertThrows(IllegalArgumentException.class, ()->Person.valueOf(name2));

        //then
        assertEquals(Person.NAME_LENGTH_EXCEPTION_MESSAGE, illegalArgumentException1.getMessage());
        assertEquals(Person.NAME_LENGTH_EXCEPTION_MESSAGE, illegalArgumentException1.getMessage());
    }

    @Test
    public void testSuccessWhenNamingSatisfied(){
        //given
        String name1 = "o";
        String name2 = "pobii";

        Person person1 = Person.valueOf(name1);
        Person person2 = Person.valueOf(name2);

        assertEquals(name1, person1.getName());
        assertEquals(name2, person2.getName());
    }
}