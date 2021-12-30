package util;

import model.Player;

import java.util.*;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public final class CustomScanner {
    private final Scanner scanner;

    public CustomScanner() {
        this.scanner = new Scanner(System.in);
    }

    public int nextBoundedInt(int infimum, int supremum, String message){
        Integer value;
        System.out.println(message);

        do {
            value = readBoundedInt(infimum, supremum);
        } while (value == null);

        return value;
    }

    private Integer readBoundedInt(int infimum, int supremum){
        int value;

        try{
            value = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("정수 값을 입력해 주세요.");
            scanner.nextLine();
            return null;
        }

        return verifyBoundedInt(infimum, supremum, value);
    }

    private Integer verifyBoundedInt(int infimum, int supremum, int value){
        if(infimum > value || value > supremum) {
            System.out.println(infimum + " 이상 " + supremum + " 이하의 값을 입력해 주세요.");
            return null;
        }

        return value;
    }

    public List<String> nextCommaSeperatedString(int numParticipant, int maxLength, String message){
        List<String> value;
        clearInputBuffer();
        do {
            value = readCommaSeperatedString(numParticipant, maxLength, message);
        } while (value == null);

        return value;
    }

    private void clearInputBuffer(){
        if(scanner.hasNextLine()){
            scanner.nextLine();
        }
    }

    private List<String> readCommaSeperatedString(int numParticipant, int maxLength, String message){
        String line;
        System.out.println(message);

        try{
            line = scanner.nextLine();
            return verifyCommaSeperatedString(numParticipant, maxLength, line.split(","));
        } catch (PatternSyntaxException e){
            System.out.println("정수 값을 입력해 주세요.");
            scanner.nextLine();
            return null;
        }
    }

    private List<String> verifyCommaSeperatedString(int numParticipant, int maxLength, String[] strings){
        if(strings.length != numParticipant) {
            System.out.println(numParticipant + "명의 이름을 쉼표로 구분하여 입력해주세요.");
            return null;
        }
        if(Arrays.stream(strings).filter(name -> name.trim().length() > maxLength).count() > 0){
            System.out.println("이름은 최대 " + maxLength + "자 까지 입력할 수 있습니다.");
            return null;
        }

        return Arrays.stream(strings).map(name -> name.trim()).collect(Collectors.toList());
    }
}
