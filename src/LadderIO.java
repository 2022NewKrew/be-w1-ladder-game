package ladderGame;

import java.util.Scanner;
import ladderGame.Ladder;

public class LadderIO {

    static Scanner sc = new Scanner(System.in);

    public static void getNumOfPeopleIO(Ladder ladder){
        System.out.println("참여 할 사람은 몇 명인가요?");
        setLadderVariable(ladder,"numOfPeople");
    }

    public static void getLadderHeightIO(Ladder ladder) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        setLadderVariable(ladder,"height");
    }


    private static void setLadderVariable(Ladder ladder, String variable){
        int input = sc.nextInt();
        if(variable.equals("numOfPeople")){
            ladder.setNumOfPeople(input);
        }
        if(variable.equals("height")){
            ladder.setHeight(input);
        }
    }

}

