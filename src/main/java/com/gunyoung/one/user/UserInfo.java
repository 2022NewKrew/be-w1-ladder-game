package com.gunyoung.one.user;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
    private List<User> users;

    private UserInfo(List<User> users) {
        this.users = users;
    }

    public static UserInfo of(String strOfNames) {
        List<User> listOfUser = new ArrayList<>();
        String[] names = strOfNames.split(",");
        for(String name: names) {
            listOfUser.add(new User(name));
        }
        return new UserInfo(listOfUser);
    }

    public List<User> getUsers() {
        return users;
    }

    public int getNumOfUsers() {
        return users.size();
    }
}
