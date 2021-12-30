package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LadderFactoryTest {

    @Test
    @DisplayName("Ladder width check")
    void buildLadder_ValidWidth_HasOneLessHorizontalLines() {
        // Arrange
        List<String> participants = new ArrayList<>();
        participants.add("testUser1");
        participants.add("testUser2");
        participants.add("testUser3");
        participants.add("testUser4");
        participants.add("testUser5");

        List<String> results = new ArrayList<>();
        participants.add("testResult1");
        participants.add("testResult2");
        participants.add("testResult3");
        participants.add("testResult4");
        participants.add("testResult5");

        int height = 10;

        Ladder ladder = LadderFactory.buildLadder(participants, results, height);

        // Act
        int actualWidth = ladder.getLayers().get(0).getHorizontalLines().size();

        // Assert
        assertThat(actualWidth).isEqualTo(participants.size() - 1);
    }

    @Test
    @DisplayName("Ladder height check")
    void buildLadder_ValidHeight_HasSameLayers() {
        // Arrange
        List<String> participants = new ArrayList<>();
        participants.add("testUser1");
        participants.add("testUser2");
        participants.add("testUser3");
        participants.add("testUser4");
        participants.add("testUser5");

        List<String> results = new ArrayList<>();
        participants.add("testResult1");
        participants.add("testResult2");
        participants.add("testResult3");
        participants.add("testResult4");
        participants.add("testResult5");

        int height = 10;

        Ladder ladder = LadderFactory.buildLadder(participants, results, height);

        // Act
        int actualWidth = ladder.getLayers().size();

        // Assert
        assertThat(actualWidth).isEqualTo(height);
    }

    @Test
    @DisplayName("Divergence resolving check: TT")
    void resolveDivergence_TrueAndTrue_ReturnsFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        Method resolveDivergence = LadderFactory.class.getDeclaredMethod("resolveDivergence", boolean.class, boolean.class);
        resolveDivergence.setAccessible(true);

        boolean previous = true;
        boolean current = true;

        // Act
        boolean resolvedBoolean = (Boolean) resolveDivergence.invoke(null, previous, current);

        // Assert
        assertThat(resolvedBoolean).isFalse();
    }

    @Test
    @DisplayName("Divergence resolving check: TF")
    void resolveDivergence_TrueAndFalse_ReturnsFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        Method resolveDivergence = LadderFactory.class.getDeclaredMethod("resolveDivergence", boolean.class, boolean.class);
        resolveDivergence.setAccessible(true);

        boolean previous = true;
        boolean current = false;

        // Act
        boolean resolvedBoolean = (Boolean) resolveDivergence.invoke(null, previous, current);

        // Assert
        assertThat(resolvedBoolean).isFalse();
    }

    @Test
    @DisplayName("Divergence resolving check: FT")
    void resolveDivergence_FalseAndTrue_ReturnsTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        Method resolveDivergence = LadderFactory.class.getDeclaredMethod("resolveDivergence", boolean.class, boolean.class);
        resolveDivergence.setAccessible(true);

        boolean previous = false;
        boolean current = true;

        // Act
        boolean resolvedBoolean = (Boolean) resolveDivergence.invoke(null, previous, current);

        // Assert
        assertThat(resolvedBoolean).isTrue();
    }

    @Test
    @DisplayName("Divergence resolving check: FF")
    void resolveDivergence_FalseAndFalse_ReturnsFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        Method resolveDivergence = LadderFactory.class.getDeclaredMethod("resolveDivergence", boolean.class, boolean.class);
        resolveDivergence.setAccessible(true);

        boolean previous = false;
        boolean current = false;

        // Act
        boolean resolvedBoolean = (Boolean) resolveDivergence.invoke(null, previous, current);

        // Assert
        assertThat(resolvedBoolean).isFalse();
    }
}
