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

        makeLadderWithNoArray(person, ladder); // ladder with no array
        System.out.println("-------");
        makeLadderWith2DArrayList(person, ladder); // ladder with 2D ArrayList
        System.out.println("-------");
        makeLadderWithSingleArrayList(person, ladder); // ladder with Single ArrayList and StringBuilder
        System.out.println("-------");
        makeLadderWith2DArray(person, ladder); // ladder with 2D Array
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

    private boolean isEvenNumber(int j){
        if((j & 1) == 0) return true;
        return false;
    }

    /**
     * return random Character
      * @param j
     * @return
     */
    private char randomCharacter(int j){
        if(isEvenNumber(j)) return '|';
        else return ladderList[random.nextInt(ladderList.length)];
    }

    /**
     * Make and Draw ladder with no array as using StringBuilder
     * @param person
     * @param ladder
     */
    private void makeLadderWithNoArray(int person, int ladder){
        StringBuilder sb = new StringBuilder(person * 2);

        for(int i = 0; i < ladder; i++){
            for(int j = 0; j < (person * 2) - 1; j++) sb.append(randomCharacter(j));
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    /**
     * Draw ladder using 2D ArrayList
     * @param person
     * @param ladder
     */
    private void makeLadderWith2DArrayList(int person, int ladder){
        ArrayList<ArrayList<Character>> arrayList = make2DArrayList(person * 2, ladder);
        arrayList.stream()
                .forEach(arrayCharacter -> arrayCharacter.stream()
                                                        .forEach(System.out::print));
    }

    /**
     * Make ladder using 2D ArrayList
     * @param personTwice
     * @param ladder
     * @return
     */
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

    /**
     * Draw ladder using Single ArrayList and StringBuilder
     * @param person
     * @param ladder
     */
    private void makeLadderWithSingleArrayList(int person, int ladder){
        ArrayList<StringBuilder> arrayList = makeSingleArrayList(person * 2, ladder);
        arrayList.stream()
                .forEach(System.out::println);
    }

    /**
     * Make ladder using Single ArrayList and StringBuilder
     * @param personTwice
     * @param ladder
     * @return
     */
    private ArrayList<StringBuilder> makeSingleArrayList(int personTwice, int ladder){
        ArrayList<StringBuilder> arrayList = new ArrayList<StringBuilder>(ladder);
        for(int i = 0; i < ladder; i++){
            StringBuilder sb = new StringBuilder(personTwice);
            for(int j = 0; j < personTwice - 1; j++) sb.append(randomCharacter(j));
            arrayList.add(sb);
        }
        return arrayList;
    }

    /**
     * Draw ladder using 2D Array
     * @param person
     * @param ladder
     */
    private void makeLadderWith2DArray(int person, int ladder){
        char[][] array = make2DArray(person * 2, ladder);
        for(int i = 0; i < ladder; i++)
            for(int j = 0; j < person * 2; j++)
                System.out.print(array[i][j]);
    }

    /**
     * Make ladder using 2D Array
     * @param personTwice
     * @param ladder
     * @return
     */
    private char[][] make2DArray(int personTwice, int ladder){
        char[][] array = new char[ladder][personTwice];
        for(int i = 0; i < ladder; i++){
            for(int j = 0; j < (personTwice) - 1; j++) array[i][j] = randomCharacter(j);
            array[i][personTwice-1] = '\n';
        }
        return array;
    }
}
