package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    private int userNum;
    private int ladderHeight;
    private ArrayList<Ladder> ladders;

    public void inputUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        userNum = scanner.nextInt();
    }

    public void inputLadder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
        Ladder.initLadder(ladderHeight);
    }

    public void createLadders() {
        ladders = new ArrayList<>();
        for (int i = 0; i < userNum; i++) {
            ladders.add(new Ladder());
        }
    }

    public void connectRandomBridges(){
        int count = 0;
        Random random = new Random();
        int bridgeNum = random.nextInt((userNum - 1) * ladderHeight);

        while(count < bridgeNum){
            int ladderIdx = random.nextInt(userNum-1);
            int heightIdx = random.nextInt(ladderHeight);

            Ladder ladder = ladders.get(ladderIdx);
            if(!ladder.isConnectedAt(heightIdx)){
                ladder.connectBridge(heightIdx);
                count += 1;
            }
        }
    }

    public void printLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            System.out.println(printLadderLineAt(i));
        }
    }

    public String printLadderLineAt(int index) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < userNum; i++){
            builder.append(Ladder.ladderLine.charAt(index));

            if(i == userNum-1) continue;
            builder.append(ladders.get(i).getBridgeLine().charAt(index));
        }
        return builder.toString();
    }
}
