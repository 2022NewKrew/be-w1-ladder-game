package ladder.view;

import java.util.List;
import java.util.Scanner;

// 예외처리도 해야함
public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public List<String> inputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return List.of(sc.next().split(","));
    }

    public int inputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }
}
