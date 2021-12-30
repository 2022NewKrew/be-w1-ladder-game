import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Entry {
    // 상수
    private static final String DELIMITER = ",";
    private static final Integer PARTICIPANT_SIZE = 5;

    // 인스턴스 변수
    private final List<String> participant;

    // 생성자
    public Entry (String participant) {
        StringTokenizer stringTokenizer = new StringTokenizer(participant, DELIMITER);
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
        int padLeft = (size - s.length()) / 2;
        int padRight = (size - s.length() + 1) / 2;
        return " ".repeat(padLeft) + s + " ".repeat(padRight);
    }

    @Override
    public String toString() {
        return participant.stream()
                .map(s -> centerString(s, PARTICIPANT_SIZE))
                .collect(Collectors.joining(" "));
    }
}
