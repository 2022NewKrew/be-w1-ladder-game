package LadderMaker.Day1;

import java.util.Scanner;

public class Week1 {
    public Week1(){
        final int person, height;
        person = getInput("참여할 사람은 몇 명인가요?");
        height = getInput("최대 사다리 높이는 몇 개인가요?");

        new LadderWith2DArrayList(person, height);
        System.out.println("-------");
        new LadderWithSingleArrayList(person, height);
        System.out.println("-------");
        new LadderWith2DArray(person, height);
    }


    private int getInput(String description){
        System.out.println(description);
        return new Scanner(System.in).nextInt();
    }



}
