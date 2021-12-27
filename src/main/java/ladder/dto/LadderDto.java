package ladder.dto;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;

public class LadderDto {

    private final List<LineDto> lineDtos;

    public LadderDto(List<LineDto> lineDtos) {
        this.lineDtos = lineDtos;
    }

    public static LadderDto ladderToDto(Ladder ladder) {
        final List<LineDto> lineDtos = new ArrayList<>();
        for (Line line : ladder.getLines()) {
            lineDtos.add(LineDto.lineToDto(line));
        }
        return new LadderDto(lineDtos);
    }

    public List<LineDto> getLineDtos() {
        return lineDtos;
    }
}
