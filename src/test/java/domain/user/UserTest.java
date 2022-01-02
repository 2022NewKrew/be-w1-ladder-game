package domain.user;

import constant.Constants;
import domain.user.dto.UserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void 이름은_정해진_최대_글자를_넘을수_없다() {
        assertThrows(IllegalStateException.class, () -> {
            String name = "";
            for (int i = 0; i < Constants.MAX_LENGTH_OF_NAME + 1; i++) {
                name += "a";
            }
            new User(new UserDto(name, 1));
        });
    }

}