package domain.ladder;

import view.input.config.LadderConfig;
import view.input.config.LadderConfigWithName;
import view.input.config.LadderConfigWithResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderWithResultGenerator extends LadderWithNameGenerator{

    @Override
    // ladderShape 를 만들어 LadderWithName 객체 완성
    public Ladder createLadder(LadderConfig ladderConfigWithResult){
        final int peopleCount = ladderConfigWithResult.getPeopleCount();
        final int height = ladderConfigWithResult.getHeight();

        // 한 줄(List<String>) 을 createRow 함수로 생성하여 add | 부모 클래스에 정의되어 있음
        List<Line> ladderShape = new ArrayList<>();
        IntStream.range(0, height).forEach(j -> ladderShape.add(new Line(createRow(peopleCount))));

        Ladder ladder = new LadderWithResult.Builder()
                .results(((LadderConfigWithResult)ladderConfigWithResult).getResults())
                .names(((LadderConfigWithName)ladderConfigWithResult).getNames())
                .peopleCount(peopleCount)
                .height(height)
                .ladderShape(ladderShape)
                .build();

        return ladder;
    }
}
