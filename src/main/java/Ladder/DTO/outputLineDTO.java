package Ladder.DTO;

import java.util.List;

public class outputLineDTO {
    private final List<String> line;

    public outputLineDTO(List<String> paramLine) {
        line = paramLine;
    }

    public List<String> getLine() {
        return line;
    }
}