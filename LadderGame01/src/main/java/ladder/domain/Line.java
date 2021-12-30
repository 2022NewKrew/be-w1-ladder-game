package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static Random random = new Random();
    private int width;
    private List<Bridge> shape = new ArrayList<>();

    protected Line(int width) throws IllegalArgumentException{
        if(width < 1)
            throw new IllegalArgumentException("사다리 게임의 참여자는 1명 이상이어야 합니다.");
        this.width = width;
        makeRandomLine();
    }
    private void makeRandomLine(){
        for(int col = 0 ; col < width-1; ++col){
            shape.add( isLeftConnected(col) ? new Bridge(false) : new Bridge(random.nextBoolean()) );
        }
    }
    private boolean isLeftConnected(int col){
        return (col > 0) && shape.get(col-1).isConnected();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Bridge bridge : shape){
            sb.append("|").append(bridge);
        }
        sb.append("|\n");
        return sb.toString();
    }
}
