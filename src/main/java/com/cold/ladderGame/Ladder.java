package com.cold.ladderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ladder {

  private int width;
  private int height;
  private List<List<Boolean>> resultLadder;

  Scanner scanner = new Scanner(System.in);
  Random random = new Random();

  public void init() {
    setValues();
    createLadder();
  }

  void setValues() {
    inputWidth();
    inputHeight();
  }

  void inputWidth() {
    boolean check = false;
    while (!check) {
      System.out.println("참여할 사람은 몇 명인가요?");
      width = scanner.nextInt();
      check = validateInput(width);
    }
  }

  void inputHeight() {
    boolean check = false;
    while (!check) {
      System.out.println("최대 사다리 높이는 몇 개인가요?");
      height = scanner.nextInt();
      check = validateInput(height);
    }
  }

  boolean validateInput(int input) {
    return input > 0;
  }

  void createLadder() {
    resultLadder = new ArrayList<>(height);
    for (int row = 0; row < height; row++) {
      ArrayList<Boolean> randomRow = new ArrayList<>(width - 1);
      for (int col = 0; col < width - 1; col++) {
        randomRow.add(insertBridge(randomRow, col));
      }
      resultLadder.add(row, randomRow);
    }
  }

  boolean insertBridge(ArrayList<Boolean> tempRow, int col) {
    if (col > 0 && tempRow.get(col - 1)) {
      return false;
    }
    return random.nextBoolean();
  }

  public void printLadder() {
    StringBuffer outputString = new StringBuffer();
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width - 1; col++) {
        outputString.append("ㅣ");
        outputString.append(getBridge(resultLadder.get(row).get(col)));
      }
      outputString.append("ㅣ\n");
    }
    System.out.println(outputString);
  }

  Character getBridge(Boolean status) {
      if (status) {
          return '-';
      }
    return ' ';
  }
}
