package controller;

import domain.Result;
import domain.ladder.Ladder;
import domain.ladder.line.RandomLineStrategy;
import domain.participant.Participant;
import service.LadderGameService;
import service.LadderService;
import service.ParticipantService;
import util.StringParsingUtil;
import view.LadderShape;
import view.ResultView;
import view.ScreenMessage;
import view.StringView;

import java.util.Map;
import java.util.Scanner;

public class LadderGame {

    private final Scanner sc;
    private Result result;
    private LadderGameService ladderGameService;
    private LadderService ladderService;
    private ParticipantService participantService;
    private Map<String, String> gameResult;

    public LadderGame(Scanner sc) {
        this.sc = sc;
    }

    public void initGame() {
        String participantList = ScreenMessage.inputToString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요 1 명 이상 입력해주세요)", sc);
        String executeResult = ScreenMessage.inputToString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", sc);
        int height = ScreenMessage.inputToInt("최대 사다리 높이는 몇 개인가요?", sc);

        Participant participant = new Participant(StringParsingUtil.parse(participantList, ","));
        this.participantService = new ParticipantService(participant);
        Ladder ladder = new Ladder(participant.howManyParticipant(), height, new RandomLineStrategy());
        this.ladderService = new LadderService(ladder);
        this.result = new Result(StringParsingUtil.parse(executeResult, ","));

        this.ladderGameService = new LadderGameService(ladderService, participantService);
    }

    public void play() {
        this.gameResult = ladderGameService.playGame(result);
    }

    public void result() {
        StringView.create(participantService.getParticipantNameList()).printStrings();
        LadderShape.create(ladderService.getLadder()).printLadderShape();
        StringView.create(result.getResult()).printStrings();

        while (true) {
            String input = ScreenMessage.inputToString("결과를 보고 싶은 사람은?", sc);
            System.out.println("실행 결과");
            endGame(input);
            ResultView.printResult(input, gameResult);
            ResultView.printResultAll(input, gameResult);
        }
    }

    private void endGame(String input) {
        if (input.equals("춘식이")) {
            System.exit(0);
        }
    }
}
