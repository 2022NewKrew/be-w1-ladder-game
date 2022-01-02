package domain.user;

import domain.exception.UserNotFoundException;
import domain.user.dto.UserDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @Test
    void 참여자는_최소_한명은_있어야_한다() {
        assertThrows(IllegalStateException.class, () -> new Users(List.of(new UserDto("", 1))));
        assertThrows(IllegalStateException.class, () -> new Users(List.of(new UserDto("     ", 1))));
    }

    @Test
    void 참여자_이름의_공백은_사라진다() {
        List<UserDto> userDtos = List.of(new UserDto("   김민수   ", 1),
                new UserDto("    김철수", 2), new UserDto("박혁거세    ", 3));
        Users users = new Users(userDtos);
        User user1 = users.getUser("김민수");
        assertEquals("김민수", user1.getName());
        User user2 = users.getUser("김철수");
        assertEquals("김철수", user2.getName());
        User user3 = users.getUser("박혁거세");
        assertEquals("박혁거세", user3.getName());

    }

    @Test
    void 참여자_이름으로_찾기() {
        List<UserDto> userDtos = List.of(new UserDto("김민수", 1),
                new UserDto("김철수", 2), new UserDto("박혁거세", 3));
        Users users = new Users(userDtos);
        User user1 = users.getUser("김민수");
        assertEquals("김민수", user1.getName());
        User user2 = users.getUser("김철수");
        assertEquals("김철수", user2.getName());
        User user3 = users.getUser("박혁거세");
        assertEquals("박혁거세", user3.getName());
    }

    @Test
    void 존재하지_않는_사용자_찾기() {
        List<UserDto> userDtos = List.of(new UserDto("김민수", 1),
                new UserDto("김철수", 2), new UserDto("박혁거세", 3));
        Users users = new Users(userDtos);
        assertThrows(UserNotFoundException.class, () -> users.getUser("김돌돌"));
    }

}