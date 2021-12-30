package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Ladder {

    public static int numParticipants;
    public static int height;

    public static final ArrayList<String> listOfParticipants = new ArrayList<>();
    public static final ArrayList<LadderRow> shape = new ArrayList<>();
    public static final ArrayList<String> listOfResult = new ArrayList<>();
    public static final HashMap<String, String> resultMap = new HashMap<>();

    public static void preprocessInput(String participantsInput, int heightInput, String resultInput) {

        tokenizeNameInput(participantsInput);
        height = heightInput;
        validateNonZero(height);
        tokenizeResultInput(resultInput);

    }

    public static void makeLadder() {
        for(int row = 0; row < height; row++) {
            shape.add(new LadderRow(numParticipants));
        }

        calculateResult();
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

        System.out.print(ladderEntire.toString());

        for(String el : listOfResult) System.out.print(el);
        System.out.println();
    }

    public static void processCommand (String command) {
        if (command.trim().equals("all")) System.out.println(resultMap.toString());
        System.out.println(command + ": " + resultMap.get(command.trim()));
    }

    private static void calculateResult () {
        ArrayList<Integer> nameIdxList = new ArrayList<>();
        for (int i = 0; i < listOfParticipants.size(); i++) nameIdxList.add(i);

        for (LadderRow line : shape) {
            for (int i = 0; i < line.horizonBranch.size(); i++) {
                if (line.horizonBranch.get(i) == true) {
                    Collections.swap(nameIdxList, i, i+1);
                }
            }
        }

        for (int i = 0; i < listOfParticipants.size(); i++) {
            resultMap.put(listOfParticipants.get(nameIdxList.get(i)).trim(), listOfResult.get(i));
        }
    }

    private static void validateNonZero (int input) {
        if (input < 1) throw new IllegalArgumentException("양의 정수를 입력해주세요");
    }

    private static void tokenizeNameInput (String inputParticipants) {
        String[] tokenizedParticipants = tokenizeString(inputParticipants);
        numParticipants = tokenizedParticipants.length;
        for(int i = 0; i < tokenizedParticipants.length; i++) {
            listOfParticipants.add(alignStringCenter(tokenizedParticipants[i]));
        }
    }

    private static void tokenizeResultInput (String inputResults) {
        for(String el : inputResults.split(",")) {
            listOfResult.add(alignStringCenter(el.trim()));
        }
    }

    private static String[] tokenizeString (String inputs) {
        return inputs.split(",");
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
