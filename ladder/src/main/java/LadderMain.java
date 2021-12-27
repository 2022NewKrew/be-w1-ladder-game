import java.util.Scanner;

public class LadderMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇명인가요?");
        int numOfParticipants = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int numOfLadderHeight = sc.nextInt();

        Ladder ladder = new Ladder(numOfParticipants, numOfLadderHeight);
        ladder.build();
        ladder.printShape();
    }
}
