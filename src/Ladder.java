import java.util.Arrays;
import java.util.Random;

public final class Ladder {
    private final int n_people;
    private final int max_height;
    private char[][] arr; // 크기를 나중에 할당해서 그런지 final을 설정할 수가 없네요ㅠㅠ 다른 방법이 있을까요..?
    Random random = new Random();


    //constructor
    public Ladder(int n, int m) {
        this.n_people = n;
        this.max_height = m;

        buildColumns();
        buildSteps();
    }

    // build base columns '|'
    public void buildColumns() {
        int n_col = 2 * this.n_people -1;

        this.arr = new char[n_col][max_height];
        for (int i=0; i<this.arr.length; i++) {
            for (int j=0; j<this.arr[0].length; j+=2) {
                this.arr[i][j]='|';
            }
        }
    }


    // build steps '-'
    public void buildSteps() {
        for (int i=0; i<this.arr.length; i++) {
            for (int j=1; j<this.arr[0].length; j+=2) {

                float random_float = random.nextFloat();

                if (random_float <0.5) { // make each step by 50% probability
                    this.arr[i][j]='-';
                }else{
                    this.arr[i][j]=' ';
                }
            }
        }
    }

    // print ladder as string
    public void printLadder() {

        for (char[] each_row : this.arr) {
            StringBuilder sb = new StringBuilder();
            for (char ch : each_row) {
                sb.append(ch);
            }
            String row = sb.toString();
            System.out.println(row);

        }
    }
}