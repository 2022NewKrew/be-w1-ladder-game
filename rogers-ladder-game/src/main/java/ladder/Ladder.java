package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final Random random = new Random();
    private final List<List<Character>> ladderMap = new ArrayList<>();

    public Ladder(int people, int height) {
        fillMap(people, height);
    }

    private void fillMap(int people, int height){
        for(int row=0; row < height; row++){
            ladderMap.add(new ArrayList<>());
            for(int col=0; col < 2*people-1; col++){
                fillOne(row, col);
            }
        }
    }

    private void fillOne(int row, int col){
        if(isLine(col)){
            ladderMap.get(row).add('|');
        }else if (isEmpty(row,col)){
            ladderMap.get(row).add(' ');
        }else {
            ladderMap.get(row).add('-');
        }
    }

    private boolean isLine(int col){
        return col % 2 == 0;
    }

    private boolean isEmpty(int row, int col){
        return !random.nextBoolean()
                || (col >= 2 && ladderMap.get(row).get(col-2) == '-');
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<Character> line : ladderMap){
            for(Character ch : line){
                sb.append(ch);
            }
            sb.append('\n');
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
