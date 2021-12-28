import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    // 인스턴스 변수
    private final int column;
    private final int row;
    private final List<List<Character>> ladder;

    // 생성자
    public Ladder(int[] inputNumber) {
        this.column = inputNumber[1];
        this.row = 2 * inputNumber[0]-1;
        this.ladder = getLadder();
    }

    // 메소드
    private List<List<Character>> getLadder() {
        List<List<Character>> createdLadder = new ArrayList<>();

        for(int i=0; i<column; i++ ){
            List<Character> line = getLadderOneLine();
            createdLadder.add(line);
        }
        return createdLadder;
    }

    private List<Character> getLadderOneLine(){
        List<Character> result = new ArrayList<>();
        for(int i = 0; i<row; i++) {
            result.add(getLadderElement(i));
        }
        return result;
    }

    private Character getLadderElement(int columnNumber) {
        if(columnNumber%2==0){
            return 'ㅣ';
        }

        boolean isLadderBridge = getRandomBridgeByPercent(50);
        if(isLadderBridge){
            return '-';
        }
        return ' ';
    }

    private boolean getRandomBridgeByPercent(int percent){
        return new Random().nextInt(100) >= percent;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(List<Character> line : ladder){
            for(Character element : line){
                result.append(element);
            }
            result.append("\n");
        }
        return result.toString();
    }
}
