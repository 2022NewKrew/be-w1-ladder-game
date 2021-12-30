package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("Line 생성 테스트")
    @Test
    void from() {
        int numberOfPlayer = 5;
        Line line = Line.from(numberOfPlayer);
        List<Boolean> connectionList = line.getConnectionList();
        assertThat(connectionList).hasSize(numberOfPlayer - 1);
    }

    @DisplayName("중복 연결 제거 테스트")
    @Test
    void removeDuplicatedConnection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Line.class.getDeclaredMethod("removeDuplicatedConnection", List.class);
        method.setAccessible(true);

        List<Boolean> connectionList = new ArrayList<>();
        connectionList.add(true);
        connectionList.add(true);

        method.invoke(null, connectionList);

        assertThat(connectionList.get(1)).isEqualTo(false);
    }
}