import java.util.Scanner;

public class SadariGame {

    public static void main(String[] args) {
        Sadari sadari = input();
        sadari.startGame();
    }

    private static Sadari input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Users users = new Users(sc.nextLine().split(","));
        int numberOfPeople = users.getNumberOfUser();
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int numberOfLadder = sc.nextInt();

        return new Sadari(users, numberOfPeople, numberOfLadder);
    }
}
