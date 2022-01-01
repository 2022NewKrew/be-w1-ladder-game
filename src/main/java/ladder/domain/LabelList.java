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
            String label = stringTokenizer.nextToken();
            this.labelList.add(checkLabelSize(label));
        }
    }

    // 메소드
    private String checkLabelSize(String label) {
        if (label.length() > charLimit) {
            System.out.println("이름 " + label + "의 길이가 " + charLimit + "글자를 초과하므로 " + charLimit + "자만 표시됩니다.");
            return label.substring(0, charLimit);
        }

        return label;
    }
    public int getEntryCount() {
        return labelList.size();
    }

    public List<String> getLabelList() {
        return labelList;
    }

    private String centerString(String s) {
        if (s.length() == charLimit) {
            return s;
        }

        int padLeft = (charLimit - s.length()) / 2;
        int padRight = (charLimit - s.length() + 1) / 2;
        return " ".repeat(padLeft) + s + " ".repeat(padRight);
    }

    @Override
    public String toString() {
        return labelList.stream()
                .map(this::centerString)
                .collect(Collectors.joining(" "));
    }

    public String toString(int maxSize) {
        return labelList.stream()
                .limit(maxSize)
                .map(this::centerString)
                .collect(Collectors.joining(" "));
    }
}
