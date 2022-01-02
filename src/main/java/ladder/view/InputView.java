package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public static class LazyHolder {
        public static final InputView INSTANCE = new InputView(new Scanner(System.in));
    }

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView getInstance() {
        return InputView.LazyHolder.INSTANCE;
    }

    public String inputResultPlayerName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    //참여할 플레이어 이름 입력
    public List<String> inputPlayersName() {
        System.out.println("참여할 사람은 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();

        String[] nameArr = names.split(",");

        return Arrays.asList(nameArr);
    }

    //사다리 높이 입력
    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
      
        int result = scanner.nextInt();
        scanner.nextLine();

        return result;
    }

    public List<String> inputGameResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String results = scanner.nextLine();

        String[] resultArr = results.split(",");

        return Arrays.asList(resultArr);
    }
}
