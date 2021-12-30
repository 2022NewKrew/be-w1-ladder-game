package validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void checkPositiveIntegerSuccessTest() {
        for (int i = 1; i < 100; i++) {
            Validator.checkPositiveInteger(i);
        }
    }

    @Test
    void checkPositiveIntegerFailTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.checkPositiveInteger(-1)
        );
    }

    @Test
    void checkNameLengthSuccessTest() {
        Validator.checkNameLength(List.of("jeff", "binar", "keith"));
    }

    @Test
    void checkNameLengthFailTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.checkNameLength(List.of("binary"))
        );
    }
}