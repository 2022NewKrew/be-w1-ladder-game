package view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class NameAndResultInputInterfaceTest {
    @Test
    @DisplayName("이름의 글자수가 5개를 초과했을 때 오류를 출력하는지에 대한 테스트")
    void inputArguments_1() {
        // given
        final String inputString = "mino,andy,jeff,raon,austin";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputInterface inputInterface = new NameAndResultInputInterface();

        // when
        inputInterface.inputArguments();
    }

    @Test
    @DisplayName("사람의 수와 실행결과의 수가 다를 때 오류를 출력하는지에 대한 테스트")
    void inputArguments_2() {
        // given
        final String inputString = "mino,andy,jeff,raon,keith\n꽝,10000,꽝,3000";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputInterface inputInterface = new NameAndResultInputInterface();

        // when
        inputInterface.inputArguments();
    }

    @Test
    @DisplayName("사다리 높이에 0보다 작은 값을 입력했을 때 오류를 출력하는지에 대한 테스트")
    void inputArguments_3() {
        // given
        final String inputString = "mino,andy,jeff,raon,keith\n꽝,10000,꽝,3000,5000\n-1";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputInterface inputInterface = new NameAndResultInputInterface();

        // when
        inputInterface.inputArguments();
    }
}