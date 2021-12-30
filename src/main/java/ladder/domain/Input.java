package ladder.domain;

import org.apache.commons.lang3.StringUtils;

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

class MultipleInput extends Input{
    protected ArrayList<String> cases;
    private static final String ERROR_MESSAGE = "조건에 맞지 않는 입력입니다.(빈 입력값 존재)";

    protected void getList() throws Exception {
        String currentInput = sc.nextLine();
        int countComma = StringUtils.countMatches(currentInput, ",") + 1;
        String[] inputs = currentInput.split(",");

        validCheck(inputs, countComma);
        cases = new ArrayList<>(Arrays.asList(inputs));
    }

    private void validCheck(String[] inputs, int countComma) throws Exception{
        if(inputs.length == 0 || inputs.length != countComma) {
            throw new Exception(ERROR_MESSAGE);
        }
    }

    public ArrayList<String> getInput(){
        return cases;
    }
    public int getSize() {return cases.size();}
}


class NameInput extends MultipleInput {
    public NameInput() throws Exception {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        getList();
    }
}

class ResultInput extends MultipleInput {
    private static final String ERROR_DIFFERENCE = "이름과 결과 갯수가 다릅니다.";

    public ResultInput(int numOfPeople) throws Exception {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        getList();
        int countResult = cases.size();
        differenceCheck(numOfPeople, countResult);
    }

    private void differenceCheck(int numOfPeople, int countResult) throws Exception {
        if(numOfPeople != countResult){
            throw new Exception(ERROR_DIFFERENCE);
        }
    }
}
