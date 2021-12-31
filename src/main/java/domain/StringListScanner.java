package domain;

import java.util.List;
import java.util.Scanner;

public abstract class StringListScanner {
    Scanner scanner = new Scanner(System.in);

    public abstract List<String> getInput();

    protected boolean validateNumOfElement(String input){
        if(!input.contains(",")){
            System.out.println("둘 이상 입력해주세요.");
            return false;
        }
        return true;
    }
}
