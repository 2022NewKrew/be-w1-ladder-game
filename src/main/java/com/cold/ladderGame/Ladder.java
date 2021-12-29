package com.cold.ladderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
  private final Character EXISTS_BRIDGE = '-';
  private final Character NON_EXISTS_BRIDGE = ' ';
  private final Character VERTICAL_LINE = 'ㅣ';

  private List<List<Boolean>> resultLadder;
  private Random random = new Random();

  public Ladder(int width, int height){
    createLadder(width, height);
  }

  private void createLadder(int width, int height) {
    resultLadder = new ArrayList<>(height);
    for (int row = 0; row < height; row++) {
      resultLadder.add(insertRow(width));
    }
  }

  private List insertRow(int width){
    List randomRow = new ArrayList<Boolean>(width);
    for(int col = 0;col<width;col++){
      randomRow.add(insertBridge(randomRow,col));
    }
    return randomRow;
  }

  private boolean insertBridge(List<Boolean> randomRow, int col) {
    if (col > 0 && randomRow.get(col - 1)) {
      return false;
    }
    return random.nextBoolean();
  }

  public void printLadder() {
    StringBuffer outputString = new StringBuffer();
    for(List row : resultLadder) {
      outputString = fillBufferRow(outputString, row);
      outputString.append(VERTICAL_LINE + "\n");
    }
    System.out.println(outputString);
  }

  private StringBuffer fillBufferRow(StringBuffer outputString, List<Boolean> row){
    for(Boolean bridge : row){
      outputString.append(VERTICAL_LINE);
      outputString.append(getBridge(bridge));
    }
    return outputString;
  }

  private Character getBridge(Boolean status) {
      return status ? EXISTS_BRIDGE : NON_EXISTS_BRIDGE;
  }
}
