package com.cold.ladderGame;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ladder {
    private int Person;
    private int Height;
    private ArrayList<ArrayList<Character>> LadderResult;

    public void setValues(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("참여할 사람은 몇 명인가요?");
            Person = sc.nextInt();
        } while(Person <= 0);
        do{
            System.out.println("최대 사다리 높이는 몇 개인가요??");
            Height = sc.nextInt();
        } while(Height <= 0);
    }

    public void createLadder(){
        LadderResult = new ArrayList<ArrayList<Character>>(Height);
        for(int row=0;row<Height;row++){
            ArrayList<Character> randomRow = randomInsert();
            LadderResult.add(row,randomRow);
        }
    }

    ArrayList<Character> randomInsert(){
        Random random = new Random();
        ArrayList<Character> temp = new ArrayList<>(Person-1);

        for(int col=0;col<Person-1;col++){
            if(col>0 && temp.get(col-1).equals('-'))
                temp.add(' ');
            else {
                if (random.nextBoolean())
                    temp.add('-');
                else
                    temp.add(' ');
            }
        }
        return temp;
    }

    public void printladder(){
        for(int row = 0;row<Height;row++){
            for(int col=0;col<Person-1;col++){
                System.out.print('ㅣ');
                System.out.print(LadderResult.get(row).get(col));
            }
            System.out.println('ㅣ');
        }
    }

    public void printValues(){
        System.out.println("Person : " + Person);
        System.out.println("Height : " + Height);
    }
}
