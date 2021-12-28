import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final int column;
    private final int row;
    private final ArrayList<ArrayList<Character>> ladder;

    public Ladder(int[] inputNumber) {
        this.column = inputNumber[1];
        this.row = 2 * inputNumber[0]-1;
        this.ladder = getLadder();
    }

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

        System.out.println("참여할 사람은 몇 명인가요 ?");
        twoParameters[0] = Integer.parseInt(bufferedReader.readLine());

        System.out.println("최대 사다리 높이는 몇 개인가요 ?");
        twoParameters[1] = Integer.parseInt(bufferedReader.readLine());
        return twoParameters;
    }
}
