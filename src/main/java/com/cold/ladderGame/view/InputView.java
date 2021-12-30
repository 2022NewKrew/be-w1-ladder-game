package com.cold.ladderGame.view;

import com.cold.ladderGame.domain.Ladder;
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
  private List results;
  private int selectedUserIdx;
  private Scanner scanner = new Scanner(System.in);

  public void setValues() throws Exception {
    inputUsers();
    inputResults();
    inputHeight();
    width = users.size()-1;
  }

  public void selectUser() throws Exception{
    System.out.println(Pattern.SELECT_USER_STMT);
    String selectedUser = scanner.next();
    if(users.contains(selectedUser)) selectedUserIdx = users.indexOf(selectedUser);
    else if(selectedUser.equals("all")) selectedUserIdx = Pattern.IDX_WHEN_SELECTED_ALL;
    else endGame();
  }

  private void endGame() throws Exception {
    System.out.println(Pattern.PRINT_END_GAME);
    throw new Exception(Pattern.SELCT_USER_EXCEPTION);
  }

  private void inputResults() throws Exception {
    results = new ArrayList<>();
    System.out.println(Pattern.INPUT_RESULT);
    parseResults();
  }

  private void parseResults() throws Exception {
    String usersFromInput = scanner.next();
    for (String user : usersFromInput.split(",")) {
      results.add(user);
    }
    validateResults();
  }

  private void validateResults() throws Exception{
    if(results.size() != users.size()) throw new Exception(Pattern.INPUT_RESULTS_EXCEPTION);
  }

  private void inputHeight() throws Exception{
    System.out.println(Pattern.INPUT_HEIGHT_STMT);
    height = scanner.nextInt();
    if(!validateInput(height)) throw new Exception(Pattern.INPUT_HEIGHT_EXCEPTION);
  }

  private boolean validateInput(int input) {
    return input > 0;
  }

  private void inputUsers() throws Exception{
    users = new ArrayList<>();
    System.out.println(Pattern.INPUT_USERS);
    parseUsers();
  }

  private void parseUsers() throws Exception{
    String usersFromInput = scanner.next();
    for (String user : usersFromInput.split(",")) {
      if(!validateUser(user)) throw new Exception(Pattern.INPUT_USERS_EXCEPTION);
      users.add(user);
    }
  }

  private boolean validateUser(String user){
    return user.trim().length() <= Pattern.MAX_USER_NAME &&
        user.trim().length() >= Pattern.MIN_USER_NAME;
  }
}
