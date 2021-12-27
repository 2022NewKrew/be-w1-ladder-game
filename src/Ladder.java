import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ladder {

    long people, height;
    Line[] lineStatus;

    public Ladder() {
        setvalue();
    }

    public void setvalue() {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        this.people = sc.nextLong();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.height = sc.nextLong();

    }

    public void initLine() {

        lineStatus = new Line[(int) this.height];
        for(int i = 0 ; i < height ; i++) {
            lineStatus[i] = new Line();
            lineStatus[i].value = new ArrayList<Long>();
        }
    }

    public void shuffle() {
        Random rd = new Random();

        for(int i = 0 ; i < height ; i++) {
            int lineSize = rd.nextInt((int) people);
            for(int j = 0 ; j < lineSize ; j++)
                lineStatus[i].value.add((long) rd.nextInt((int) people) - 1);

            lineStatus[i].value.sort(Long::compareTo);
        }
    }


    public void display() {
        for(int i = 0 ; i < height ; i++) {
            int lineIdx = 0;

            for(int j = 0 ; j < people ; j++) {
                System.out.print((i > 0 && j == 0? "\n" : "") + "|");
                System.out.print(lineIdx < lineStatus[i].value.size() && lineStatus[i].value.get(lineIdx) == j ? "-" : " ");

                while(lineIdx < lineStatus[i].value.size() && lineStatus[i].value.get(lineIdx) == j ) {
                    lineIdx++;
                }
            }
        }
    }

}
