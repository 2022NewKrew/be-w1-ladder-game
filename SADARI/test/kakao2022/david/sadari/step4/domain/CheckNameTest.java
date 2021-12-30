package kakao2022.david.sadari.step4.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckNameTest {

    @Test
    void checkNameLength() {
        NameLengthException exception = assertThrows(NameLengthException.class, () -> CheckName.checkNameLength("aaaaaa"));
        String errorMessage = exception.getMessage();
        assertEquals(errorMessage, CheckName.NAME_ERROR_MESSAGE);
    }
}