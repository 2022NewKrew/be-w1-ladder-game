package domain;

import repository.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameScanner extends StringListScanner{
    @Override
    public List<String> getInput() {
        boolean valid;
        List<String> names;
        do{
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 다섯글자 이하로 쉼표(,)로 구분하세요)");
            String input = scanner.nextLine()
                    .replaceAll(" ", "");
            valid = validateNumOfElement(input);
            names = new ArrayList<>(Arrays.asList(input.split(",")));
        }while(!(valid && validateLength(names)));
        return names;
    }

    private boolean validateLength(List<String> names){
        boolean anyNotValid = names.stream()
                .allMatch(name ->
                        name.length() <= Constant.MAX_NAME_LENGTH && name.length() >= Constant.MIN_NAME_LENGTH);
        if(!anyNotValid){
            System.out.println("한 글자 이상, 다섯 글자 이하의 이름을 사용해주세요.");
            return false;
        }
        return true;
    }
}
