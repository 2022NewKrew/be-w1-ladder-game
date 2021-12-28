package ladderGame;

import java.util.Scanner;
import ladderGame.Ladder;

public class LadderIO {

    static Scanner sc = new Scanner(System.in);
    static int numOfPeople;
    static int ladderHeight;

    public static void getNumOfPeopleIO(){
        System.out.println("참여 할 사람은 몇 명인가요?");
        setLadderVariable("numOfPeople");
    }

    public static void getLadderHeightIO() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        setLadderVariable("ladderHeight");
    }

    public static void setLadderVariable(String variable){
        int input = sc.nextInt();
        if(variable.equals("numOfPeople")){
            numOfPeople = input;
        }
        if(variable.equals("ladderHeight")){
            ladderHeight = input;
        }
    }

    public static Ladder constructLadder(){
        Ladder ladder = new Ladder(ladderHeight,numOfPeople);
        return ladder;
    }

}

