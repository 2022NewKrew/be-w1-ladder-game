package upperleaf.laddergame.domain.connector;

import upperleaf.laddergame.domain.Ladder;

/**
 * Player 숫자와 사다리 높이를 적절히 이용해 계산해서 사다리 연결 개수를 반환합니다.
 */
public class LadderConnectionNumberPolicy implements ConnectionNumberPolicy {

    @Override
    public int getConnectionNumber(Ladder ladder) {
        int playerNum = ladder.getPlayerNum();
        int ladderHeight = ladder.getMaxLadderHeight();
        return Math.round((float) playerNum / 3) * ladderHeight;
    }
}
