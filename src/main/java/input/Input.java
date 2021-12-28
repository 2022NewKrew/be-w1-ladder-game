package input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    /**
     *  << 이름 글자수 제한 5글자 >>
     *  1. 클라이언트가 알아서 5글자 넘지 않게 입력
     *  2. 받고나서 5글자 넘으면 자르기 ✔
     *  3. 5글자 넘으면 Exception
     **/

    public static List<String> inputParticipantsName() {
        String beforeParsing = scanner.nextLine();
        return Arrays.asList(beforeParsing.split(","))
                .stream().map(name -> name.length() > 5 ? name.substring(0,5): name)
                .collect(Collectors.toList());
    }

    public static int inputHeight() {
        int height = scanner.nextInt();
        if(height < 1) throw new IllegalArgumentException("높이는 1 이상입니다.");
        return height;
    }
}
