package domain;

import repository.Constant;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HeightOfLadderScanner {
    Scanner scanner = new Scanner(System.in);
    public int getHeightOfLadder(){
        int heightOfLadder;
        do{
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            heightOfLadder = getInteger();
        }while(!validateBoundary(heightOfLadder));
        return heightOfLadder;
    }

    public int getInteger(){
        try{
            return scanner.nextInt();
        }catch(InputMismatchException e){
            return -1;
        }
    }

    public boolean validateBoundary(int heightOfLadder){
        if(heightOfLadder < Constant.MIN_HEIGHT_LENGTH){
            System.out.println("1이상의 정수를 입력해주세요.");
            return false;
        }
        return true;
    }
}
