import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    char[][] output;
    int N;
    int H;

    private void getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명 인가요");
        N = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        H = scanner.nextInt();
    }

    private void initOutput(){
        int n,h;
        n = N-1;
        h = H;
        if(h <= 0 || n < 0) {
            n = 0;
            h = 0;
        }
        output = new char[h][n];
    }

    private void makeLadder(){
        Random rand = new Random();
        for(int i=0; i<output.length; i++){
            for(int j=0; j<output[i].length; j++){
                if(rand.nextBoolean()){
                    output[i][j] = ' ';
                }else{
                    output[i][j] = '-';
                }
            }
        }
    }

    private void printOutput(){
        for(int i=0; i<output.length; i++){
            for(int j=0; j<output[i].length; j++){
                System.out.print('|');
                System.out.print(output[i][j]);
            }
            System.out.println('|');
        }
    }

    public static void main(String[] args){
        LadderGame lg = new LadderGame();
        lg.getInput();
        lg.initOutput();
        lg.makeLadder();
        lg.printOutput();
    }

}
