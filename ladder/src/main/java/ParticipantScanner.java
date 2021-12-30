import exception.IllegalInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ParticipantScanner {
    private static final Scanner sc = new Scanner(System.in);

    public static List<Participant> getParticipants(String message, int maxNameLength) {
        while(true) {
            System.out.println(message);
            try {
                List<String> nameList = getParticipantsName(sc.nextLine(), maxNameLength);
                return nameList.stream()
                        .map(Participant::new)
                        .collect(Collectors.toList());
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<String> getParticipantsName(String nameList, int maxNameLength) {
        List<String> nameInput = Arrays.asList(nameList.split(","));
        if (nameInput.stream().anyMatch(name -> name.length() > maxNameLength))
            throw new IllegalInputException("최대 글자수를 넘은 이름이 있습니다.");
        return nameInput;
    }
}
