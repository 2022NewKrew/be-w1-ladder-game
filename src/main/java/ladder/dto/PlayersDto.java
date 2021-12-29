package ladder.dto;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Player;
import ladder.domain.Players;

public class PlayersDto {

    private final List<PlayerDto> playerDtos;

    public PlayersDto(List<PlayerDto> playerDtos) {
        this.playerDtos = playerDtos;
    }

    public static PlayersDto playersToDto(Players players) {
        final List<PlayerDto> playerDtos = new ArrayList<>();
        for (Player player : players.getPlayers()) {
            playerDtos.add(PlayerDto.valueOf(player));
        }
        return new PlayersDto(playerDtos);
    }

    public List<PlayerDto> getPlayerDtos() {
        return playerDtos;
    }
}
