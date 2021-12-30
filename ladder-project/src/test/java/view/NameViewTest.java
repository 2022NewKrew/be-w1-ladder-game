package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameViewTest {

    @Test
    @DisplayName("사람 이름을 제대로 출력하는지 확인하는 테스트")
    void printNameViewTest() {
        List<String> names = new ArrayList<>();
        names.add("ai");
        names.add("bi");
        names.add("ci");

        NameView nameView = NameView.create(names);

        String expected = "ai    bi    ci   ";
        String result = nameView.getNameView();

        assertEquals(expected, result);
    }
}
