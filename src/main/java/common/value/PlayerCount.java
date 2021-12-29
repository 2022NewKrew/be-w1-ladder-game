package common.value;

public class PlayerCount {

    private final int playerCount;

    public PlayerCount(int playerCount) {
        validatePlayerCount(playerCount);
        this.playerCount = playerCount;
    }

    public int getValue() {
        return playerCount;
    }

    private void validatePlayerCount(int playerCount) {
        if(playerCount < 0) {
            throw new IllegalArgumentException("사람수는 양수를 입력해주세요~");
        }
    }
}
