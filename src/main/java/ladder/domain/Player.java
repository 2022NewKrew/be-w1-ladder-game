package ladder.domain;

public class Player {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getNameWithGap(int ladderWidth, int nameGap) {
        if (name.length() > ladderWidth) {
            return String.format("%" + (ladderWidth + nameGap) + "s", name.substring(0, 5));
        }
        return String.format("%" + (ladderWidth + nameGap) + "s", name);
    }

    public String getName() {
        return name;
    }
}
