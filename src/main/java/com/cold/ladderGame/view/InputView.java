package com.cold.ladderGame.view;

import com.cold.ladderGame.utils.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputView {
  private int width;
  private int height;
  private List users;
  private Scanner scanner = new Scanner(System.in);

  public void setValues() throws Exception {
    inputUsers();
    inputHeight();
    width = users.size()-1;
  }

  public void inputHeight() throws Exception{
    System.out.println(Pattern.INPUT_HEIGHT_STMT);
    height = scanner.nextInt();
    if(!validateInput(height)) throw new Exception(Pattern.INPUT_HEIGHT_EXCEPTION);
  }

  private boolean validateInput(int input) {
    return input > 0;
  }

  public void inputUsers() throws Exception{
    users = new ArrayList<>();
    System.out.println(Pattern.INPUT_USERS);
    parseUsers();
  }

  private boolean parseUsers() throws Exception{
    String usersFromInput = scanner.next();
    for (String user : usersFromInput.split(",")) {
      if(!validateUser(user)) throw new Exception(Pattern.INPUT_USERS_EXCEPTION);
      users.add(user);
    }
    return true;
  }

  private boolean validateUser(String user){
    return user.trim().length() <= Pattern.MAX_USER_NAME &&
        user.trim().length() >= Pattern.MIN_USER_NAME;
  }
}
