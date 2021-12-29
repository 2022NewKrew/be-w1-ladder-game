package Ladder;

import java.util.ArrayList;
import java.util.Scanner;

public class Ladder {

    public int numParticipants;
    public int height;
<<<<<<< HEAD
    public final ArrayList<String> listOfParticipants = new ArrayList<>();
    public final ArrayList<LadderRow> shape = new ArrayList<>();
=======
    public ArrayList<String> listOfParticipants = new ArrayList<>();
    public ArrayList<LadderRow> shape = new ArrayList<>();
>>>>>>> 6ea4f61 ([feat] step3 구현)

    public void getInput() {
        Scanner sc = new Scanner(System.in);
        String inputParticipants;
<<<<<<< HEAD
<<<<<<< HEAD

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        inputParticipants = sc.nextLine();
        tokenizeNameInput(inputParticipants);
=======
        String[] tempListOfParticipants;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        inputParticipants = sc.nextLine();
        tempListOfParticipants = inputParticipants.split(",");
        numParticipants = tempListOfParticipants.length;
        for(int i = 0; i < tempListOfParticipants.length; i++) {
            listOfParticipants.add(alignStringCenter(tempListOfParticipants[i]));
        }
>>>>>>> 6ea4f61 ([feat] step3 구현)
=======

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        inputParticipants = sc.nextLine();
        tokenizeNameInput(inputParticipants);
>>>>>>> 8702c13 ([refactor] step-3 리팩토링)

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
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 6ea4f61 ([feat] step3 구현)
=======
>>>>>>> 8702c13 ([refactor] step-3 리팩토링)
        for(int row = 0; row < this.height; row++) {
            ladderEntire.append(shape.get(row).toString());
        }

        System.out.println(ladderEntire.toString());
    }

    private void validateNonZero (int input) {
        if (input < 1) throw new IllegalArgumentException("양의 정수를 입력해주세요");
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 8702c13 ([refactor] step-3 리팩토링)
    private void tokenizeNameInput (String inputParticipants) {
        String[] tempListOfParticipants;

        tempListOfParticipants = inputParticipants.split(",");
        numParticipants = tempListOfParticipants.length;
        for(int i = 0; i < tempListOfParticipants.length; i++) {
            listOfParticipants.add(alignStringCenter(tempListOfParticipants[i]));
        }
    }

<<<<<<< HEAD
=======
>>>>>>> 6ea4f61 ([feat] step3 구현)
=======
>>>>>>> 8702c13 ([refactor] step-3 리팩토링)
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
