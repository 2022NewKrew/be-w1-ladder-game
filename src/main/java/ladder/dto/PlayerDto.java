package ladder.dto;

import ladder.domain.Player;

public class PlayerDto {

    private final String name;

    public PlayerDto(String name) {
        this.name = name;
    }

    public static PlayerDto valueOf(Player player) {
        return new PlayerDto(player.getName());
    }

    public String getName() {
        return name;
    }
}
