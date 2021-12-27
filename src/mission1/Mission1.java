package mission1;

import java.util.Random;
import java.util.Scanner;

public class Mission1 {
    int n;
    int m;
    char[][] ladder;

    Mission1(){
        input();
        createLadder();
    }
    Mission1(int n, int m){
        this.n = n;
        this.m = m;
        createLadder();
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        m = sc.nextInt();

        ladder = new char[m][n - 1];
    }

    char isLadder(){
        Random random = new Random();
        if(random.nextInt(2) == 0)
            return ' ';
        return '-';
    }
    void createLadder() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                ladder[i][j] = isLadder();
            }
        }
    }

    void output(){
        for(int i=0;i<m;i++) {
            System.out.print('|');
            for (int j = 0; j < n - 1; j++) {
                System.out.print(ladder[i][j]);
                System.out.print('|');
            }
            System.out.println();
        }
    }
}