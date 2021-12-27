import java.util.Random;
import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {
        //input
        LadderObj ladderObj = input();

        //business logic
        boolean[][] ladderGame = makeLadderGame(ladderObj);

        //output
        StringBuilder stringBuilder = output(ladderGame, ladderObj);
        System.out.println(stringBuilder.toString());
    }

    public static LadderObj input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int members = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int ladders = scanner.nextInt();
        return new LadderObj(members, ladders);
    }

    public static boolean[][] makeLadderGame(LadderObj ladderObj){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        boolean[][] ladderGame = new boolean[ladderObj.ladders][ladderObj.members-1];
        for(int i = 0 ; i < ladderObj.ladders; ++i){
            for(int j = 0 ; j < ladderObj.members-1; ++j){
                if(j != 0 && ladderGame[i][j-1]) continue;
                if(random.nextInt(2) == 1) ladderGame[i][j] = true;
            }
        }
        return ladderGame;
    }

    public static StringBuilder output(boolean[][] ladderGame, LadderObj ladderObj){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < ladderObj.ladders; ++i){
            stringBuilder.append("|");
            for(int j = 0 ; j < ladderObj.members-1; ++j){
                if(ladderGame[i][j]) stringBuilder.append("-|");
                else stringBuilder.append(" |");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }
}

class LadderObj{
    int members;
    int ladders;
    public LadderObj(int members, int ladders){
        this.members = members;
        this.ladders = ladders;
    }
}