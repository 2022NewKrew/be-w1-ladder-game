package view;

import dto.InputDto;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    static final String NAMES_FORMAT_MESSAGE = "이름은 쉼표(,)로 구분하세요";
    static final String AWARDS_FORMAT_MESSAGE = "결과는 꽝 또는 숫자만 입력하시고 쉼표(,)로 구분하세요";

    private static final Pattern namesPattern = Pattern.compile("^[a-zA-Z]{1,5}(,[a-zA-Z]{1,5})*$");
    private static final Pattern moneyPattern = Pattern.compile("^((꽝)|[1-9][0-9]*)(,((꽝)|[1-9][0-9]*))*$");

    public static Optional<InputDto> input(Scanner scanner){
        try{
            List<String> peopleNames = inputNames(scanner);
            List<String> awardStrings = inputAwards(scanner);
            int height = inputHeight(scanner);

            return Optional.of(new InputDto(peopleNames, awardStrings, height));
        }catch (IllegalArgumentException illegalArgumentException){
            System.err.println(illegalArgumentException.getMessage());
            return Optional.empty();
        }
    }

    private static List<String> inputNames(Scanner scanner){
        System.out.println("참여할 사람 이름을 입력하세요. (".concat(NAMES_FORMAT_MESSAGE).concat(")"));

        String names = scanner.nextLine();
        validateNamesFormat(names);
        return List.of(names.split(","));
    }

    private static void validateNamesFormat(String names){
        if(!namesPattern.matcher(names).find()){
            throw new IllegalArgumentException(NAMES_FORMAT_MESSAGE);
        }
    }

    private static List<String> inputAwards(Scanner scanner){
        System.out.println("실행 결과를 입력하세요. (".concat(AWARDS_FORMAT_MESSAGE).concat(")"));

        String awards = scanner.nextLine();
        validateAwardsFormat(awards);
        return List.of(awards.split(","));
    }

    private static void validateAwardsFormat(String awards){
        if(!awards.equals("꽝") && !moneyPattern.matcher(awards).find()){
            throw new IllegalArgumentException(AWARDS_FORMAT_MESSAGE);
        }
    }

    private static int inputHeight(Scanner scanner){
        System.out.println("최대 사다리 높이는 몇인가요?");
        return scanner.nextInt();
    }
}
