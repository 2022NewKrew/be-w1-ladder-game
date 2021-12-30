package Ladder.DTO;

import java.util.List;

public class InputDTO {
    private final List<String> nameArray;
    private final int height;

    public InputDTO(List<String> names, int paramHeight) {
        nameArray = names;
        height = paramHeight;
    }

    public List<String> getNameArray() {
        return nameArray;
    }

    public int getHeight() {
        return height;
    }
}
