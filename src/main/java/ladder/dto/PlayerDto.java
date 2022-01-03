package ladder.dto;

import java.util.Objects;
import ladder.domain.Player;

public class PlayerDto {

    private final String name;

    public PlayerDto(String name) {
        this.name = name;
    }

    public static PlayerDto valueOf(Player player) {
        return new PlayerDto(player.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerDto playerDto = (PlayerDto) o;
        return Objects.equals(name, playerDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
