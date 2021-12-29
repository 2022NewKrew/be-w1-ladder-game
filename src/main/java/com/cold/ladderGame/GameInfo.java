package com.cold.ladderGame;

import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameInfo {
  private final String INPUT_WIDTH_STMT = "참여할 사람은 몇 명인가요?";
  private final String INPUT_HEIGHT_STMT = "최대 사다리 높이는 몇 개인가요?";

  private int width;
  private int height;
  private Scanner scanner = new Scanner(System.in);

  public void setValues() {
    inputWidth();
    inputHeight();
  }

  public void inputWidth() {
    boolean check = false;
    while (!check) {
      System.out.println(INPUT_WIDTH_STMT);
      width = scanner.nextInt()-1;
      check = validateInput(width);
    }
  }

  public void inputHeight() {
    boolean check = false;
    while (!check) {
      System.out.println(INPUT_HEIGHT_STMT);
      height = scanner.nextInt();
      check = validateInput(height);
    }
  }

  private boolean validateInput(int input) {
    return input > 0;
  }

}
