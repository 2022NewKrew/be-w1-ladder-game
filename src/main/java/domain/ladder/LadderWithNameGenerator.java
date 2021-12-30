package domain.ladder;

import view.input.config.LadderConfig;
import view.input.config.LadderConfigWithName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderWithNameGenerator extends LadderGenerator {

    @Override
    // ladderShape 를 만들어 LadderWithName 객체 완성
    public Ladder createLadder(LadderConfig ladderConfigWithName){
        final int peopleCount = ladderConfigWithName.getPeopleCount();
        final int height = ladderConfigWithName.getHeight();

        // 한 줄(List<String>) 을 createRow 함수로 생성하여 add
        List<Line> ladderShape = new ArrayList<>();
        IntStream.range(0, height).forEach(j -> ladderShape.add(new Line(createRow(peopleCount))));

        Ladder ladder = new LadderWithName.Builder()
                .names(((LadderConfigWithName)ladderConfigWithName).getNames())
                .peopleCount(peopleCount)
                .height(height)
                .ladderShape(ladderShape)
                .build();

        return ladder;
    }
}
