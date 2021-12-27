import java.util.Arrays;
import java.util.Scanner;

public class Ladder {
    int n_people;
    int max_height;
    char[][] arr;

    //constructor
    public Ladder(int n, int m) {
        this.n_people = n;
        this.max_height = m;
        build_column();
        build_steps();
    }

    // build base columns '|'
    public void build_column() {
        int n_col = 2*this.n_people -1;
        this.arr = new char[n_col][max_height];
        for (int i=0; i<this.arr.length; i++) {
            for (int j=0; j<this.arr[0].length; j+=2) {
                this.arr[i][j]='|';
            }
        }
        //System.out.println("\n arr"); // check array is well made
        //System.out.println(Arrays.deepToString(this.arr));
    }

    // build steps '-'
    public void build_steps() {
        for (int i=0; i<this.arr.length; i++) {
            for (int j=1; j<this.arr[0].length; j+=2) {
                double random_float = Math.random();
                if (random_float <0.5) { // make each step by 50% probability
                    this.arr[i][j]='-';
                }else{
                    this.arr[i][j]=' ';
                }
            }
        }
        //System.out.println("\n arr"); // check array is well made
        //System.out.println(Arrays.deepToString(this.arr));
    }

    // print ladder as string
    public void print_ladder() {
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