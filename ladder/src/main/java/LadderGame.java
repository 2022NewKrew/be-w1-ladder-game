import java.util.Scanner;
import java.util.ArrayList;


public class LadderGame {
    public static int numOfPlayers;
    public static int height;
    public static void main(String[] args){
        getValue();   // numOfPlayers, height 값들을 받아옴
    }
    public static void getValue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        numOfPlayers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 얼마인가요?");
        height = scanner.nextInt();
    }
}