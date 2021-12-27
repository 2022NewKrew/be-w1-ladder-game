package LadderMaker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Day1 {
    private char[] ladderList = {'-', ' '};
    private Random random;

    public Day1(){
        random = new Random();
        int person, ladder;
        person = getInput("참여할 사람은 몇 명인가요?");
        ladder = getInput("최대 사다리 높이는 몇 개인가요?");

        makeLadderWithNoArray(person, ladder);
        System.out.println("-------");
        makeLadderWith2DArrayList(person, ladder);
        System.out.println("-------");
        makeLadderWithSingleArrayList(person, ladder);
        System.out.println("-------");
        makeLadderWith2DArray(person, ladder);
    }

    private int getInput(String description){
        System.out.println(description);
        return new Scanner(System.in).nextInt();
    }

    private char randomCharacter(int j){
        if((j & 1) == 0) return '|';
        else return ladderList[random.nextInt(ladderList.length)];
    }

    private void makeLadderWithNoArray(int person, int ladder){
        StringBuilder sb = new StringBuilder(person << 1);

        for(int i = 0; i < ladder; i++){
            for(int j = 0; j < (person << 1) - 1; j++) sb.append(randomCharacter(j));
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    private void makeLadderWith2DArrayList(int person, int ladder){
        ArrayList<ArrayList<Character>> arrayList = make2DArrayList(person << 1, ladder);
        arrayList.stream()
                .forEach(arrayCharacter -> arrayCharacter.stream()
                                                        .forEach(System.out::print));
    }

    private ArrayList<ArrayList<Character>> make2DArrayList(int personTwice, int ladder){
        ArrayList<ArrayList<Character>> arrayList = new ArrayList<ArrayList<Character>>(ladder);
        for(int i = 0; i < ladder; i++){
            ArrayList<Character> arrayCharacter = new ArrayList<Character>(personTwice);
            for(int j = 0; j < personTwice - 1; j++) arrayCharacter.add(randomCharacter(j));
            arrayCharacter.add('\n');
            arrayList.add(arrayCharacter);
        }

        return arrayList;
    }

    private void makeLadderWithSingleArrayList(int person, int ladder){
        ArrayList<StringBuilder> arrayList = makeSingleArrayList(person << 1, ladder);
        arrayList.stream()
                .forEach(System.out::println);
    }

    private ArrayList<StringBuilder> makeSingleArrayList(int personTwice, int ladder){
        ArrayList<StringBuilder> arrayList = new ArrayList<StringBuilder>(ladder);
        for(int i = 0; i < ladder; i++){
            StringBuilder sb = new StringBuilder(personTwice);
            for(int j = 0; j < personTwice - 1; j++) sb.append(randomCharacter(j));
            arrayList.add(sb);
        }
        return arrayList;
    }

    private void makeLadderWith2DArray(int person, int ladder){
        char[][] array = make2DArray(person << 1, ladder);
        for(int i = 0; i < ladder; i++)
            for(int j = 0; j < person << 1; j++)
                System.out.print(array[i][j]);
    }

    private char[][] make2DArray(int personTwice, int ladder){
        char[][] array = new char[ladder][personTwice];
        for(int i = 0; i < ladder; i++){
            for(int j = 0; j < (personTwice) - 1; j++) array[i][j] = randomCharacter(j);
            array[i][personTwice-1] = '\n';
        }
        return array;
    }
}
