import java.util.Scanner;

public class LadderInfoScanner {
    LadderInfo getLadderInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int width = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        sc.close();
        return new LadderInfo(width,height);
    }
}
