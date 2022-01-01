package view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LadderRendererTest {
    private final int MAX_NAME_LENGTH = 5;

    @Test
    public void 최대글자수_이하로_출력되는지(){
        String[] people = {"a", "bb","ccc","dddd","eeeee"};
        LadderRenderer renderer = new LadderRenderer(MAX_NAME_LENGTH);

        StringBuilder print = renderer.renderName(people);
        boolean isTooLong = Arrays.stream(print.toString()
                .split(" "))
                .anyMatch(name-> name.length() > MAX_NAME_LENGTH);

        assertFalse(isTooLong);
    }
}
