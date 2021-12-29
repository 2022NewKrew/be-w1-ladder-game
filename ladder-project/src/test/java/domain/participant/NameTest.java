package domain.participant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void nameLengthCheckTest() {
        String testCase = "baeked";
        assertThrows(IllegalArgumentException.class, () -> new Name(testCase));
    }
}