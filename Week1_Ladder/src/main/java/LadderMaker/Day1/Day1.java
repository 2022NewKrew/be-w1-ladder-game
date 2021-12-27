package LadderMaker.Day1;

import java.util.Scanner;

public class Day1 {
    public Day1(){
        final int person, height;
        person = getInput("참여할 사람은 몇 명인가요?");
        height = getInput("최대 사다리 높이는 몇 개인가요?");

//        makeLadderWithNoArray(person, height); // ladder with no array
//        System.out.println("-------");
        new LadderWith2DArrayList(person, height);
        System.out.println("-------");
        new LadderWithSingleArrayList(person, height);
        System.out.println("-------");
        new LadderWith2DArray(person, height);
    }

    /**
     * introduce and get Input
     * @param description
     * @return
     */
    private int getInput(String description){
        System.out.println(description);
        return new Scanner(System.in).nextInt();
    }

//    /**
//     * Make and Draw ladder with no array as using StringBuilder
//     * @param person
//     * @param ladder
//     */
//    private void makeLadderWithNoArray(int person, int ladder){
//        StringBuilder sb = new StringBuilder(person * 2);
//
//        for(int i = 0; i < ladder; i++){
//            for(int j = 0; j < (person * 2) - 1; j++) sb.append(randomCharacter(j));
//            System.out.println(sb.toString());
//            sb.setLength(0);
//        }
//    }


}
