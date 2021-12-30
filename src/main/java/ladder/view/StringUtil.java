package ladder.view;

public class StringUtil {
    //
    // 입력 문자를 size에 맞게 가운데 정렬합니다. 예시는 아래와 같습니다. (_:공백)
    // 1글자,size=5 -> __a__
    // 2글자,size=5 -> _aa__
    // 3글자,size=5 -> _aaa_
    // 4글자,size=5 -> aaaa_
    public static String centerAligned(String str, int size) {
        if (str.isEmpty() || str.isBlank())
            return null;
        if (str.length() > 5)
            str = str.substring(0, 5);

        int leftPad = (int) ((size - str.length()) / 2);
        if (leftPad == 0)
            return String.format("%" + (-size) + "s", str);

        return String.format(
                "%" + (-size) + "s",
                String.format("%" + (leftPad + str.length()) + "s", str)
        );
    }
}
