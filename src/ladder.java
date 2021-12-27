import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class ladder {
    public static void main(String[] args) throws IOException{
        int[] twoParameters = getConsoleTwoParameter();
        ArrayList<ArrayList<Character>> ladder = getLadder(twoParameters);
        showLadder(ladder);
    }

    private static void showLadder(ArrayList<ArrayList<Character>> ladder) {
        for(ArrayList<Character> line : ladder){
            for(Character element : line){
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Character>> getLadder(int[] twoParameters) {
        ArrayList<ArrayList<Character>> ladder = new ArrayList<>();
        int column = twoParameters[1];
        int row = 2*twoParameters[0]-1;

        for(int i=0; i<column; i++ ){
            ArrayList<Character> line = new ArrayList<>();
            for(int j=0; j<row; j++){
                line.add(getLadderElement(j));
            }
            ladder.add(line);
        }
        return ladder;
    }

    private static Character getLadderElement(int columnNumber) {
        if(columnNumber%2==0){
            return 'ㅣ';
        }
        boolean isLadderBridge = new Random().nextInt(100) >= 50;
        if(isLadderBridge){
            return '-';
        }
        return ' ';
    }

    private static int[] getConsoleTwoParameter() throws IOException {
        int [] twoParameters = new int[2];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("참여할 사람은 몇 명인가요 ?");
        twoParameters[0] = Integer.parseInt(bufferedReader.readLine());

        System.out.println("최대 사다리 높이는 몇 개인가요 ?");
        twoParameters[1] = Integer.parseInt(bufferedReader.readLine());
        return twoParameters;
    }
}
