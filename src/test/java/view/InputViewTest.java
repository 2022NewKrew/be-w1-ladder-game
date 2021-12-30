package view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("Integer validation test: negative int")
    void validatePositiveInteger_TargetIsNegativeInteger_ThrowsException() throws NoSuchMethodException {
        // Arrange
        Method validatePositiveInteger = InputView.class.getDeclaredMethod("validatePositiveInteger", int.class);
        validatePositiveInteger.setAccessible(true);

        int target = -1;

        // Act & Assert
        Assertions.assertThrows(InvocationTargetException.class, () -> validatePositiveInteger.invoke(inputView, target));
    }

    @Test
    @DisplayName("Integer validation test: zero")
    void validatePositiveInteger_TargetIsZero_ThrowsException() throws NoSuchMethodException {
        // Arrange
        Method validatePositiveInteger = InputView.class.getDeclaredMethod("validatePositiveInteger", int.class);
        validatePositiveInteger.setAccessible(true);

        int target = 0;

        // Act & Assert
        Assertions.assertThrows(InvocationTargetException.class, () -> validatePositiveInteger.invoke(inputView, target));
    }

    @Test
    @DisplayName("Integer validation test: positive int")
    void validatePositiveInteger_TargetIsPositiveInteger_DoesNotThrowException() throws NoSuchMethodException {
        // Arrange
        Method validatePositiveInteger = InputView.class.getDeclaredMethod("validatePositiveInteger", int.class);
        validatePositiveInteger.setAccessible(true);

        int target = 1;

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> validatePositiveInteger.invoke(inputView, target));
    }

    @Test
    @DisplayName("Name validation test: empty")
    void validateName_TargetIsEmpty_ThrowsException() throws NoSuchMethodException {
        // Arrange
        Method validateName = InputView.class.getDeclaredMethod("validateName", String.class);
        validateName.setAccessible(true);

        String target = "";

        // Act & Assert
        Assertions.assertThrows(InvocationTargetException.class, () -> validateName.invoke(inputView, target));
    }

    @Test
    @DisplayName("Name validation test: too long")
    void validateName_TargetIsTooLong_ThrowsException() throws NoSuchMethodException {
        // Arrange
        Method validateName = InputView.class.getDeclaredMethod("validateName", String.class);
        validateName.setAccessible(true);

        String target = "ffffff";

        // Act & Assert
        Assertions.assertThrows(InvocationTargetException.class, () -> validateName.invoke(inputView, target));
    }

    @Test
    @DisplayName("Name validation test: valid")
    void validateName_TargetIsValid_DoesNotThrowException() throws NoSuchMethodException {
        // Arrange
        Method validateName = InputView.class.getDeclaredMethod("validateName", String.class);
        validateName.setAccessible(true);

        String target = "abcde";

        // Act & Assert
        Assertions.assertDoesNotThrow(() -> validateName.invoke(inputView, target));
    }
}
