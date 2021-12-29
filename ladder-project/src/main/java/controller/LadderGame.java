package controller;

import domain.Ladder;
import domain.participant.Participant;
import view.LadderShape;
import view.ScreenMessage;

import java.util.Scanner;

public class LadderGame {

    private final Scanner sc;

    public LadderGame(Scanner sc) {
        this.sc = sc;
    }

    public void play() {
        int participantNumber = ScreenMessage.input("참여할 사람은 몇 명인가요? (1 명 이상 입력해주세요)", sc);
        int height = ScreenMessage.input("최대 사다리 높이는 몇 개인가요?", sc);

        Participant participant = new Participant(participantNumber);
        Ladder ladder = new Ladder(participant.howManyParticipant(), height);

        LadderShape ladderShape = LadderShape.create(ladder.getLadder());
        ladderShape.printLadderShape();
    }

}
