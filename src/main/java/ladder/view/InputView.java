package ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import ladder.domain.Person;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {
    }

    public static ArrayList<Person> inputPerson() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] inputStrings = br.readLine().split(",");
        ArrayList<Person> persons = new ArrayList<>();
        for (String inputString : inputStrings) {
            persons.add(new Person(inputString));
        }
        return persons;
    }

    public static int inputLadderHeight() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = Integer.parseInt(br.readLine());
        System.out.println();

        return ladderHeight;
    }

}
