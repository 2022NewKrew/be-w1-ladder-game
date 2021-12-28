import java.util.Scanner;


public class Ladder {
    public static int numOfPlayers;
    public static int height;
    public static void main(String[] args){
        getInfo();   // numOfPlayers, height 값들을 받아옴
        LadderGame.makeLadder(numOfPlayers, height);
        LadderGame.drawLadder(numOfPlayers, height);

    }

    public static void getInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        numOfPlayers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 얼마인가요?");
        height = scanner.nextInt();
    }
}