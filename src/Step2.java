import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step2 {
    public static void main(String[] args) throws IOException {
        //1. Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("참여할 사람은 몇 명인가요?");
        int people = Integer.parseInt(br.readLine());
        System.out.println("사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(br.readLine());

        //2. Make Ladders
        Ladder ladders = new Ladder(people, height);

        //3. Print Result
        System.out.println(ladders);
    }
}