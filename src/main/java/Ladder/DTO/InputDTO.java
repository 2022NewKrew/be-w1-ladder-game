package Ladder.DTO;

public class InputDTO {
    private final String[] nameArray;
    private final int height;

    public InputDTO(String[] names, int paramHeight) {
        nameArray = names;
        height = paramHeight;
    }

    public String[] getNameArray() {
        return nameArray;
    }

    public int getHeight() {
        return height;
    }
}
