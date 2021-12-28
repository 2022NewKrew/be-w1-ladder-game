import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * String 유틸 클래스입니다.
 */
public class StringUtils {

    /**
     * String을 times만큼 반복해서 반환합니다.
     */
    public static String times(String value, int times) {
        return value.repeat(times);
    }

    /**
     * String을 regex를 이용해 쪼개서 List로 반환합니다.
     */
    public static List<String> split(String value, String regex) {
        return Arrays.stream(value.split(regex)).collect(Collectors.toList());
    }
}
