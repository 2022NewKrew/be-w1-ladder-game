import laddergame.util.Util;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    //formatStringSize가 정확히 5개 크기의 String을 반환하는지 테스트
    @Test
    void formatStringSize(){
        assertThat(Util.formatStringSize("kennypark", 5)).isEqualTo("kenny");
        assertThat(Util.formatStringSize("ab", 5)).isEqualTo("   ab");
        assertThat(Util.formatStringSize("", 5)).isEqualTo("     ");
    }
}
