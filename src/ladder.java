import java.util.ArrayList;
import java.util.Random;

public class Ladder {

    // 인스턴스 변수
    private final int column;
    private final int row;
    private final ArrayList<ArrayList<Character>> ladder;

    // 생성자
    public Ladder(int[] inputNumber) {
        this.column = inputNumber[1];
        this.row = 2 * inputNumber[0]-1;
        this.ladder = getLadder();
    }

    // 메소드
    private ArrayList<ArrayList<Character>> getLadder() {
        ArrayList<ArrayList<Character>> createdLadder = new ArrayList<>();

        for(int i=0; i<column; i++ ){
            ArrayList<Character> line = new ArrayList<>();
            for(int j=0; j<row; j++) {
                line.add(getLadderElement(j));
            }
            createdLadder.add(line);
        }
        return createdLadder;
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
        for(ArrayList<Character> line : ladder){
            for(Character element : line){
                result.append(element);
            }
            result.append("\n");
        }
        return result.toString();
    }
}
