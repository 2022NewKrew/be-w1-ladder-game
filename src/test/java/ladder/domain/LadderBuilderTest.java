package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderBuilderTest {
    @ParameterizedTest(name = "Should not create line builder with invalid parameter ({0}, {1})")
    @CsvSource({"10,0", "0,10"})
    void lineBuildersWithInvalidParameter(int numberOfPlayer, int height) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new LadderBuilder(numberOfPlayer, height));
    }
}
