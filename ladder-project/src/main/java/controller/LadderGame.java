package controller;

import domain.Ladder;
import domain.participant.Participant;
import util.StringParsingUtil;
import view.LadderShape;
import view.NameView;
import view.ScreenMessage;

import java.util.Scanner;

public class LadderGame {

    private final Scanner sc;

    public LadderGame(Scanner sc) {
        this.sc = sc;
    }

    public void play() {
        String participantList = ScreenMessage.inputToString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요 1 명 이상 입력해주세요)", sc);
        int height = ScreenMessage.inputToInt("최대 사다리 높이는 몇 개인가요?", sc);

        Participant participant = new Participant(StringParsingUtil.parse(participantList, ","));
        Ladder ladder = new Ladder(participant.howManyParticipant(), height);

        NameView nameView = NameView.create(participant.getParticipantNameList());
        nameView.printNameList();

        LadderShape ladderShape = LadderShape.create(ladder.getLadder());
        ladderShape.printLadderShape();
    }

}
