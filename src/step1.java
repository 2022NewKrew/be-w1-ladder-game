import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class step1 {

    public static void main(String[] args){

        int people;
        int depth;

        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        people = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        depth = sc.nextInt();

        Ladder ladder = new Ladder(people, depth);
        ladder.randomLine();
        ladder.print();

    }

    public static class Ladder {
        int num;
        int depth;
        ArrayList<ArrayList<String>> ladder;
        Random rd = new Random();

        Ladder(int num, int depth){
            this.num = num;
            this.depth = depth;
            this.ladder = new ArrayList<ArrayList<String>>(depth);
        }

        void randomLine(){
            String current;
            for(int i=0;i<depth;i++){
                ArrayList<String> line = new ArrayList<>();
                for(int j=0;j<num*2-1;j++){
                    current = (j%2 == 0) ? "|" : (rd.nextInt(2) == 1) ? "-" : " ";
                    line.add(current);
                }
                this.ladder.add(line);
            }
        }

        void print(){
            for(int i=0;i<depth;i++){
                System.out.println(String.join("",ladder.get(i)));
            }
        }
    }

}
