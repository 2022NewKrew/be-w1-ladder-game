package domain;

import view.input.LadderConfig;
import view.input.LadderConfigWithName;

import java.util.stream.IntStream;

public class LadderWithNameBuilder extends LadderBuilder{

    @Override
    // ladderShape 를 만들어 LadderWithName 객체 완성
    public Ladder createLadder(LadderConfig ladderConfigWithName){
        final int width = ladderConfigWithName.getWidth();
        final int height = ladderConfigWithName.getHeight();

        Ladder ladder = new LadderWithName(width, height, ((LadderConfigWithName) ladderConfigWithName).getNames());

        // 한 줄(List<String>) 을 createRow 함수로 생성하여 add
        IntStream.range(0, height).forEach(j -> ladder.getLadderShape().add(new Line(createRow(width))));
        return ladder;
    }
}
