package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StringParsingUtil {

    private StringParsingUtil() {
    }

    public static List<String> parse(String stringList, String split) {
        String[] list = stringList.split(split);
        return Arrays.stream(list)
                .collect(Collectors.toList());
    }
}
