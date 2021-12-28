package step2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ladder {
    private final int people;
    private final int ladderHeight;
    private final ArrayList<ArrayList<String>> ladderBoard;

    public Ladder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        people = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
        ladderBoard = new ArrayList<>();
    }

    private void makeLadder(){
        for(int i = 0; i < ladderHeight; i++){
            drawLine();
        }
    }

    private void drawLine(){
        ArrayList<String> lineList = new ArrayList<>();
        for(int j = 0; j < 2 * people -1; j++){
            lineList.add(getLine(j));
        }
        ladderBoard.add(lineList);
    }

    private String getLine(int j){
        Random random = new Random();
        if(j % 2 == 0){
            return "|";
        }
        return random.nextBoolean()? "-" : " ";
    }

    private void printLadder(){
        for(ArrayList<String> lines : ladderBoard){
            System.out.println(String.join("",lines));
        }
    }

    public void startGame(){
        makeLadder();
        printLadder();
    }
}
