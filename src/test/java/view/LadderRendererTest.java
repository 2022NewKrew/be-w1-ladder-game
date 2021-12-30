package view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderRendererTest {
    @Test
    public void 입력된_이름이_최대글자수_이상인_경우(){
        // Given
        int MAX_NAME_LENGTH = 5;
        LadderGameStarter starter = new LadderGameStarter(MAX_NAME_LENGTH);
        String[] people = "a,bb,cccccc".split(",");

        // When
        boolean isValid = starter.isValid(people);

        // Then
        assertFalse(isValid);
    }

    @Test
    public void 입력된_이름이_빈칸인_경우(){
        // Given
        int MAX_NAME_LENGTH = 5;
        LadderGameStarter starter = new LadderGameStarter(MAX_NAME_LENGTH);
        String[] people = "a,,ccc".split(",");

        // When
        boolean isValid = starter.isValid(people);

        // Then
        assertFalse(isValid);
    }
}
