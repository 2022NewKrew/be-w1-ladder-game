import java.util.Scanner;

public class UserService {
    private Ladder ladder;
    private int peopleNum;
    private int height;
    private static Scanner sc;

    UserService(){
        getInput();
        ladder = new Ladder(peopleNum, height);
    }

    public void getInput(){
        sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        this.peopleNum = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.height = sc.nextInt();
        sc.close();
    }

    public void setMap(){
        ladder.setMap();
    }

    public void showMap(){
        ladder.showMap();
    }
}
