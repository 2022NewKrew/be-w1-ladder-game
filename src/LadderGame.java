import java.util.*;

public class LadderGame {

    // 자주 쓸 것 같은 애들은 밖에다 빼놓기
    static int peopleCount;
    static int ladderCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<String>> ladder = new ArrayList<>();

        while(true) {
            try {
                System.out.println("참여할 사람은 몇 명인가요?");
                peopleCount = sc.nextInt();
                System.out.println("최대 사다리 높이는 몇 개인가요?");
                ladderCount = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못 된 입력입니다. 다시 입력해주세요.\n");
                sc = new Scanner(System.in);
            }
        }

        // ladder 생성
        generateLadder(ladder);

        // ladder 출력
        printLadder(ladder);
    }

    static void generateLadder(ArrayList<ArrayList<String>> ladder) {
        for (int i = 0; i < ladderCount; i++) {
            ArrayList<String> tempLadder = new ArrayList<>();
            for (int j = 0; j < (peopleCount * 2) - 1; j++) {
                if (j % 2 == 0) {
                    tempLadder.add("|");
                } else {
                    int rand = (int) (Math.random() * 10);
                    tempLadder.add(rand % 2 == 0 ? "-" : " ");
                }
            }
            ladder.add(tempLadder);
        }
    }

    static void printLadder(ArrayList<ArrayList<String>> ladder){
        for (int i = 0; i < ladderCount; i++) {
            ArrayList<String> tempLadder = ladder.get(i);
            for (int j = 0; j < (peopleCount * 2) - 1; j++) {
                System.out.print(tempLadder.get(j));
            }
            System.out.println();
        }
    }
}
