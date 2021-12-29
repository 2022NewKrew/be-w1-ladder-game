package Ladder;

import java.util.ArrayList;
import java.util.Scanner;

public class Ladder {

    public int numParticipants;
    public int height;
    public ArrayList<String> listOfParticipants = new ArrayList<>();
    public ArrayList<LadderRow> shape = new ArrayList<>();

    public void getInput() {
        Scanner sc = new Scanner(System.in);
        String inputParticipants;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        inputParticipants = sc.nextLine();
        tokenizeNameInput(inputParticipants);

        System.out.println("최대 사다리 높이는 얼마인가요?");
        height = sc.nextInt();
        validateNonZero(height);

        sc.close();
    }

    public void makeLadder() {
        for(int row = 0; row < this.height; row++) {
            shape.add(new LadderRow(numParticipants));
        }
    }

    public void printLadder() {
        for(int i = 0; i < listOfParticipants.size(); i++) {
            System.out.print(listOfParticipants.get(i) + " ");
        }
        System.out.println();

        StringBuffer ladderEntire = new StringBuffer();
        for(int row = 0; row < this.height; row++) {
            ladderEntire.append(shape.get(row).toString());
        }

        System.out.println(ladderEntire.toString());
    }

    private void validateNonZero (int input) {
        if (input < 1) throw new IllegalArgumentException("양의 정수를 입력해주세요");
    }

    private void tokenizeNameInput (String inputParticipants) {
        String[] tempListOfParticipants;

        tempListOfParticipants = inputParticipants.split(",");
        numParticipants = tempListOfParticipants.length;
        for(int i = 0; i < tempListOfParticipants.length; i++) {
            listOfParticipants.add(alignStringCenter(tempListOfParticipants[i]));
        }
    }

    private String alignStringCenter(String inputStr) {
        String str = inputStr.trim();
        if (str.length() > 5) throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요");
        if (str.length() == 1) return "  " + str + "  ";
        if (str.length() == 2) return "  " + str + " ";
        if (str.length() == 3) return " " + str + " ";
        if (str.length() == 4) return " " + str;
        return str;
    }

}
