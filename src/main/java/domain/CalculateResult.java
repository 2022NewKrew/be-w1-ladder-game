package domain;

import repository.Point;
import repository.ResultMapper;

import java.util.stream.Stream;

public class CalculateResult {

    public CalculateResult() { }

    public void calculateResult(ResultMapper resultMapper, Stream<Point> lineStream){
        lineStream.forEach(point -> {
            if(point.getConnected()){
                resultMapper.swapResult(point.getPoint());
            }
        });
    }
}
