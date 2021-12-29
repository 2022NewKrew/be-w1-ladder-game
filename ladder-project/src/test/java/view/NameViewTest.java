package view;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameViewTest {

    @Test
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
