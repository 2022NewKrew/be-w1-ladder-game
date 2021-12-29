package ladder.validation;

public class Validation {

    public static void heightValidation(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("0이상을 입력해주세요.");
        }
    }

    public static void nameCountValidation(int nameCntOfPeople) {
        if (nameCntOfPeople <= 1) {
            throw new IllegalArgumentException("사람을 2명이상 입력해주세요.");
        }
    }
}
