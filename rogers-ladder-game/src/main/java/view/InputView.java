package view;

import dto.InputDto;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    static final String NAMES_FORMAT_MESSACE = "이름은 쉼표(,)로 구분하세요";

    private static final Pattern namesPattern = Pattern.compile("^[a-zA-Z]{1,5}(,[a-zA-Z]{1,5})*$");

    public static Optional<InputDto> input(InputStream inputStream){
        InputDto inputDto = null;

        try(Scanner scanner = new Scanner(inputStream)){
            inputDto = new InputDto(inputNames(scanner), inputHeight(scanner));
        }catch (IllegalArgumentException illegalArgumentException){
            System.err.println(illegalArgumentException.getMessage());
        }

        return Optional.ofNullable(inputDto);
    }

    private static List<String> inputNames(Scanner scanner){
        System.out.println("참여할 사람 이름을 입력하세요. (".concat(NAMES_FORMAT_MESSACE).concat(")"));

        String names = scanner.nextLine();
        validateNamesFormat(names);

        return List.of(names.split(","));
    }

    private static void validateNamesFormat(String names){
        if(!namesPattern.matcher(names).find()){
            throw new IllegalArgumentException(NAMES_FORMAT_MESSACE);
        }
    }

    private static int inputHeight(Scanner scanner){
        System.out.println("최대 사다리 높이는 몇인가요?");
        return scanner.nextInt();
    }
}
