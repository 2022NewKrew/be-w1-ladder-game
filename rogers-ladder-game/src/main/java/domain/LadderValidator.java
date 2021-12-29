package domain;

import java.util.List;

public class LadderValidator {
    public static void validate(List<String> peopleNames, int ladderHeight){
        validateNames(peopleNames);
        validateLadderHeight(ladderHeight);
    }

    private static void validateNames(List<String> peopleNames){
        for(String name : peopleNames){
            validateName(name);
        }
    }

    private static void validateName(String peopleName){
        if(peopleName.length() > 5){
            throw new IllegalArgumentException("사용자의 이름은 5글자 이내여야 합니다.");
        }
    }

    private static void validateLadderHeight(int ladderHeight){
        if(ladderHeight <= 0){
            throw new IllegalArgumentException("사다리의 높이는 양수여야합니다.");
        }
    }
}
