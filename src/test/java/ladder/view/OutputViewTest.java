package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class OutputViewTest {

    @ParameterizedTest
    @MethodSource("test")
    @DisplayName("5글자를 맞추기 위한 버퍼 테스트")
    void getBuffer(Item item)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Class<OutputView> outputViewClass = OutputView.class;
        Method method = outputViewClass.getDeclaredMethod("getBuffer", String.class);
        method.setAccessible(true);

        // when
        String value = (String) method.invoke(null, item.getName());

        // then
        assertThat(value).isEqualTo(item.getExpected());
    }

    private static Stream<Item> test() {
        return Stream.of(
            new Item("1", "    "),
            new Item("11", "   "),
            new Item("111", "  "),
            new Item("1111", " "),
            new Item("11111", "")
        );
    }

    private static class Item {
        private final String name;
        private final String expected;

        public Item(String name, String expected) {
            this.name = name;
            this.expected = expected;
        }

        public String getName() {
            return name;
        }

        public String getExpected() {
            return expected;
        }

        @Override
        public String toString() {
            return "Item{" +
                "name='" + name + '\'' +
                ", expected='" + expected + '\'' +
                '}';
        }
    }
}
