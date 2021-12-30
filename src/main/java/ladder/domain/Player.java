package ladder.domain;

public class Player {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getNameWithGap(int ladderWidth, int nameGap) {
        return String.format("%" + (ladderWidth + nameGap) + "s", name);
    }
}
