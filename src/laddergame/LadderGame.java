package laddergame;

import java.util.Scanner;

public class LadderGame {
//    public void setArray(char[][] arr){
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[0].length;j++){
//                if (j%2==0) arr[i][j]='|';
//            }
//        }
//    }
//
//    public void setLadder(char[][] arr,int personNum){
//        for(int i=0;i<arr.length;i++){
//            int randomNum = (int)(Math.random()*(personNum-1));
//            for(int j=0;j<arr[0].length;j++){
//                if (j%2 != 0){
//                    if (j == randomNum*2+1) arr[i][j]='-';
//                    else arr[i][j] = ' ';
//                }
//            }
//        }
//    }

    public static void main(String[] args){
//        LadderGame lg = new LadderGame();
//        int personNum;
//        int ladderHeight;
//        char [][] arr;
        Ladder ld = new Ladder();


        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇명인가요?");
//        personNum = sc.nextInt();
        ld.setPersonNum(sc.nextInt());
        System.out.println("최대 사다리 높이는 몇 개인가요?");
//        ladderHeight = sc.nextInt();
        ld.setLadderHeight(sc.nextInt());
        System.out.println();

        ld.makeBasicLadder();
        ld.makeCompleteLadder();
        ld.printLadder();

//        arr = new char[ladderHeight][personNum*2-1];
//
//        lg.setArray(arr);
//        lg.setLadder(arr,personNum);
//
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[0].length;j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
    }
}