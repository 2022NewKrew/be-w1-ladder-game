package laddergame;

import java.util.Random;
import java.util.Scanner;

class Ladder{
    private int playerNum;      // 참가자 수
    private int height;         // 사다리의 높이
    private boolean[][] line;   // 선이 그어진 위치

    Ladder(){}
    Ladder(int pn, int h){
        this.playerNum = pn;
        this.height = h;
        this.line = new boolean[pn-1][h];
    }

    // 사다리 사이 선긋기 메소드
    public void makeLine(){
        Random random = new Random();
        for(int i=0; i<this.height; i++){
            for(int j=0; j<this.playerNum-1; j++){
                // 연속된 라인 생성 방지
                if(j>0 && this.line[j-1][i]){
                    this.line[j][i] = false;
                    continue;
                }
                this.line[j][i] = random.nextBoolean();
            }
        }
    }

    // 사다리 출력 메소드
    public void printLadder(){
        for(int i=0; i<this.height; i++){
            for(int j=0; j<this.playerNum-1; j++){
                System.out.print("|");
                if(this.line[j][i])
                    System.out.print("-");
                else
                    System.out.print(" ");
            }
            System.out.print("|\n");
        }
    }
}

public class LadderGame {
    public static void main(String[] args){
        int n, m;
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        n = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        m = sc.nextInt();

        Ladder ladder = new Ladder(n,m);    // 사다리 인스턴스 생성
        ladder.makeLine();                  // 사다리 선 긋기
        ladder.printLadder();               // 사다리 출력
    }
}
