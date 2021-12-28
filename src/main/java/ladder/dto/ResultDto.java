package ladder.dto;

import ladder.domain.Ladder;
import ladder.domain.Players;

public class ResultDto {

    private final LadderDto ladderDto;
    private final PlayersDto playersDto;

    public ResultDto(LadderDto ladderDto, PlayersDto playersDto) {
        this.ladderDto = ladderDto;
        this.playersDto = playersDto;
    }

    public static ResultDto valueOf(Ladder ladder, Players players) {
        LadderDto ladderDto = LadderDto.ladderToDto(ladder);
        PlayersDto playersDto = PlayersDto.playersToDto(players);
        return new ResultDto(ladderDto, playersDto);
    }

    public LadderDto getLadderDto() {
        return ladderDto;
    }

    public PlayersDto getPlayersDto() {
        return playersDto;
    }
}
