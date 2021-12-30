package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int MIN_SIZE_OF_PARTICIPANT = 2;
    private List<Participant> participants;
    private Ladder ladder;

    /**
     * 사다리 게임을 생성한다.
     */
    public static LadderGame createGame(List<String> names, int ladderHeight) throws Exception {
        LadderGame game = new LadderGame();
        game.setParticipants(names);
        game.setLadder(ladderHeight);
        return game;
    }

    /**
     * 사다리 게임 참가자를 세팅한다.
     */
    private void setParticipants(List<String> names) throws Exception {
        validateSizeOfParticipants(names.size());

        List<Participant> participants = new ArrayList<>();
        for (String name : names) {
            validateParticipantName(name);
            participants.add(new Participant(name));
        }
        this.participants = participants;
    }

    /**
     * 참가자 인원 수 유효성 검사
     */
    private void validateSizeOfParticipants(int size) throws Exception {
        if (size < MIN_SIZE_OF_PARTICIPANT) {
            throw new Exception(MIN_SIZE_OF_PARTICIPANT + "명 이상을 입력하세요.");
        }
    }

    /**
     * 참가자 이름 유효성 검사
     */
    private void validateParticipantName(String name) throws Exception {
        if (name == null
                || name.length() == 0
                || name.length() > Participant.MAX_LENGTH_OF_PARTICIPANT_NAME) {
            throw new Exception("사람 이름은 공백이거나 " + Participant.MAX_LENGTH_OF_PARTICIPANT_NAME + "글자을 초과하여 입력할 수 없습니다.");
        }
    }

    /**
     * 사다리를 세팅한다.
     */
    private void setLadder(int height) throws Exception {
        if (height <= 0) {
            throw new Exception("0과 같거나 작은 수를 입력하였습니다.");
        }
        this.ladder = new Ladder(this.participants.size() - 1, height);
    }

    /**
     * 참가자 리스트를 반환한다.
     */
    public List<Participant> getParticipants() {
        return participants;
    }

    /**
     * 사다리를 반환한다.
     */
    public Ladder getLadder() {
        return ladder;
    }

}
