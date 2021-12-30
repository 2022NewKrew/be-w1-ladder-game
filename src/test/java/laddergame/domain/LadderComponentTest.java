package laddergame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderComponentTest {

    @DisplayName("Ladder Component 생성 - 마지막 새로선인 경우")
    @Test
    void makeLadderComponentFailWhenIsEndVertical() {
        // Given
        LadderComponent ladderComponent = new LadderComponent(true, false);

        // When
        Boolean result = ladderComponent.hasRightHorizon();

        // Then
        Assertions.assertEquals(false, result);

    }

    @DisplayName("Ladder Component 생성 - 왼쪽 가로선이 있는 경우")
    @Test
    void makeLadderComponentFailWhenhasLeftHorizon() {
        // Given
        LadderComponent ladderComponent = new LadderComponent(false, true);

        // When
        Boolean result = ladderComponent.hasRightHorizon();

        // Then
        Assertions.assertEquals(false, result);
    }

    @DisplayName("Ladder Component 생성 - 마지막 세로선이면서 왼쪽 가로선이 있는 경우")
    @Test
    void makeLadderComponentFailWhenhasLeftHorizonAndIsEndVertical() {
        // Given
        LadderComponent ladderComponent = new LadderComponent(true, true);

        // When
        Boolean result = ladderComponent.hasRightHorizon();

        // Then
        Assertions.assertEquals(false, result);
    }
}