package ladder.dto;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Rewards;

public class InfoDto {

    private final LadderDto ladderDto;
    private final PlayersDto playersDto;
    private final RewardsDto rewardsDto;

    public InfoDto(LadderDto ladderDto, PlayersDto playersDto, RewardsDto rewardsDto) {
        this.ladderDto = ladderDto;
        this.playersDto = playersDto;
        this.rewardsDto = rewardsDto;
    }

    public static InfoDto valueOf(Ladder ladder, Players players, Rewards rewards) {
        LadderDto ladderDto = LadderDto.ladderToDto(ladder);
        PlayersDto playersDto = PlayersDto.playersToDto(players);
        RewardsDto rewardsDto = RewardsDto.rewardsToDto(rewards);
        return new InfoDto(ladderDto, playersDto, rewardsDto);
    }

    public LadderDto getLadderDto() {
        return ladderDto;
    }

    public PlayersDto getPlayersDto() {
        return playersDto;
    }

    public RewardsDto getRewardsDto() {
        return rewardsDto;
    }
}
