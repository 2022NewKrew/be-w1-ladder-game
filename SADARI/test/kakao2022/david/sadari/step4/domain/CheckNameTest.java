package kakao2022.david.sadari.step4.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckNameTest {

    @Test
    void checkNameLength() {
        NameLengthException exception = assertThrows(NameLengthException.class, () -> CheckName.checkNameLength("aaaaaa"));
        String errorMessage = exception.getMessage();
        assertEquals(errorMessage, "이름은 최대 5글자 까지 부여할 수 있습니다.");
    }
}