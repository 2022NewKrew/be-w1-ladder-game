package laddergame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int person;
        int height;
        
        System.out.println("참여할 사람은 몇 명인가요?");
        person = Integer.parseInt(br.readLine());
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = Integer.parseInt(br.readLine());
        
        Ladder ladder = new Ladder(person, height);
        ladder.setLadder();
        ladder.printLadder();
    }
}