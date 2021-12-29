import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] io(){
        int[] outputs = new int[2];
        Scanner sc= new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        outputs[0] = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        outputs[1] = sc.nextInt();
        return outputs;
    }
    static ArrayList getLadderList(int[] outputs){
        int part = outputs[0];
        int height = outputs[1];
        ArrayList<ArrayList<String>> ladderList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ArrayList<String> floorList = new ArrayList<>();
            for (int j = 0; j < part; j++) {
                floorList.add("|");
                if(j!=part-1) floorList.add(getRandomLadder());
            }
            ladderList.add(floorList);
        }
        return ladderList;
    }
    static String getRandomLadder(){
        double dValue = Math.random();
        int randomValue = (int)(dValue * 2);
        if(randomValue==0){
            return " ";
        }
        else return "-";
    }
    static void printLadder(ArrayList<ArrayList> ladderList){
        for (ArrayList<String> floorList: ladderList) {
            for (String ladder:floorList) {
                System.out.print(ladder);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] outputs = io();
        ArrayList ladderList = getLadderList(outputs);
        printLadder(ladderList);

    }

}
