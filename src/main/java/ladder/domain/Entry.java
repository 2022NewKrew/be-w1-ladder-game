package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Entry {
    // 상수
    private static final String DELIMITER = ",";

    // 인스턴스 변수
    private final List<String> participant;
    private final int participantLimit;

    // 생성자
    public Entry (String participant, int participantLimit) {
        StringTokenizer stringTokenizer = new StringTokenizer(participant, DELIMITER);
        this.participantLimit = participantLimit;
        this.participant = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            this.participant.add(stringTokenizer.nextToken());
        }
    }

    // 메소드
    public int getEntryCount() {
        return participant.size();
    }

    public String centerString(String s, int size) {
        if (s.length() == size) {
            return s;
        }

        if (s.length() > size) {
            System.out.println("이름 " + s + "의 길이가 5글자를 초과하므로 5자만 표시됩니다.");
            return s.substring(0, size);
        }

        int padLeft = (size - s.length()) / 2;
        int padRight = (size - s.length() + 1) / 2;
        return " ".repeat(padLeft) + s + " ".repeat(padRight);
    }

    @Override
    public String toString() {
        return participant.stream()
                .map(s -> centerString(s, participantLimit))
                .collect(Collectors.joining(" "));
    }
}
