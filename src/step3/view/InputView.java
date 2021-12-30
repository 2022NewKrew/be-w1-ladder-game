package step3.view;

import step3.domain.LadderHeight;
import step3.domain.LadderResult;
import step3.domain.Player;

import java.util.Scanner;

public class InputView {
    private static final InputView INSTANCE = new InputView();
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() { }

    public Player inputPeople () {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Player(SCANNER.nextLine());
    }

    public LadderHeight inputHeight () {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new LadderHeight(SCANNER.nextInt());
    }

    public LadderResult inputResult () {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new LadderResult(SCANNER.nextLine());
    }

    public String inputName () {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }

    public static InputView getInstance() { return INSTANCE; }
}
