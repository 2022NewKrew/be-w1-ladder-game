package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LadderFactoryTest {

    @Test
    @DisplayName("Ladder width check")
    void buildLadder_ValidWidth_HasOneLessHorizontalLines() {
        int width = 10;
        int height = 10;

        Ladder ladder = LadderFactory.buildLadder(width, height);

        int actualWidth = ladder.getLayers().get(0).getHorizontalLines().size();

        assertThat(actualWidth).isEqualTo(width - 1);
    }

    @Test
    @DisplayName("Ladder height check")
    void buildLadder_ValidHeight_HasSameLayers() {
        int width = 10;
        int height = 10;

        Ladder ladder = LadderFactory.buildLadder(width, height);

        int actualWidth = ladder.getLayers().size();

        assertThat(actualWidth).isEqualTo(height);
    }

    @Test
    @DisplayName("Divergence resolving check: TT")
    void resolveDivergence_TrueAndTrue_ReturnsFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method resolveDivergence = LadderFactory.class.getDeclaredMethod("resolveDivergence", boolean.class, boolean.class);
        resolveDivergence.setAccessible(true);

        boolean previous = true;
        boolean current = true;

        boolean resolvedBoolean = (Boolean) resolveDivergence.invoke(null, previous, current);

        assertThat(resolvedBoolean).isFalse();
    }

    @Test
    @DisplayName("Divergence resolving check: TF")
    void resolveDivergence_TrueAndFalse_ReturnsFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method resolveDivergence = LadderFactory.class.getDeclaredMethod("resolveDivergence", boolean.class, boolean.class);
        resolveDivergence.setAccessible(true);

        boolean previous = true;
        boolean current = false;

        boolean resolvedBoolean = (Boolean) resolveDivergence.invoke(null, previous, current);

        assertThat(resolvedBoolean).isFalse();
    }

    @Test
    @DisplayName("Divergence resolving check: FT")
    void resolveDivergence_FalseAndTrue_ReturnsTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method resolveDivergence = LadderFactory.class.getDeclaredMethod("resolveDivergence", boolean.class, boolean.class);
        resolveDivergence.setAccessible(true);

        boolean previous = false;
        boolean current = true;

        boolean resolvedBoolean = (Boolean) resolveDivergence.invoke(null, previous, current);

        assertThat(resolvedBoolean).isTrue();
    }

    @Test
    @DisplayName("Divergence resolving check: FF")
    void resolveDivergence_FalseAndFalse_ReturnsFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method resolveDivergence = LadderFactory.class.getDeclaredMethod("resolveDivergence", boolean.class, boolean.class);
        resolveDivergence.setAccessible(true);

        boolean previous = false;
        boolean current = false;

        boolean resolvedBoolean = (Boolean) resolveDivergence.invoke(null, previous, current);

        assertThat(resolvedBoolean).isFalse();
    }
}
