package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LabelList {
    // 상수
    private static final String DELIMITER = ",";

    // 인스턴스 변수
    private final List<String> labelList;
    private final int charLimit;

    // 생성자
    public LabelList(String labelList, int charLimit) {
        StringTokenizer stringTokenizer = new StringTokenizer(labelList, DELIMITER);
        this.charLimit = charLimit;
        this.labelList = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            this.labelList.add(stringTokenizer.nextToken());
        }
    }

    // 메소드
    public int getEntryCount() {
        return labelList.size();
    }

    public List<String> getLabelList() {
        return labelList;
    }

    public String centerString(String s, int size) {
        if (s.length() == size) {
            return s;
        }

        if (s.length() > size) {
            System.err.println("이름 " + s + "의 길이가 " + size + "글자를 초과하므로 " + size + "자만 표시됩니다.");
            return s.substring(0, size);
        }

        int padLeft = (size - s.length()) / 2;
        int padRight = (size - s.length() + 1) / 2;
        return " ".repeat(padLeft) + s + " ".repeat(padRight);
    }

    @Override
    public String toString() {
        return labelList.stream()
                .map(s -> centerString(s, charLimit))
                .collect(Collectors.joining(" "));
    }

    public String toString(int maxSize) {
        return labelList.stream()
                .limit(maxSize)
                .map(s -> centerString(s, charLimit))
                .collect(Collectors.joining(" "));
    }
}
