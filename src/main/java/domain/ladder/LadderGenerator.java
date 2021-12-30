package domain.ladder;

import view.input.config.LadderConfig;
import type.StuffType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderGenerator {

    protected static Random rd = new Random();

    // 랜덤 Boolean 반환
    protected static boolean randomBoolean(Random rd){
        return rd.nextBoolean();
    }

    // ladderShape 를 만들어 Ladder 객체 완성
    public Ladder createLadder(LadderConfig ladderConfig){
        final int peopleCount = ladderConfig.getPeopleCount();
        final int height = ladderConfig.getHeight();

        // 한 줄(List<String>) 을 createRow 함수로 생성하여 add
        List<Line> ladderShape = new ArrayList<>();
        IntStream.range(0, height).forEach(j -> ladderShape.add(new Line(createRow(peopleCount))));

        Ladder ladder = new Ladder.Builder()
                .peopleCount(peopleCount)
                .height(height)
                .ladderShape(ladderShape)
                .build();

        return ladder;
    }

    // 사다리 한 줄을 생성
    protected static List<Integer> createRow(int peopleCount) {
        List<Integer> line = new ArrayList<>();

        // 각 칸의 Stuff(기둥, 다리, 공간) 을 decideStuff 가 결정하여 반환해줌
        final int rowListSize = (peopleCount - 1) * 2 + 1;
        IntStream.range(0, rowListSize)
                .forEach(i -> line.add(decideStuff(i, line)));
        return line;
    }

    // 사다리 한 줄 에서 해당 칸에 들어갈 Stuff 를 결정
    //    COLUMN(0)
    //    BRIDGE(1)
    //    SPACE(2)
    protected static Integer decideStuff(int i, List<Integer> row) {
        // 짝수 칸은 기둥으로 고정
        final boolean isColumnLine = i % 2 == 0;
        if (isColumnLine) return StuffType.COLUMN.getNum();
        if (randomBoolean(rd)) {
            // 이전에 다리가 있었는지 중복 체크
            return bridgeDuplicationCheck(row);
        }
        return StuffType.SPACE.getNum();
    }

    // 다리가 놓여질 경우 이전 Stuff 가 다리였는지
    protected static Integer bridgeDuplicationCheck(List<Integer> row) {
        // 맨 앞은 검사 생략
        final boolean isFirstBridge = row.size() < 3;
        if (isFirstBridge) return StuffType.BRIDGE.getNum();

        Integer previousStuff = row.get(row.size() - 2);
        if (previousStuff == StuffType.BRIDGE.getNum()) return StuffType.SPACE.getNum();
        return StuffType.BRIDGE.getNum();
    }
}
