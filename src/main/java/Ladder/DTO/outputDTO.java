package Ladder.DTO;

public class InputDTO {
    private final int numPeople;
    private final int height;

    public InputDTO(int paramNumPeople, int paramHeight) {
        numPeople = paramNumPeople;
        height = paramHeight;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public int getHeight() {
        return height;
    }
}
