package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("Padding test: length is 1")
    void padName_LengthIs1_ProperlyPadded() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method padName = OutputView.class.getDeclaredMethod("padName", String.class);
        padName.setAccessible(true);

        String targetString = "a";
        String expectedPaddedString = "  a  ";

        String actualPaddedString = (String) padName.invoke(outputView, targetString);

        assertThat(actualPaddedString).isEqualTo(expectedPaddedString);
    }

    @Test
    @DisplayName("Padding test: length is 2")
    void padName_LengthIs2_ProperlyPadded() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method padName = OutputView.class.getDeclaredMethod("padName", String.class);
        padName.setAccessible(true);

        String targetString = "bb";
        String expectedPaddedString = "  bb ";

        String actualPaddedString = (String) padName.invoke(outputView, targetString);

        assertThat(actualPaddedString).isEqualTo(expectedPaddedString);
    }

    @Test
    @DisplayName("Padding test: length is 3")
    void padName_LengthIs3_ProperlyPadded() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method padName = OutputView.class.getDeclaredMethod("padName", String.class);
        padName.setAccessible(true);

        String targetString = "ccc";
        String expectedPaddedString = " ccc ";

        String actualPaddedString = (String) padName.invoke(outputView, targetString);

        assertThat(actualPaddedString).isEqualTo(expectedPaddedString);
    }

    @Test
    @DisplayName("Padding test: length is 4")
    void padName_LengthIs4_ProperlyPadded() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method padName = OutputView.class.getDeclaredMethod("padName", String.class);
        padName.setAccessible(true);

        String targetString = "dddd";
        String expectedPaddedString = " dddd";

        String actualPaddedString = (String) padName.invoke(outputView, targetString);

        assertThat(actualPaddedString).isEqualTo(expectedPaddedString);
    }

    @Test
    @DisplayName("Padding test: length is 5")
    void padName_LengthIs5_ProperlyPadded() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method padName = OutputView.class.getDeclaredMethod("padName", String.class);
        padName.setAccessible(true);

        String targetString = "eeeee";
        String expectedPaddedString = "eeeee";

        String actualPaddedString = (String) padName.invoke(outputView, targetString);

        assertThat(actualPaddedString).isEqualTo(expectedPaddedString);
    }
}
