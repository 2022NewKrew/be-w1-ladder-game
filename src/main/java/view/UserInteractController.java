package view;

import java.util.HashMap;
import java.util.Scanner;

public class UserInteractController {
    private final Scanner sc;
    public UserInteractController() { sc = new Scanner(System.in); }

    public void checkResult(HashMap<String, String> resultMapping){
        String input = getInput();
        while(!input.equals("춘식이")){
            printResult(resultMapping, input);
            input = getInput();
        }
    }

    public String getInput(){
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }

    public void printResult(HashMap<String, String> resultMapping, String input){
        if(input.equalsIgnoreCase("all")){
            printAll(resultMapping);
            return;
        }
        if(!resultMapping.containsKey(input)) {
            System.out.println("존재하지 않는 사람입니다.");
            return;
        }
        System.out.println(input + ": " + resultMapping.get(input));
    }

    public void printAll(HashMap<String, String> resultMapping){
        for(String name: resultMapping.keySet()){
            System.out.println(name + ": " + resultMapping.get(name));
        }
    }
}
