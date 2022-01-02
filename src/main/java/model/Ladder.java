package model;

import DTO.ResultInfo;

import javax.imageio.event.IIOReadUpdateListener;
import javax.xml.transform.Result;
import java.util.ArrayList;
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
        return ladder.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }

    public ResultInfo makeResultInfo(){
        String stringLadder = toString();
        List<Integer> resultOrder = new ArrayList<>();

        return new ResultInfo(stringLadder, resultOrder);
    }
}

