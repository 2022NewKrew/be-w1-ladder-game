package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultScanner extends StringListScanner{
    @Override
    public List<String> getInput() {
        boolean valid;
        List<String> results;
        do{
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            String input = scanner.nextLine()
                    .replaceAll(" ", "");
            valid = validateNumOfElement(input);
            results = new ArrayList<>(Arrays.asList(input.split(",")));
        }while(!valid);
        return results;
    }
}
