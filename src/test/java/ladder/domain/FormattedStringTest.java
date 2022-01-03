package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("FormattedString Test")
class FormattedStringTest {

    FormattedString formattedStr;

    @DisplayName("입력문자열에 포함된 공백은 제거하여 저장한다.")
    @Test
    void 입력문자열_공백_제거_테스트() {
        String name = "Ab         by";
        formattedStr = new FormattedString(name);

        assertThat(formattedStr.getStr()).isEqualTo("Abby");
    }

    @DisplayName("입력문자열이 5글자 이상일 시 앞에서부터 5글자만 저장한다.")
    @Test
    void 입력문자열_길이_제한_테스트() {
        String name ="thisIsLongEngName";
        formattedStr = new FormattedString(name);

        assertThat(formattedStr.getStr()).isEqualTo(name.substring(0, 5));
    }

    @DisplayName("입력문자열이 5글자 미만이고 공백이 포함되지 않았을 시, 그대로 저장한다.")
    @Test
    void 입력문자열_저장_테스트() {
        String name ="cuz";
        formattedStr = new FormattedString(name);

        assertThat(formattedStr.getStr()).isEqualTo(name);
    }
}