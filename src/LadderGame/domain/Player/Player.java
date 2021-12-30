package LadderGame.domain.Player;

public class Player {
    private static final int MAX_LENGTH_OF_NAME = 5;
    public String name;

    public Player(String name) {
        validatePlayerName(name);
        this.name = name;
    }

    private void validatePlayerName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("플레이어 이름은 1글자 이상이어야 합니다.");
        }

        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(MAX_LENGTH_OF_NAME + "글자 이상의 이름이 포함되어 있습니다.");
        }
    }
}
