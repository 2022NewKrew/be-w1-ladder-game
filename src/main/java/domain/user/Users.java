package domain.user;

import domain.exception.UserNotFoundException;
import domain.sadari.SadariMapStatus;
import domain.user.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<UserDto> userDtos) {
        users = initializeUsers(userDtos);
        validateEmptyUsers();
    }

    private List<User> initializeUsers(List<UserDto> userDtos) {
        return userDtos.stream()
                .map(User::new)
                .filter(User::isNotEmptyName)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateEmptyUsers() {
        if (users.isEmpty()) {
            throw new IllegalStateException("참여할 사람의 이름을 입력하셔야 합니다.");
        }
    }

    public int getNumberOfUser() {
        return users.size();
    }

    public void printUsers() {
        for (User user : users) {
            user.print();
        }
        System.out.println();
    }

    public User getUser(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElseThrow(() -> {
                    throw new UserNotFoundException("참여자를 찾을수 없습니다.");
                });
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toUnmodifiableList());
    }

}
