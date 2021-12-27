import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    int num;
    int depth;
    ArrayList<ArrayList<String>> ladder;
    Random rd = new Random();

    Ladder(int num, int depth){
        this.num = num;
        this.depth = depth;
        this.ladder = new ArrayList<ArrayList<String>>(depth);
    }

    public void randomLine(){
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

    public void print(){
        for(int i=0;i<depth;i++){
            System.out.println(String.join("",ladder.get(i)));
        }
    }
}