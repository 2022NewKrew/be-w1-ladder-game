package ladder.view;

import ladder.dto.InputDTO;
import ladder.validation.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private InputView(){}

    public static InputDTO inputComponentOfLadder() throws IOException {
        String[] names = inputNameOfPeople();
        int height = inputHeightOfLadder();
        return new InputDTO(names,height);
    }


    private static int inputHeightOfLadder() throws IOException{
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height=stoi(br.readLine());
        Validation.heightValidation(height);
        return height;
    }

    private static String[] inputNameOfPeople() throws IOException{
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ");
        String[] nameOfPeopleAry = br.readLine().split(",");
        Validation.nameCountValidation(nameOfPeopleAry.length);
        return nameOfPeopleAry;
    }

    public static int stoi(String input){
        return Integer.parseInt(input);
    }

}
