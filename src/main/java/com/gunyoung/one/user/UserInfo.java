package com.gunyoung.one.user;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
    private final List<User> users;

    private UserInfo(List<User> users) {
        this.users = users;
    }

    public static UserInfo of(String strOfNames) {
        List<User> listOfUser = new ArrayList<>();
        String[] names = strOfNames.split(",");
        for (String name : names) {
            listOfUser.add(new User(name));
        }
        return new UserInfo(listOfUser);
    }

    public int getNumOfUsers() {
        return users.size();
    }

    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        for (User user : users) {
            userNames.add(user.getName());
        }
        return userNames;
    }
}
