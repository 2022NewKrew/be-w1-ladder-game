package ladder.view;

import ladder.domain.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

    static Scanner sc = new Scanner(System.in);

    public static ArrayList<Person> inputPerson() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] inputStrings = sc.nextLine().split(",");

        ArrayList<Person> people = new ArrayList<>();
        for (String inputString : inputStrings) {
            people.add(new Person(inputString));
        }
        return people;
    }

    public static int inputLadderCount() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderCount = sc.nextInt();
        System.out.println();
        return ladderCount;
    }


}
