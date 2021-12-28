import input.ConfigReader;
import input.ConfigReaderHeightAndWidthImpl;
import input.LadderConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LadderGame {

    private static Random rd = new Random();
    private static ConfigReader configReader = new ConfigReaderHeightAndWidthImpl();

    public static void main(String[] args) {

        // 입력 받기
        LadderConfig ladderConfig = configReader.readLadderConfig();

        // 사다리 만들기
        Ladder ladder = createLadder(ladderConfig.getWidth(), ladderConfig.getHeight());

        // 출력
        String ladderString = ladderToString(ladder.getLadderShape());
        System.out.println(ladderString);
    }

    // 랜덤 Boolean 반환
    private static boolean randomBoolean(Random rd){
        return rd.nextBoolean();
    }

    // ladderShape 를 만들어 Ladder 객체 완성
    private static Ladder createLadder(int width, int height){
        Ladder ladder = new Ladder(width, height);
        List<List<String>> ladderShape = new ArrayList<>();
        IntStream.range(0, height).forEach(j -> ladderShape.add(createRow(width)));
        ladder.setLadderShape(ladderShape);
        return ladder;
    }

    // 사다리 한 줄을 생성
    private static List<String> createRow(int width) {
        List<String> row = new ArrayList<>();
        IntStream.range(0, (width-1)*2 + 1)
                .forEach(i -> row.add(decideStuff(i, row)));
        return row;
    }

    // 사다리 한 줄 에서 해당 칸에 들어갈 Stuff 를 결정
    private static String decideStuff(int i, List<String> row) {
        // 짝수 칸은 기둥으로 고정
        final boolean isUserLine = i % 2 == 0;
        if (isUserLine) return StuffType.COLUMN.getStuff();
        if (randomBoolean(rd)) {
            return bridgeDuplicationCheck(row);
        }
        return StuffType.SPACE.getStuff();
    }

    // 다리가 놓여질 경우 이전 Stuff 가 다리였는지
    private static String bridgeDuplicationCheck(List<String> row) {
        // 맨 앞은 검사 생략
        if (row.size() < 3) return StuffType.BRIDGE.getStuff();

        if (row.get(row.size() - 2) == StuffType.BRIDGE.getStuff()) return StuffType.SPACE.getStuff();
        return StuffType.BRIDGE.getStuff();
    }

    // ladderShape List 를 String 으로 변환
    private static String ladderToString(List<List<String>> array){
        StringBuilder sb = new StringBuilder();
        for(List<String> innerArray : array){
            innerArray.stream().forEach(st -> sb.append(st));
            sb.append('\n');
        }
        return sb.toString();
    }
}
