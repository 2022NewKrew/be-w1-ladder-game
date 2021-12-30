package ladder;

import ladder.domain.Ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderGame {
    public static void main(String[] args) throws IOException {
        //1. Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String stringEntry = br.readLine();
        System.out.println("사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(br.readLine());

        //2. Make Ladders
        Ladder ladders = new Ladder(stringEntry, height);

        //3. Print Result
        System.out.println(ladders);
    }
}
