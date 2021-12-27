import java.io.*;
import java.util.Scanner;

public class Main {

    static int peopleCnt,ladderHeight;

    public static void main(String[] args) throws IOException {
        input();
        ladderGame game = new ladderGame(peopleCnt,ladderHeight);
        game.printLadder();
    }

    public static void input(){
        Scanner in=new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        peopleCnt=in.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight=in.nextInt();
    }

}

class ladderGame{
    private char[][] ladder;


    ladderGame(int peopleCnt,int ladderHeight){
        ladder=new char[ladderHeight][peopleCnt];
        makeLadder(peopleCnt,ladderHeight);
    }

    public void makeLadder(int peopleCnt,int ladderHeight){
        double rand;
        for(int row=0;row<ladderHeight;row++){
            for(int col=0;col<peopleCnt-1;col++){
                rand= Math.random();
                ladder[row][col]=(rand<0.5)?' ':'-';
            }
        }
    }

    public void printLadder() throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int row=0;row<ladder.length;row++){
            for(int col=0;col<ladder[0].length-1;col++){
                wr.append('|');
                wr.append(ladder[row][col]);
            }
            wr.append('|');
            wr.newLine();
        }
        wr.flush();
        wr.close();
    }

}
