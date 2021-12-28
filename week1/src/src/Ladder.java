import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ladder {
    private ArrayList<Line> map;
    private int peopleNum;
    private int height;

    Ladder(){
        getInput();
        map = new ArrayList<>();
    }

    public void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        peopleNum = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    public void setMap(){
        for(int i = 0; i < this.height; i++){
            this.map.add(new Line(this.peopleNum));
        }
    }

    public void showMap(){
        for(Line line : map) {
            System.out.println(line);
        }
    }
}
