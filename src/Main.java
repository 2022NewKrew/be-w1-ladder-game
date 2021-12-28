package ladderGame;

import java.io.IOException;
import java.util.Scanner;

import ladderGame.Ladder;
import ladderGame.LadderIO;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Ladder ladder = new Ladder();

        LadderIO ladderIO = new LadderIO();
        ladderIO.getNumOfPeopleIO(ladder);
        ladderIO.getLadderHeightIO(ladder);

        ladder.drawLadder();

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
