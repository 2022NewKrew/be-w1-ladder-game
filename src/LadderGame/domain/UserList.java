package LadderGame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserList {
    // 클래스 변수 및 상수
    private static int firstNameLength;

    // 인스턴스 변수
    private final List<User> userList;

    public UserList(String inputName) throws Exception {
        checkEmptyInput(inputName);
        this.userList = splitInputNames(inputName);
        firstNameLength = this.userList.get(0).getName().length();
    }

    private void checkEmptyInput(String inputName) throws Exception {
        if (inputName.length() <= 0) {
            throw new Exception("이름을 입력해주세요.");
        }
    }

    private List<User> splitInputNames(String inputName) {
        List<String> nameList = new ArrayList<>(Arrays.asList(inputName.split(",")));

        return nameList.stream().map(User::new).collect(Collectors.toList());
    }

    public void setUserResult(int idx, String result) {
        userList.get(idx).setResult(result);
    }

    public int getNamesSize() {
        return userList.size();
    }

    public List<User> getUserList() {
        return userList;
    }

    public String getUserResult(String nameInput) {
        for (User user : userList) {
            if (user.getName().compareTo(nameInput) == 0) {
                return user.getResult();
            }
        }
        return "no result";
    }

    public String getUserResultAll() {
        StringBuilder result = new StringBuilder();
        for (User user : userList) {
            result.append(user.getNameResult()).append("\n");
        }
        return result.toString();
    }

    public static int getFirstNameLength(){
        return firstNameLength;
    }

}
