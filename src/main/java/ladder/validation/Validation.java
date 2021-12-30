package ladder.validation;

import ladder.exception.CountOfPeopleException;
import ladder.exception.HeightOfLadderException;
import ladder.exception.NameLengthException;

public class Validation {

    public static void heightValidation(int height) {
        if (height < 0) {
            throw new HeightOfLadderException("사다리 높이는 0 이상을 입력해주세요.");
        }
    }

    public static void nameValidation(String[] namesOfPeople){
        nameLengthValidation(namesOfPeople);
        nameCountValidation(namesOfPeople.length);
    }

    public static void nameCountValidation(int nameCntOfPeople) {
        if (nameCntOfPeople <= 1) {
            throw new CountOfPeopleException("사람을 2명이상 입력해주세요.");
        }
    }

    public static void nameLengthValidation(String[] namesOfPeople) {
        for(String name:namesOfPeople){
            if(name.length()>5)
                throw new NameLengthException("사람 이름은 최대 5글자로 입력해주세요");
        }
    }
}
