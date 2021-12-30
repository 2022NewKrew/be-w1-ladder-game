package dto;

import java.util.Collections;
import java.util.List;

public class InputDto {
    private final List<String> names;
    private final int height;

    public InputDto(List<String> names, int height) {
        this.names = names;
        this.height = height;
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int getHeight() {
        return height;
    }
}
