package com.cold.ladderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameInfo {
  private int width;
  private int height;
  private List users;
  private Scanner scanner = new Scanner(System.in);

  public void setValues() {
    inputUsers();
    inputHeight();
    width = users.size()-1;
  }

  public void inputHeight() {
    boolean check = false;
    while (!check) {
      System.out.println(Pattern.INPUT_HEIGHT_STMT);
      height = scanner.nextInt();
      check = validateInput(height);
    }
  }

  private boolean validateInput(int input) {
    return input > 0;
  }

  public void inputUsers(){
    users = new ArrayList<>();
    boolean check = false;
    while (!check) {
      users.clear();
      System.out.println(Pattern.INPUT_USERS);
      check = parseUsers();
    }
  }

  private boolean parseUsers(){
    String usersFromInput = scanner.next();
    for (String user : usersFromInput.split(",")) {
      if(!validateUser(user)) return false;
      users.add(user);
    }
    return true;
  }

  private boolean validateUser(String user){
    return user.length()<6 && user.length() >0 ? true : false;
  }

}
