package upperleaf.laddergame.domain.connector;

import upperleaf.laddergame.domain.Ladder;

/**
 * 사다리에서 몇개의 Connection을 생성할것인지 결정하는 인터페이스 입니다.
 */
public interface ConnectionNumberPolicy {
    int getConnectionNumber(Ladder ladder);
}
