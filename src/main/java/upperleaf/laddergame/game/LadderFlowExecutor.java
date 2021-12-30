package upperleaf.laddergame.game;

import upperleaf.laddergame.domain.LadderFlow;

import java.util.Scanner;
import java.util.function.Function;

/**
 * LadderFlow를 실행시키기 위해서 사용자로부터 값을 입력받고 실행시키는 객체입니다.
 * 사용자로부터 입력을 받으면 CommandFunctionMapper를 호출해서, 사용자가 입력한 값에 따라 적절한 함수 객체를 반환받습니다.
 * 함수 객체를 실행시켰을때 true를 반환하면 계속해서 실행하고, false를 반환하면 메서드를 종료합니다.
 */
public class LadderFlowExecutor {

    private final LadderFlow ladderFlow;
    private final Scanner scanner = new Scanner(System.in);

    public LadderFlowExecutor(LadderFlow ladderFlow) {
        this.ladderFlow = ladderFlow;
    }

    public void execute() {
        String inputName = inputPlayerNameForResult();
        Function<LadderFlow, Boolean> flowFunction = CommandFunctionMapper.mapCommandToFunction(inputName);

        while(flowFunction.apply(ladderFlow)) {
            inputName = inputPlayerNameForResult();
            flowFunction = CommandFunctionMapper.mapCommandToFunction(inputName);
        }
    }

    private String inputPlayerNameForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
