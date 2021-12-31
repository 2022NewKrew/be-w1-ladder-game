package view;

import repository.ResultMapper;

import java.util.Scanner;

public class UserInteractController {
    private final Scanner sc;
    public UserInteractController() { sc = new Scanner(System.in); }

    public void checkResult(ResultMapper resultMapper){
        String input = getInput();
        while(!input.equals("춘식이")){
            printResult(resultMapper, input);
            input = getInput();
        }
        System.out.println("게임을 종료합니다.");
    }

    public String getInput(){
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }

    public void printResult(ResultMapper resultMapper, String input){
        if(input.equalsIgnoreCase("all")){
            System.out.println(resultMapper.printAll());
            return;
        }
        if(!resultMapper.isKey(input)) {
            System.out.println("존재하지 않는 사람입니다.");
            return;
        }
        System.out.println("실행 결과");
        System.out.println(resultMapper.getResult(input));
    }
}
