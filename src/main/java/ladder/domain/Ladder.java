package ladder.domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Ladder {

    public static int numParticipants;
    public static int height;

    public static final ArrayList<String> listOfParticipants = new ArrayList<>();
    public static final ArrayList<LadderRow> shape = new ArrayList<>();

    public static void preprocessInput(String participantsInput, int heightInput) {

        tokenizeNameInput(participantsInput);
        height = heightInput;
        validateNonZero(height);

    }

    public static void makeLadder() {
        for(int row = 0; row < height; row++) {
            shape.add(new LadderRow(numParticipants));
        }
    }

    public static void printLadder() {
        for(int i = 0; i < listOfParticipants.size(); i++) {
            System.out.print(listOfParticipants.get(i) + " ");
        }
        System.out.println();

        StringBuffer ladderEntire = new StringBuffer();

        for(int row = 0; row < height; row++) {
            ladderEntire.append(shape.get(row).toString());
        }

        System.out.println(ladderEntire.toString());
    }

    private static void validateNonZero (int input) {
        if (input < 1) throw new IllegalArgumentException("양의 정수를 입력해주세요");
    }

    private static void tokenizeNameInput (String inputParticipants) {
        String[] tempListOfParticipants;

        tempListOfParticipants = inputParticipants.split(",");
        numParticipants = tempListOfParticipants.length;
        for(int i = 0; i < tempListOfParticipants.length; i++) {
            listOfParticipants.add(alignStringCenter(tempListOfParticipants[i]));
        }
    }

    private static String alignStringCenter(String inputStr) {
        String str = inputStr.trim();
        if (str.length() > 5) throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요");
        if (str.length() == 1) return "  " + str + "  ";
        if (str.length() == 2) return "  " + str + " ";
        if (str.length() == 3) return " " + str + " ";
        if (str.length() == 4) return " " + str;
        return str;
    }

}
