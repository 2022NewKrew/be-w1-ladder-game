import java.util.Scanner;

class Ladder {

  int col, row;

  public void inputLadderSize() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("참여할 사람은 몇 명인가요?");
    String col = scanner.nextLine().trim();

    System.out.println("최대 사다리 높이는 몇 개인가요?");
    String row = scanner.nextLine().trim();

    if (validateLadderSize(col, row)) {
      this.col = Integer.parseInt(col);
      this.row = Integer.parseInt(row);
    } else {
      System.out.println("양의 정수만 입력해주세요.");
      inputLadderSize();
    }
  }

  private boolean validateLadderSize(String col, String row) {
    int colNum, rowNum;

    try {
      colNum = Integer.parseInt(col);
      rowNum = Integer.parseInt(row);
    } catch (NumberFormatException e) {
      return false;
    }

    return colNum > 0 & rowNum > 0 ? true : false;
  }

  public void drawLadder() {
//    한줄 공백
    System.out.println();

    for (int i=0; i < this.row; i++) {
      for (int j=0; j < this.col - 1; j++) {
        System.out.print(Math.random() > 0.5 ? "| " : "|-");
      }
      System.out.println("|");
    }
  }
}

public class Ladder1 {

  public static void main(String[] args) {
//    인스턴스 생성
    Ladder ladder = new Ladder();

//    사용자 인풋
    ladder.inputLadderSize();

//    사다리 출력
    ladder.drawLadder();
  }
}
