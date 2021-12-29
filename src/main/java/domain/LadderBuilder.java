package domain;

import type.StuffType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderBuilder {

    private static Random rd = new Random();

    // 랜덤 Boolean 반환
    private static boolean randomBoolean(Random rd){
        return rd.nextBoolean();
    }

    // ladderShape 를 만들어 Ladder 객체 완성
    public static Ladder createLadder(int width, int height){
        Ladder ladder = new Ladder(width, height);
        List<List<String>> ladderShape = new ArrayList<>();

        // 한 줄(List<String>) 을 createRow 함수로 생성하여 add
        IntStream.range(0, height).forEach(j -> ladderShape.add(createRow(width)));
        ladder.setLadderShape(ladderShape);
        return ladder;
    }

    // 사다리 한 줄을 생성
    private static List<String> createRow(int width) {
        List<String> row = new ArrayList<>();

        // 각 칸의 Stuff(기둥, 다리, 공간) 을 decideStuff 가 결정하여 반환해줌
        final int rowListSize = (width - 1) * 2 + 1;
        IntStream.range(0, rowListSize)
                .forEach(i -> row.add(decideStuff(i, row)));
        return row;
    }

    // 사다리 한 줄 에서 해당 칸에 들어갈 Stuff 를 결정
    private static String decideStuff(int i, List<String> row) {
        // 짝수 칸은 기둥으로 고정
        final boolean isColumnLine = i % 2 == 0;
        if (isColumnLine) return StuffType.COLUMN.getStuff();
        if (randomBoolean(rd)) {
            // 이전에 다리가 있었는지 중복 체크
            return bridgeDuplicationCheck(row);
        }
        return StuffType.SPACE.getStuff();
    }

    // 다리가 놓여질 경우 이전 Stuff 가 다리였는지
    private static String bridgeDuplicationCheck(List<String> row) {
        // 맨 앞은 검사 생략
        final boolean isFirstBridge = row.size() < 3;
        if (isFirstBridge) return StuffType.BRIDGE.getStuff();

        String previousStuff = row.get(row.size() - 2);
        if (previousStuff == StuffType.BRIDGE.getStuff()) return StuffType.SPACE.getStuff();
        return StuffType.BRIDGE.getStuff();
    }
}
