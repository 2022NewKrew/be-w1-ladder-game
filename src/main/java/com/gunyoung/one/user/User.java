package com.gunyoung.one.user;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<User> getListOfUserFromNames(String strOfNames) {
        List<User> listOfUser = new ArrayList<>();
        String[] names = strOfNames.split(",");
        for(String name: names) {
            listOfUser.add(new User(name));
        }
        return listOfUser;
    }
}
