import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Ladder {

  int col, row;

  Ladder() {
    inputLadderSize();
  }

  private void inputLadderSize() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("참여할 사람은 몇 명인가요?");
    final int col = scanner.nextInt();

    System.out.println("최대 사다리 높이는 몇 개인가요?");
    final int row = scanner.nextInt();

    if (validateLadderSize(col, row)) {
      this.col = col;
      this.row = row;
    } else {
      System.out.println("양의 정수만 입력해주세요.");
      inputLadderSize();
    }
  }

  private boolean validateLadderSize(int col, int row) {
    return col > 0 & row > 0;
  }

  @Override
  public String toString() {
    final Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();

//    시각적 구분을 위한 한줄 공백
    stringBuilder.append("\n");

    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col - 1; j++) {
        stringBuilder.append(random.nextBoolean() ? "| " : "|-");
      }
      stringBuilder.append("|\n");
    }

    return stringBuilder.toString();
  }
}

public class Ladder1 {

  public static void main(String[] args) {
    Ladder ladder = new Ladder();
    System.out.println(ladder);
  }
}
