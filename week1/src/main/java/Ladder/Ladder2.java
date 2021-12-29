package Ladder;

import java.util.Random;
import java.util.Scanner;

public class Ladder2 {

  int col, row;

  Ladder2() {
    inputLadderSize();
  }

  private void inputLadderSize() {
    this.col = inputLadderColSize();
    this.row = inputLadderRowSize();
  }

  private int inputLadderColSize() {
    System.out.println("참여할 사람은 몇 명인가요?");
    return inputPositiveInteger();
  }

  private int inputLadderRowSize() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return inputPositiveInteger();
  }

  private int inputPositiveInteger() {
    final Scanner scanner = new Scanner(System.in);
    try {
      final int num = scanner.nextInt();
      if (num <= 0) throw new RuntimeException();
      return num;
    } catch (Exception e) {
      System.out.println("양의 정수를 입력해주세요.");
      return inputPositiveInteger();
    }
  }

  @Override
  public String toString() {
    final Random random = new Random();
    final StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("\n");  // 시각적 구분을 위한 한줄 공백
    stringBuilder.append(drawLadder());

    return stringBuilder.toString();
  }

  private String drawLadder() {
    final StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < this.row; i++)
      stringBuilder.append(drawLadderRow() + "\n");

    return stringBuilder.toString();
  }

  private String drawLadderRow() {
    final Random random = new Random();
    final StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < this.col - 1; i++)
      stringBuilder.append(random.nextBoolean() ? "| " : "|-");
    stringBuilder.append("|");

    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    Ladder2 ladder2 = new Ladder2();
    System.out.println(ladder2);
  }
}
