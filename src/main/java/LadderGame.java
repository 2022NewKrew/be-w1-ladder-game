import domain.answer.ResultAnswer;
import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderWithResult;
import domain.ladder.LadderWithResultGenerator;
import view.input.reader.ConfigReader;
import view.input.reader.ConsoleConfigWithResultReader;
import view.input.config.LadderConfig;
import view.output.LadderPrinter;
import view.output.LadderPrinterWithResult;

import java.util.Scanner;

public class LadderGame {

    // 사다리 설정 정보를 관리
    private static ConfigReader configReader = new ConsoleConfigWithResultReader();
    // ladderShape(사다리 모양)를 만들어 Ladder 클래스를 생성
    private static LadderGenerator ladderGenerator = new LadderWithResultGenerator();
    // 이름, 사다리 모양, 결과를 출력
    private static LadderPrinter ladderPrinter = new LadderPrinterWithResult();
    // 결과에 대한 질문 답변
    private static ResultAnswer resultAnswer = new ResultAnswer();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력 받기
        LadderConfig ladderConfig = configReader.readLadderConfig(sc);

        // 사다리 만들기
        Ladder ladder = ladderGenerator.createLadder(ladderConfig);

        // 출력
        ladderPrinter.printLadderShape(ladder);

        // 실행 결과 출력
        resultAnswer.answerResult(sc, ((LadderWithResult) ladder));

        sc.close();
    }

}
