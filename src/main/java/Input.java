import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private Input(){}

    public static int inputCountOfPeople() throws IOException {
        System.out.println("참여할 사람은 몇 명인가요?");
        return stoi(br.readLine());
    }

    public static int inputLadderOfHeight() throws IOException{
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return stoi(br.readLine());
    }

    public static int stoi(String input){
        return Integer.parseInt(input);
    }

}
