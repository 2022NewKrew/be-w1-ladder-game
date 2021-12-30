package ladder.dto;

public class InputDTO {

    private String[] namesOfPeople;
    private int heightOfLadder;


    public InputDTO(String[] names, int height) {
        this.namesOfPeople = names;
        this.heightOfLadder = height;
    }

    public String[] getNamesOfPeople() {
        return namesOfPeople;
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }
}
