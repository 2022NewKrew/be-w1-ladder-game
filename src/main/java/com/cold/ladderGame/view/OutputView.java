package com.cold.ladderGame.view;

import com.cold.ladderGame.domain.Ladder;
import com.cold.ladderGame.domain.Line;
import com.cold.ladderGame.utils.Pattern;
import java.util.List;

public class OutputView {
  private StringBuffer outputString;

  public void printLadder(Ladder ladder, List users) {
    outputString = new StringBuffer();
    printUsers(users, outputString);
    for(Line line : ladder.getResultLadder()) {
      printLine(line);
      outputString.append("\n");
    }
    System.out.println(outputString);
  }

  private void printLine(Line line){
    for(Boolean element : line.getRow()){
      outputString.append(Pattern.VERTICAL_LINE);
      outputString.append(getBridge(element));
    }
    outputString.append(Pattern.VERTICAL_LINE);
  }

  private String getBridge(Boolean element){
    return element ? Pattern.EXISTS_BRIDGE : Pattern.NON_EXISTS_BRIDGE;
  }

  private void printUsers(List<String> users, StringBuffer outputString){
    for(String user : users){
      outputString.append(user);
      outputString.append(" ".repeat(Pattern.SPACE_BETWEEN_USERS -user.length()));
    }
    outputString.append("\n");
  }

}
