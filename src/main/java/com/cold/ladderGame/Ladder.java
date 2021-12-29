package com.cold.ladderGame;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
  private List<Line> resultLadder;
  private StringBuffer outputString;

  public Ladder(int width, int height){
    createLadder(width, height);
  }

  private void createLadder(int width, int height) {
    resultLadder = new ArrayList<Line>(height);
    for (int row = 0; row < height; row++) {
      resultLadder.add(new Line(width));
    }
  }

  public void printLadder(List users) {
    outputString = new StringBuffer();
    printUsers(users);
    for(Line row : resultLadder) {
      outputString = row.printLine(outputString);
      outputString.append("\n");
    }
    System.out.println(outputString);
  }

  private void printUsers(List<String> users){
    for(String user : users){
      outputString.append(user);
      outputString.append(" ".repeat(6-user.length()));
    }
    outputString.append("\n");
  }

}
