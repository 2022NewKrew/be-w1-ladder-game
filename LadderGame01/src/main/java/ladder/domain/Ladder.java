package ladder.domain;

import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> shape = new ArrayList<>();
    private int width;
    private int height;

    public Ladder(int width, int height) throws IllegalArgumentException{
        if(height<1)
            throw new IllegalArgumentException("사다리의 높이는 1이상 이어야합니다.");
        this.height = height;
        this.width = width;
        makeLadder();
    }
    private void makeLadder(){
        for(int row = 0 ; row < height; ++row){
            shape.add(new Line(width));
        }
    }

    public List<Line> getShape() {
        return shape;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Line line : shape){
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}