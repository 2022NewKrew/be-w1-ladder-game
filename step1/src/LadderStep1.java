import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LadderStep1 {

    public static int people;
    public static int ladderHeight;
    public static char[][] ladder;

    public static void initLadder(){
        ladder = new char[ladderHeight][2*people-1];
        for(int i = 0; i < ladder.length; i++){
            for(int j = 0; j < ladder[i].length; j++){
                ladder[i][j] = j%2 == 0? '|' : ' ';
            }
        }
    }

    public static void printLadder(){
        for (char[] chars : ladder) {
            System.out.println(chars);
        }
    }

    public static void makeLadder(){
        Position position;
        int row;
        int col;
        ArrayList<Integer> randomNumberList = makeRandomNumberList((people-1)*ladderHeight);
        ArrayList<Position> positionList = makePositionList();
        for(int randomNumber : randomNumberList){
            position = positionList.get(randomNumber);
            row = position.getRow();
            col = position.getCol();
            ladder[row][col] = '-';
        }
    }

    public static ArrayList<Position> makePositionList(){
        int row;
        int col;
        ArrayList<Position> positionList = new ArrayList<>();
        for(int i = 0; i < people-1; i++){
            for(int j = 0; j < ladderHeight; j++){
                row = j;
                col = 2*i + 1;
                positionList.add(new Position(row,col));
            }
        }
        return positionList;
    }

    public static ArrayList<Integer> makeRandomNumberList(int bound){
        Random random = new Random();
        int count = random.nextInt(bound+1);
        int randomNumber;
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = 0; i < count; i++){
            while(true) {
                if (!numberList.contains(randomNumber = random.nextInt(bound))) {
                    numberList.add(randomNumber);
                    break;
                }
            }
        }
        return numberList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        people = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
        LadderStep1.initLadder();
        LadderStep1.makeLadder();
        LadderStep1.printLadder();
    }
}
