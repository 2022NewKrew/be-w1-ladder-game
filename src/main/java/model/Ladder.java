package model;

import DTO.ResultInfo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(List<String> namePeople, int numPeople, int maxHeight){
        ladder = IntStream
                .range(0,maxHeight)
                .mapToObj(i -> new Line(numPeople))
                .collect(Collectors.toList());
    }

    @Override
    public String toString(){
        return ladder.
                stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
    private List<Integer> makeResultOrder(){
        List<Integer> resultOrder = IntStream
                .range(0,ladder.get(0).size()+1)
                .boxed()
                .collect(Collectors.toList());

        ladder
                .forEach(line -> line.makeSwap(resultOrder));

        return resultOrder;
    }

    public ResultInfo makeResultInfo(){
        String stringLadder = toString();
        List<Integer> resultOrder = makeResultOrder();

        return new ResultInfo(stringLadder, resultOrder);
    }
}

