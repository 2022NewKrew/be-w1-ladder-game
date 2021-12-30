package ladder.view;

import ladder.domain.Ladder;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewLadderTest {
    ArrayList<Integer> testInteger = new ArrayList<>(List.of(3, 11));
    Ladder ladder = new Ladder(testInteger);
    ArrayList<String> testResults = new ArrayList<>(List.of("wrong", "answer", "123"));
    ArrayList<String> testNames = new ArrayList<>(List.of("a", "bcdefg", "qwert"));
    ViewLadder vLadder1 = new ViewLadder(ladder, 5, testNames, testResults);

    @Test
    void casesToStringTest() throws Exception{
        Method method = vLadder1.getClass().getDeclaredMethod("casesToString", List.class);
        method.setAccessible(true);

        String testResult = (String) method.invoke(vLadder1, testNames);
        String realResult = "  a   bcdef qwert \n";
        assertEquals(realResult, testResult);
    }
}