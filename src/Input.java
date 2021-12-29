import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Input {
    protected final Scanner sc = new Scanner(System.in);
}

class DepthInput extends Input {
    private final int depth;
    public DepthInput(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        depth = sc.nextInt();
    }

    public int getInput(){
        return depth;
    }
}

class multipleInput extends Input{
    protected ArrayList<String> cases;

    protected void getInput() {
        String[] inputs = sc.nextLine().split(",");
        cases = new ArrayList<>(Arrays.asList(inputs));
    }

    public ArrayList<String> getCases(){
        return cases;
    }
    public int getSize() {return cases.size();}
}


class NameInput extends multipleInput {
    public NameInput(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        getInput();
    }
}

class ResultInput extends multipleInput {
    public ResultInput(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        getInput();
    }
}
