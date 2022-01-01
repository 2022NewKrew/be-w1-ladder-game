package ladder.domain;

import ladder.view.PointGenerator;
import ladder.view.StringLineGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {
    // 상수
    private static final int CHAR_LIMIT = 5;
    private final String ALL = "all";
    private final String LADDER_RESULT = "실행 결과";
    private final String NOT_IN_ENTRY = "참가자 목록에 없는 이름입니다.";

    // 인스턴스 변수
    private final List<Line> ladder;
    private final LabelList participantList;
    private final Map<String, Integer> participantsOrder;
    private final LabelList result;
    private final int peopleCount;
    private final StringLineGenerator stringLineGenerator;

    // 생성자
    public Ladder(String stringEntry, String stringResult, int height) {
        participantList = new LabelList(stringEntry, CHAR_LIMIT);
        participantsOrder = createParticipantMap();
        result = new LabelList(stringResult, CHAR_LIMIT);
        peopleCount = this.participantList.getEntryCount();
        ladder = new ArrayList<>();
        stringLineGenerator = new StringLineGenerator(CHAR_LIMIT);

        for (int i=0; i < height; i++) {
            ladder.add(new Line(peopleCount, new PointGenerator()));
        }
    }

    // 메서드
    private Map<String, Integer> createParticipantMap() {
        Map<String, Integer> result = new HashMap<>();
        List<String> participantStringList = participantList.getLabelList();
        for (int i = 0; i < participantStringList.size(); i++) {
            result.put(participantStringList.get(i), i);
        }
        return result;
    }
    public boolean hasPerson(String person) {
        return participantsOrder.containsKey(person);
    }

    public String followLadder(String person) {
        Integer x = participantsOrder.get(person);
        for (Line line : ladder) {
            x = line.moveLine(x);
        }
        return result.getLabelList().get(x);
    }

    public String playLadder(String person) {
        if (hasPerson(person)) {
            return "\n" + LADDER_RESULT
                    + "\n" + followLadder(person);
        }

        if (person.equals(ALL)) {
            return "\n" + followAllLadder();
        }

        return NOT_IN_ENTRY;
    }

    private String followAllLadder() {
        StringBuilder allGameResult = new StringBuilder();
        for (String participant : participantList.getLabelList()) {
            allGameResult.append(participant).append(" : ").append(followLadder(participant)).append("\n");
        }
        return allGameResult.toString();
    }

    public String toString() {
        return participantList.toString() + "\n" +
                ladder.stream()
                .map(s -> stringLineGenerator.createRowString(s.getPoints()))
                .collect(Collectors.joining("\n"))
                + "\n" + result.toString(peopleCount);
    }
}
