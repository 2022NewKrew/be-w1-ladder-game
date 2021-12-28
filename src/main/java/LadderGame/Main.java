package LadderGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        try{
            Ladder ladder = new Ladder();
            ladder.createLadder();
            ladder.printLadder();
        }catch(IllegalArgumentException e){
            System.err.println(e);
        }

    }
}
